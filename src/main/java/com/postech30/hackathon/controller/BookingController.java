package com.postech30.hackathon.controller;

import com.postech30.hackathon.dto.BookingDto;
import com.postech30.hackathon.exceptions.BookingNotFoundException;
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
    @GetMapping(value="{id}")
    public ResponseEntity<BookingDto> getBooking(@PathVariable Long id) throws BookingNotFoundException {
        BookingDto booking = bookingService.getBookingById(id);
        return  ResponseEntity.ok().body(booking);
    }
    @PostMapping(value="{id}")
    public ResponseEntity<BookingDto> book(@RequestBody BookingDto bookingDto){
        BookingDto booking = bookingService.book(bookingDto);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);

    }

    @PutMapping(value="{id}")
    public ResponseEntity<BookingDto> updateBooking(@PathVariable Long id,@RequestBody BookingDto bookingDto){
        BookingDto booking = bookingService.updateBooking(id,bookingDto);
        return  ResponseEntity.ok().body(booking);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deleteBooking(@PathVariable Long id){
        bookingService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Reserva deletada com sucesso");
    }


}
