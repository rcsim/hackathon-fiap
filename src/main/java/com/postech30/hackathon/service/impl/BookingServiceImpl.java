package com.postech30.hackathon.service.impl;

import com.postech30.hackathon.dto.AdditionalDTO;
import com.postech30.hackathon.dto.BookingDTO;
import com.postech30.hackathon.entity.Additional;
import com.postech30.hackathon.entity.Booking;
import com.postech30.hackathon.exceptions.BookingNotFoundException;
import com.postech30.hackathon.exceptions.ResourceNotFoundException;
import com.postech30.hackathon.mapper.BookingMapper;
import com.postech30.hackathon.repository.AdditionalRepository;
import com.postech30.hackathon.repository.BookingRepository;
import com.postech30.hackathon.repository.ClientRepository;
import com.postech30.hackathon.service.BookingService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    //    @Autowired
//    private RoomRepository roomRepository;
    @Autowired
    private AdditionalRepository additionalRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private EmailServiceImpl emailService;

    @Override
    public Page<BookingDTO> getAll(Pageable pageable) {
        Page<Booking> page;
        page = bookingRepository.findAll(pageable);

        return page.map(BookingMapper::toDTO);
    }

    @Override
    public BookingDTO getBookingById(Long id) throws BookingNotFoundException {
        return BookingMapper.toDTO(bookingRepository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException("Reserva não encontrada")));
    }


    @Override
    public BookingDTO book(BookingDTO bookingDto) throws MessagingException {
        var booking = toEntity(bookingDto);
        Booking savedBooking = bookingRepository.save(booking);

        List<Additional> additionalList = additionalRepository.findAllById(bookingDto.getServices());

        savedBooking.setAdditional(additionalList);
        savedBooking.setTotalValue(calculateTotalValue(savedBooking));
        savedBooking = bookingRepository.save(savedBooking);

        emailService.sendMail(savedBooking);
        return BookingMapper.toDTO(savedBooking);
    }

    @Override
    public BookingDTO updateBooking(Long id, BookingDTO bookingDto) throws BookingNotFoundException {
        Booking existingBooking = bookingRepository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException("Reserva não encontrada"));
        var booking = updateDTO(existingBooking, bookingDto);
        booking.setTotalValue(calculateTotalValue(booking));
        return BookingMapper.toDTO( bookingRepository.save(booking));
    }

    @Override
    public void delete(Long id) {
        bookingRepository.deleteById(id);
    }

    private Booking toEntity(BookingDTO bookingDto) {
        var client = clientRepository.findById(bookingDto.getIdClient()).orElseThrow(() -> new ResourceNotFoundException("Cliente não cadastrado"));
//        var rooms = roomRepository.findAllById(bookingDto.getRooms());
        Booking booking = new Booking();
        booking.setClient(client);
//        booking.setRooms(rooms);
        booking.setGuests(bookingDto.getGuests());
        booking.setCheckInDate(bookingDto.getCheckInDate());
        booking.setCheckOutDate(bookingDto.getCheckOutDate());

        return booking;
    }

    private Booking updateDTO(Booking existingBooking, BookingDTO bookingDTO) {
        List<Additional> additionalList = additionalRepository.findAllById(bookingDTO.getServices());
        existingBooking.setAdditional(additionalList);
        existingBooking.setGuests(bookingDTO.getGuests());
        existingBooking.setCheckInDate(bookingDTO.getCheckInDate());
        existingBooking.setCheckOutDate(bookingDTO.getCheckOutDate());
        return existingBooking;
    }

    private double calculateTotalValue(Booking booking){
        var additional = booking.getAdditional();

        return additional.stream().mapToDouble(Additional::getPrice).sum();
    }

}
