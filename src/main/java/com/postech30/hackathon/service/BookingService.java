package com.postech30.hackathon.service;

import com.postech30.hackathon.dto.BookingDto;
import com.postech30.hackathon.entity.Booking;
import com.postech30.hackathon.exception.BookingNotFoundException;

import java.util.List;

public interface BookingService {
    List<Booking> getAll();

    Booking getBookingById(Long id) throws BookingNotFoundException;

    Booking book(BookingDto bookingDto);

    Booking updateBooking(BookingDto bookingDto);
}
