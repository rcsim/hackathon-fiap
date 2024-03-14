package com.postech30.hackathon.service;

import com.postech30.hackathon.dto.BookingDTO;
import com.postech30.hackathon.exceptions.BookingNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookingService {
    Page<BookingDTO> getAll(Pageable pageable);

    BookingDTO getBookingById(Long id) throws BookingNotFoundException;

    BookingDTO book(BookingDTO bookingDto);

    BookingDTO updateBooking(Long id, BookingDTO bookingDto) throws BookingNotFoundException;

    void delete(Long id);
}
