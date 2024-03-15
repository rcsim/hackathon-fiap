package com.postech30.hackathon.service;

import com.postech30.hackathon.dto.AvaliableRoomDTO;
import com.postech30.hackathon.dto.BookingDTO;
import com.postech30.hackathon.dto.RoomDTO;
import com.postech30.hackathon.exceptions.BookingNotFoundException;
import com.postech30.hackathon.exceptions.RoomNotAvailableException;
import jakarta.mail.MessagingException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {
    Page<BookingDTO> getAll(Pageable pageable);

    BookingDTO getBookingById(Long id) throws BookingNotFoundException;

    BookingDTO book(BookingDTO bookingDto) throws MessagingException, RoomNotAvailableException;

    BookingDTO updateBooking(Long id, BookingDTO bookingDto) throws BookingNotFoundException;

    void delete(Long id);


}
