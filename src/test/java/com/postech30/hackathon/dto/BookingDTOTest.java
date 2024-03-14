package com.postech30.hackathon.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {BookingDTO.class})
@ExtendWith(SpringExtension.class)
class BookingDTOTest {
    @Autowired
    private BookingDTO bookingDTO;

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link BookingDTO#BookingDTO()}
     *   <li>{@link BookingDTO#setCheckInDate(LocalDate)}
     *   <li>{@link BookingDTO#setCheckOutDate(LocalDate)}
     *   <li>{@link BookingDTO#setGuests(int)}
     *   <li>{@link BookingDTO#setId(Long)}
     *   <li>{@link BookingDTO#setIdClient(Long)}
     *   <li>{@link BookingDTO#setRooms(List)}
     *   <li>{@link BookingDTO#setServices(List)}
     *   <li>{@link BookingDTO#setTotalValue(double)}
     *   <li>{@link BookingDTO#getCheckInDate()}
     *   <li>{@link BookingDTO#getCheckOutDate()}
     *   <li>{@link BookingDTO#getGuests()}
     *   <li>{@link BookingDTO#getId()}
     *   <li>{@link BookingDTO#getIdClient()}
     *   <li>{@link BookingDTO#getRooms()}
     *   <li>{@link BookingDTO#getServices()}
     *   <li>{@link BookingDTO#getTotalValue()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        BookingDTO actualBookingDTO = new BookingDTO();
        LocalDate checkInDate = LocalDate.of(1970, 1, 1);
        actualBookingDTO.setCheckInDate(checkInDate);
        LocalDate checkOutDate = LocalDate.of(1970, 1, 1);
        actualBookingDTO.setCheckOutDate(checkOutDate);
        actualBookingDTO.setGuests(1);
        actualBookingDTO.setId(1L);
        actualBookingDTO.setIdClient(1L);
        ArrayList<Long> rooms = new ArrayList<>();
        actualBookingDTO.setRooms(rooms);
        ArrayList<Long> services = new ArrayList<>();
        actualBookingDTO.setServices(services);
        actualBookingDTO.setTotalValue(10.0d);
        LocalDate actualCheckInDate = actualBookingDTO.getCheckInDate();
        LocalDate actualCheckOutDate = actualBookingDTO.getCheckOutDate();
        int actualGuests = actualBookingDTO.getGuests();
        Long actualId = actualBookingDTO.getId();
        Long actualIdClient = actualBookingDTO.getIdClient();
        List<Long> actualRooms = actualBookingDTO.getRooms();
        List<Long> actualServices = actualBookingDTO.getServices();
        assertEquals(1, actualGuests);
        assertEquals(10.0d, actualBookingDTO.getTotalValue());
        assertEquals(1L, actualId.longValue());
        assertEquals(1L, actualIdClient.longValue());
        assertSame(rooms, actualRooms);
        assertSame(services, actualServices);
        assertSame(checkInDate, actualCheckInDate);
        assertSame(checkOutDate, actualCheckOutDate);
    }

    /**
     * Method under test:
     * {@link BookingDTO#BookingDTO(Long, Long, LocalDate, LocalDate, List, List, double, int)}
     */
    @Test
    void testNewBookingDTO() {
        LocalDate checkInDate = LocalDate.of(1970, 1, 1);
        LocalDate checkOutDate = LocalDate.of(1970, 1, 1);
        ArrayList<Long> rooms = new ArrayList<>();
        BookingDTO actualBookingDTO = new BookingDTO(1L, 1L, checkInDate, checkOutDate, rooms, new ArrayList<>(), 10.0d, 1);

        assertEquals("1970-01-01", actualBookingDTO.getCheckInDate().toString());
        assertEquals("1970-01-01", actualBookingDTO.getCheckOutDate().toString());
        assertEquals(1, actualBookingDTO.getGuests());
        assertEquals(10.0d, actualBookingDTO.getTotalValue());
        assertEquals(1L, actualBookingDTO.getId().longValue());
        assertEquals(1L, actualBookingDTO.getIdClient().longValue());
        assertTrue(actualBookingDTO.getRooms().isEmpty());
        assertEquals(rooms, actualBookingDTO.getServices());
    }

    /**
     * Method under test:
     * {@link BookingDTO#BookingDTO(Long, Long, LocalDate, LocalDate, List, List, double, int)}
     */
    @Test
    void testNewBookingDTO2() {
        LocalDate checkInDate = LocalDate.of(1970, 1, 1);
        LocalDate checkOutDate = LocalDate.of(1970, 1, 1);

        ArrayList<Long> rooms = new ArrayList<>();
        rooms.add(1L);
        BookingDTO actualBookingDTO = new BookingDTO(1L, 1L, checkInDate, checkOutDate, rooms, new ArrayList<>(), 10.0d, 1);

        assertEquals("1970-01-01", actualBookingDTO.getCheckInDate().toString());
        assertEquals("1970-01-01", actualBookingDTO.getCheckOutDate().toString());
        assertEquals(1, actualBookingDTO.getGuests());
        assertEquals(1, actualBookingDTO.getRooms().size());
        assertEquals(10.0d, actualBookingDTO.getTotalValue());
        assertEquals(1L, actualBookingDTO.getId().longValue());
        assertEquals(1L, actualBookingDTO.getIdClient().longValue());
        assertTrue(actualBookingDTO.getServices().isEmpty());
    }

    /**
     * Method under test:
     * {@link BookingDTO#BookingDTO(Long, Long, LocalDate, LocalDate, List, List, double, int)}
     */
    @Test
    void testNewBookingDTO3() {
        LocalDate checkInDate = LocalDate.of(1970, 1, 1);
        LocalDate checkOutDate = LocalDate.of(1970, 1, 1);

        ArrayList<Long> rooms = new ArrayList<>();
        rooms.add(0L);
        rooms.add(1L);
        BookingDTO actualBookingDTO = new BookingDTO(1L, 1L, checkInDate, checkOutDate, rooms, new ArrayList<>(), 10.0d, 1);

        assertEquals("1970-01-01", actualBookingDTO.getCheckInDate().toString());
        assertEquals("1970-01-01", actualBookingDTO.getCheckOutDate().toString());
        assertEquals(1, actualBookingDTO.getGuests());
        assertEquals(10.0d, actualBookingDTO.getTotalValue());
        assertEquals(1L, actualBookingDTO.getId().longValue());
        assertEquals(1L, actualBookingDTO.getIdClient().longValue());
        assertEquals(2, actualBookingDTO.getRooms().size());
        assertTrue(actualBookingDTO.getServices().isEmpty());
    }

    /**
     * Method under test:
     * {@link BookingDTO#BookingDTO(Long, Long, LocalDate, LocalDate, List, List, double, int)}
     */
    @Test
    void testNewBookingDTO4() {
        LocalDate checkInDate = LocalDate.of(1970, 1, 1);
        LocalDate checkOutDate = LocalDate.of(1970, 1, 1);
        ArrayList<Long> rooms = new ArrayList<>();

        ArrayList<Long> services = new ArrayList<>();
        services.add(1L);
        BookingDTO actualBookingDTO = new BookingDTO(1L, 1L, checkInDate, checkOutDate, rooms, services, 10.0d, 1);

        assertEquals("1970-01-01", actualBookingDTO.getCheckInDate().toString());
        assertEquals("1970-01-01", actualBookingDTO.getCheckOutDate().toString());
        assertEquals(1, actualBookingDTO.getGuests());
        assertEquals(1, actualBookingDTO.getServices().size());
        assertEquals(10.0d, actualBookingDTO.getTotalValue());
        assertEquals(1L, actualBookingDTO.getId().longValue());
        assertEquals(1L, actualBookingDTO.getIdClient().longValue());
        assertTrue(actualBookingDTO.getRooms().isEmpty());
    }

    /**
     * Method under test:
     * {@link BookingDTO#BookingDTO(Long, Long, LocalDate, LocalDate, List, List, double, int)}
     */
    @Test
    void testNewBookingDTO5() {
        LocalDate checkInDate = LocalDate.of(1970, 1, 1);
        LocalDate checkOutDate = LocalDate.of(1970, 1, 1);
        ArrayList<Long> rooms = new ArrayList<>();

        ArrayList<Long> services = new ArrayList<>();
        services.add(0L);
        services.add(1L);
        BookingDTO actualBookingDTO = new BookingDTO(1L, 1L, checkInDate, checkOutDate, rooms, services, 10.0d, 1);

        assertEquals("1970-01-01", actualBookingDTO.getCheckInDate().toString());
        assertEquals("1970-01-01", actualBookingDTO.getCheckOutDate().toString());
        assertEquals(1, actualBookingDTO.getGuests());
        assertEquals(10.0d, actualBookingDTO.getTotalValue());
        assertEquals(1L, actualBookingDTO.getId().longValue());
        assertEquals(1L, actualBookingDTO.getIdClient().longValue());
        assertEquals(2, actualBookingDTO.getServices().size());
        assertTrue(actualBookingDTO.getRooms().isEmpty());
    }
}
