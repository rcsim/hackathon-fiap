package com.postech30.hackathon.mapper;

import com.postech30.hackathon.dto.BookingDTO;
import com.postech30.hackathon.entity.Additional;
import com.postech30.hackathon.entity.Booking;
import com.postech30.hackathon.entity.Client;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

class BookingMapperTest {

    @Test
    void testToDTO() {
        // Setup
        final Booking booking = new Booking();
        booking.setId(0L);
        final Client client = new Client();
        client.setId(0L);
        booking.setClient(client);
        booking.setCheckInDate(LocalDate.of(2020, 1, 1));
        booking.setCheckOutDate(LocalDate.of(2020, 1, 1));
        final Additional additional = new Additional();
        additional.setId(0L);
        booking.setAdditional(List.of(additional));
        booking.setTotalValue(0.0);
        booking.setGuests(0);

        // Run the test
        final BookingDTO result = BookingMapper.toDTO(booking);

        // Verify the results
    }
}
