package com.postech30.hackathon.service.impl;

import ch.qos.logback.core.net.server.Client;
import com.postech30.hackathon.dto.BookingDto;
import com.postech30.hackathon.entity.Booking;
import com.postech30.hackathon.exception.BookingNotFoundException;
import com.postech30.hackathon.repository.BookingRepository;
import com.postech30.hackathon.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<Booking> getAll()
    {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(Long id) throws BookingNotFoundException {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException("Reserva não encontrada"));
    }


    @Override
    public Booking book(BookingDto bookingDto) {
        var client =clientRepository.findById(bookingDto.getIdCustumer()).orElseThrow(() -> new  ResourceNotFoundException("Cliente não cadastrado"));
        var rooms = roomRepository.findAllById(bookingDto.getRooms());
        var service = serviceRepository.findAllById(bookingDto.getServices());
        return null;
    }

    @Override
    public Booking updateBooking(BookingDto bookingDto) {

        return null;
    }

    private toENtity
}
