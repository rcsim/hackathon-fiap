package com.postech30.hackathon.service;

import com.postech30.hackathon.dto.BookingDto;
import com.postech30.hackathon.entity.Booking;
import com.postech30.hackathon.exceptions.BookingNotFoundException;

import java.util.List;

public interface BookingService {
    List<BookingDto> getAll();

    BookingDto getBookingById(Long id) throws BookingNotFoundException;

    BookingDto book(BookingDto bookingDto);

    BookingDto updateBooking(BookingDto bookingDto);
}
