package com.postech30.hackathon.service.impl;

import com.postech30.hackathon.dto.BookingDTO;
import com.postech30.hackathon.entity.Additional;
import com.postech30.hackathon.entity.Booking;
import com.postech30.hackathon.entity.Room;
import com.postech30.hackathon.exceptions.BookingNotFoundException;
import com.postech30.hackathon.exceptions.ResourceNotFoundException;
import com.postech30.hackathon.exceptions.RoomNotAvailableException;
import com.postech30.hackathon.mapper.BookingMapper;
import com.postech30.hackathon.repository.AdditionalRepository;
import com.postech30.hackathon.repository.BookingRepository;
import com.postech30.hackathon.repository.ClientRepository;
import com.postech30.hackathon.repository.RoomRepository;
import com.postech30.hackathon.service.BookingService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private RoomRepository roomRepository;
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
    public BookingDTO book(BookingDTO bookingDto) throws MessagingException, RoomNotAvailableException {
        var booking = toEntity(bookingDto);
        var savedBooking = bookingRepository.save(booking);
        List<Additional> additionalList = additionalRepository.findAllById(bookingDto.getServices());
        List<Room> roomList = roomRepository.findAllById(bookingDto.getRooms());

        for (Room room : roomList) {
            LocalDate checkInDate = booking.getCheckInDate();
            LocalDate checkOutDate = booking.getCheckOutDate();
            List<Booking> bookings = bookingRepository.findBookingsByRoomIdAndOverlappingDates(room.getId(), checkInDate, checkOutDate);
            if (!bookings.isEmpty()) {
                throw new RoomNotAvailableException("Quarto " + room.getId() + " não está disponivel");
            }
        }

        savedBooking.setAdditional(additionalList);
        savedBooking.setRooms(roomList);
        savedBooking.setTotalValue(calculateTotalValue(booking));

        Booking resultBooking = bookingRepository.save(savedBooking);

        emailService.sendMail(savedBooking);
        return BookingMapper.toDTO(savedBooking);
    }


    @Override
    public BookingDTO updateBooking(Long id, BookingDTO bookingDto) throws BookingNotFoundException {
        Booking existingBooking = bookingRepository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException("Reserva não encontrada"));
        var booking = updateDTO(existingBooking, bookingDto);
        booking.setTotalValue(calculateTotalValue(booking));
        return BookingMapper.toDTO(bookingRepository.save(booking));
    }

    @Override
    public void delete(Long id) {
        bookingRepository.deleteById(id);
    }


    private Booking toEntity(BookingDTO bookingDto) {
        var client = clientRepository.findById(bookingDto.getIdClient()).orElseThrow(() -> new ResourceNotFoundException("Cliente não cadastrado"));
        Booking booking = new Booking();
        booking.setClient(client);
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

    private double calculateTotalValue(Booking booking) {
        var additional = booking.getAdditional();
        var rooms = booking.getRooms();
        double valueAdditional = additional.stream().mapToDouble(Additional::getPrice).sum();
        double valueRooms = rooms.stream().mapToDouble(Room::getDailyRate).sum();

        return valueRooms + valueAdditional;
    }

}
