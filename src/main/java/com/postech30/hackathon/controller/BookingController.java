package com.postech30.hackathon.controller;

import com.postech30.hackathon.dto.BookingDTO;
import com.postech30.hackathon.exceptions.BookingNotFoundException;
import com.postech30.hackathon.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @GetMapping
    public ResponseEntity<Page<BookingDTO>> getBooking( Pageable pageable){
        Page<BookingDTO> bookings = bookingService.getAll(pageable);
        return  ResponseEntity.ok().body(bookings);
    }
    @GetMapping(value="{id}")
    public ResponseEntity<BookingDTO> getBooking(@PathVariable Long id) throws BookingNotFoundException {
        BookingDTO booking = bookingService.getBookingById(id);
        return  ResponseEntity.ok().body(booking);
    }
    @PostMapping()
    public ResponseEntity<BookingDTO> book(@RequestBody BookingDTO bookingDto){
        BookingDTO booking = bookingService.book(bookingDto);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);

    }

    @PutMapping(value="{id}")
    public ResponseEntity<BookingDTO> updateBooking(@PathVariable Long id, @RequestBody BookingDTO bookingDto) throws BookingNotFoundException {
        BookingDTO booking = bookingService.updateBooking(id,bookingDto);
        return  ResponseEntity.ok().body(booking);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deleteBooking(@PathVariable Long id){
        bookingService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Reserva deletada com sucesso");
    }


}
