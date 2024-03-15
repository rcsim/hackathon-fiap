package com.postech30.hackathon.mapper;

import com.postech30.hackathon.dto.BookingDTO;
import com.postech30.hackathon.entity.Additional;
import com.postech30.hackathon.entity.Booking;
import com.postech30.hackathon.entity.Room;


import java.util.stream.Collectors;

public class BookingMapper {


    public static BookingDTO toDTO(Booking booking) {
        BookingDTO bookingDto = new BookingDTO();
        bookingDto.setId(booking.getId());
        bookingDto.setIdClient(booking.getClient().getId());
        bookingDto.setCheckInDate(booking.getCheckInDate());
        bookingDto.setCheckOutDate(booking.getCheckOutDate());
        bookingDto.setTotalValue(booking.getTotalValue());
        bookingDto.setGuests(booking.getGuests());

        bookingDto.setRooms(booking.getRooms().stream().map(Room::getId).collect(Collectors.toList()));
        bookingDto.setServices(booking.getAdditional().stream().map(Additional::getId).collect(Collectors.toList()));

        return bookingDto;
    }
}
