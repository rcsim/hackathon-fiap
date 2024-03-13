package com.postech30.hackathon.mapper;

import com.postech30.hackathon.dto.BookingDto;
import com.postech30.hackathon.entity.Booking;

import java.util.stream.Collectors;

public class BookingMapper {


    public static BookingDto toDto(Booking booking) {
        BookingDto bookingDto = new BookingDto();
        bookingDto.setId(booking.getId());
        bookingDto.setIdCustumer(booking.getClient().getId());
        bookingDto.setCheckInDate(booking.getCheckInDate());
        bookingDto.setCheckOutDate(booking.getCheckOutDate());
        bookingDto.setTotalValue(booking.getTotalValue());
        bookingDto.setGuests(booking.getGuests());

        bookingDto.setRooms(booking.getRooms().stream().map(Room::getId).collect(Collectors.toList()));
        bookingDto.setServices(booking.getServices().stream().map(Service::getId).collect(Collectors.toList()));

        return bookingDto;
    }
}
