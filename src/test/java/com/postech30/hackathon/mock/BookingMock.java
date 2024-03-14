package com.postech30.hackathon.mock;

import com.postech30.hackathon.dto.BookingDTO;

import java.time.LocalDate;
import java.util.List;

public class BookingMock {
    public static BookingDTO getBookingMock() {
        // Criando os sets para rooms e services
        List<Long> rooms = List.of(1L);
        List<Long> services = List.of(1L);

        // Criando o objeto BookingDTO
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(1L);
        bookingDTO.setIdClient(1L);
        bookingDTO.setCheckInDate(LocalDate.parse("2023-04-01"));
        bookingDTO.setCheckOutDate(LocalDate.parse("2023-04-10"));
        bookingDTO.setRooms(rooms);
        bookingDTO.setServices(services);
        bookingDTO.setTotalValue(1000.00);
        bookingDTO.setGuests(2);

        return bookingDTO;

    }
}
