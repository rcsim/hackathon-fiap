package com.postech30.hackathon.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class AvailableRoomDTOTest {

    @Test
    void testCheckInDateGetterAndSetter() {
        final AvailableRoomDTO availableRoomDTOUnderTest = new AvailableRoomDTO(LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 1, 1));
        final LocalDate checkInDate = LocalDate.of(2020, 1, 1);
        availableRoomDTOUnderTest.setCheckInDate(checkInDate);
        assertThat(availableRoomDTOUnderTest.getCheckInDate()).isEqualTo(checkInDate);
    }

    @Test
    void testCheckOutDateGetterAndSetter() {
        final AvailableRoomDTO availableRoomDTOUnderTest = new AvailableRoomDTO(LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 1, 1));
        final LocalDate checkOutDate = LocalDate.of(2020, 1, 1);
        availableRoomDTOUnderTest.setCheckOutDate(checkOutDate);
        assertThat(availableRoomDTOUnderTest.getCheckOutDate()).isEqualTo(checkOutDate);
    }
}
