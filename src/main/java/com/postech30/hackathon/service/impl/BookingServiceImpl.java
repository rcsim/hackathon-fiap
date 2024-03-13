package com.postech30.hackathon.service.impl;

import com.postech30.hackathon.dto.BookingDto;
import com.postech30.hackathon.entity.Booking;
import com.postech30.hackathon.exceptions.BookingNotFoundException;
import com.postech30.hackathon.exceptions.ResourceNotFoundException;
import com.postech30.hackathon.mapper.BookingMapper;
import com.postech30.hackathon.repository.BookingRepository;
import com.postech30.hackathon.repository.ClientRepository;
import com.postech30.hackathon.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<BookingDto> getAll()
    {
        List<BookingDto> bookingDtos = bookingRepository.findAll().stream()
                .map(BookingMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookingDto getBookingById(Long id) throws BookingNotFoundException {
        return BookingMapper.toDto(bookingRepository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException("Reserva não encontrada")));
    }


    @Override
    public BookingDto book(BookingDto bookingDto) {
       var booking =  toEntity(bookingDto);
        return null;
    }

    @Override
    public BookingDto updateBooking(BookingDto bookingDto) {

        return null;
    }

    private Booking toEntity(BookingDto bookingDto){
        var client =clientRepository.findById(bookingDto.getIdCustumer()).orElseThrow(() -> new ResourceNotFoundException("Cliente não cadastrado"));
        var rooms = roomRepository.findAllById(bookingDto.getRooms());
        var service = serviceRepository.findAllById(bookingDto.getServices());
        Booking booking = new Booking();
        booking.setClient(client);
        booking.setServices(service);
        booking.setRooms(rooms);
        booking.setGuests(bookingDto.getGuests());
        booking.setCheckInDate(bookingDto.getCheckInDate());
        booking.setCheckOutDate(bookingDto.getCheckOutDate());

        return booking;
    }
}
