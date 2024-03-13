package com.postech30.hackathon.controller;

import com.postech30.hackathon.dto.BookingDto;
import com.postech30.hackathon.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @GetMapping
    public ResponseEntity<List<BookingDto>> getBooking(){
        var bookings = bookingService.getAll();
        return  ResponseEntity.ok().body(bookings);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookingDto> getBooking(@@PathVariable Long id){
        BookingDto booking = bookingService.getBookingById(id);
        return  ResponseEntity.ok().body(booking);
    }
    @PostMapping()
    public ResponseEntity<BookingDto> book(@RequestBody BookingDto bookingDto){
        BookingDto booking = bookingService.book(bookingDto);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);

    }

    @PutMapping("")
    public ResponseEntity<BookingDto> updateBooking(@RequestBody BookingDto bookingDto){
        BookingDto booking = bookingService.updateBooking(bookingDto);
        return  ResponseEntity.ok().body(booking);
    }


}
