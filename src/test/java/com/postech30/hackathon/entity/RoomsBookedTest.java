package com.postech30.hackathon.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoomsBookedTest {

    private RoomsBooked roomsBookedUnderTest;

    @BeforeEach
    void setUp() {
        roomsBookedUnderTest = new RoomsBooked(0L, 0L);
    }

    @Test
    void testBookIdGetterAndSetter() {
        final Long bookId = 0L;
        roomsBookedUnderTest.setBookId(bookId);
        assertThat(roomsBookedUnderTest.getBookId()).isEqualTo(bookId);
    }

    @Test
    void testRoomIdGetterAndSetter() {
        final Long roomId = 0L;
        roomsBookedUnderTest.setRoomId(roomId);
        assertThat(roomsBookedUnderTest.getRoomId()).isEqualTo(roomId);
    }
}
