package com.postech30.hackathon.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class AvaliableRoomDTOTest {

    @Test
    void testCheckInDateGetterAndSetter() {
        final AvaliableRoomDTO avaliableRoomDTOUnderTest = new AvaliableRoomDTO(LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 1, 1));
        final LocalDate checkInDate = LocalDate.of(2020, 1, 1);
        avaliableRoomDTOUnderTest.setCheckInDate(checkInDate);
        assertThat(avaliableRoomDTOUnderTest.getCheckInDate()).isEqualTo(checkInDate);
    }

    @Test
    void testCheckOutDateGetterAndSetter() {
        final AvaliableRoomDTO avaliableRoomDTOUnderTest = new AvaliableRoomDTO(LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 1, 1));
        final LocalDate checkOutDate = LocalDate.of(2020, 1, 1);
        avaliableRoomDTOUnderTest.setCheckOutDate(checkOutDate);
        assertThat(avaliableRoomDTOUnderTest.getCheckOutDate()).isEqualTo(checkOutDate);
    }
}
