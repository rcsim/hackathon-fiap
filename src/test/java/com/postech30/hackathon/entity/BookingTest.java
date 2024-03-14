package com.postech30.hackathon.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {Booking.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class BookingTest {
    @Autowired
    private Booking booking;

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Booking#Booking()}
     *   <li>{@link Booking#setAdditional(List)}
     *   <li>{@link Booking#setCheckInDate(LocalDate)}
     *   <li>{@link Booking#setCheckOutDate(LocalDate)}
     *   <li>{@link Booking#setClient(Client)}
     *   <li>{@link Booking#setGuests(int)}
     *   <li>{@link Booking#setId(Long)}
     *   <li>{@link Booking#setTotalValue(double)}
     *   <li>{@link Booking#getAdditional()}
     *   <li>{@link Booking#getCheckInDate()}
     *   <li>{@link Booking#getCheckOutDate()}
     *   <li>{@link Booking#getClient()}
     *   <li>{@link Booking#getGuests()}
     *   <li>{@link Booking#getId()}
     *   <li>{@link Booking#getTotalValue()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        Booking actualBooking = new Booking();
        ArrayList<Additional> additional = new ArrayList<>();
        actualBooking.setAdditional(additional);
        LocalDate checkInDate = LocalDate.of(1970, 1, 1);
        actualBooking.setCheckInDate(checkInDate);
        LocalDate checkOutDate = LocalDate.of(1970, 1, 1);
        actualBooking.setCheckOutDate(checkOutDate);
        Client Client = new Client();
        Client.setAddress("42 Main St");
        Client.setBirthDate("2020-03-01");
        Client.setCountry("GB");
        Client.setCpf("Cpf");
        Client.setEmail("jane.doe@example.org");
        Client.setFullName("Dr Jane Doe");
        Client.setId(1L);
        Client.setPassport("Passport");
        Client.setPhone("6625550144");
        actualBooking.setClient(Client);
        actualBooking.setGuests(1);
        actualBooking.setId(1L);
        actualBooking.setTotalValue(10.0d);
        List<Additional> actualAdditional = actualBooking.getAdditional();
        LocalDate actualCheckInDate = actualBooking.getCheckInDate();
        LocalDate actualCheckOutDate = actualBooking.getCheckOutDate();
        Client actualClient = actualBooking.getClient();
        int actualGuests = actualBooking.getGuests();
        Long actualId = actualBooking.getId();
        assertEquals(1, actualGuests);
        assertEquals(10.0d, actualBooking.getTotalValue());
        assertEquals(1L, actualId.longValue());
        assertSame(Client, actualClient);
        assertSame(additional, actualAdditional);
        assertSame(checkInDate, actualCheckInDate);
        assertSame(checkOutDate, actualCheckOutDate);
    }

    /**
     * Method under test:
     * {@link Booking#Booking(Long, Client, LocalDate, LocalDate, List, double, int)}
     */
    @Test
    void testNewBooking() {
        Client Client = new Client();
        Client.setAddress("42 Main St");
        Client.setBirthDate("2020-03-01");
        Client.setCountry("GB");
        Client.setCpf("Cpf");
        Client.setEmail("jane.doe@example.org");
        Client.setFullName("Dr Jane Doe");
        Client.setId(1L);
        Client.setPassport("Passport");
        Client.setPhone("6625550144");
        LocalDate checkInDate = LocalDate.of(1970, 1, 1);
        LocalDate checkOutDate = LocalDate.of(1970, 1, 1);
        Booking actualBooking = new Booking(1L, Client, checkInDate, checkOutDate, new ArrayList<>(), 10.0d, 1);

        assertEquals("1970-01-01", actualBooking.getCheckInDate().toString());
        assertEquals("1970-01-01", actualBooking.getCheckOutDate().toString());
        assertEquals(1, actualBooking.getGuests());
        assertEquals(10.0d, actualBooking.getTotalValue());
        assertEquals(1L, actualBooking.getId().longValue());
        assertTrue(actualBooking.getAdditional().isEmpty());
        assertSame(Client, actualBooking.getClient());
    }

    /**
     * Method under test:
     * {@link Booking#Booking(Long, Client, LocalDate, LocalDate, List, double, int)}
     */
    @Test
    void testNewBooking2() {
        Client Client = new Client();
        Client.setAddress("42 Main St");
        Client.setBirthDate("2020-03-01");
        Client.setCountry("GB");
        Client.setCpf("Cpf");
        Client.setEmail("jane.doe@example.org");
        Client.setFullName("Dr Jane Doe");
        Client.setId(1L);
        Client.setPassport("Passport");
        Client.setPhone("6625550144");
        LocalDate checkInDate = LocalDate.of(1970, 1, 1);
        LocalDate checkOutDate = LocalDate.of(1970, 1, 1);

        Additional additional = new Additional();
        additional.setDescription("The characteristics of someone or something");
        additional.setId(1L);
        additional.setName("Name");
        additional.setPrice(10.0d);
        additional.setType("Type");

        ArrayList<Additional> additional2 = new ArrayList<>();
        additional2.add(additional);
        Booking actualBooking = new Booking(1L, Client, checkInDate, checkOutDate, additional2, 10.0d, 1);

        assertEquals("1970-01-01", actualBooking.getCheckInDate().toString());
        assertEquals("1970-01-01", actualBooking.getCheckOutDate().toString());
        assertEquals(1, actualBooking.getGuests());
        assertEquals(1, actualBooking.getAdditional().size());
        assertEquals(10.0d, actualBooking.getTotalValue());
        assertEquals(1L, actualBooking.getId().longValue());
        assertSame(Client, actualBooking.getClient());
    }

    /**
     * Method under test:
     * {@link Booking#Booking(Long, Client, LocalDate, LocalDate, List, double, int)}
     */
    @Test
    void testNewBooking3() {
        Client Client = new Client();
        Client.setAddress("42 Main St");
        Client.setBirthDate("2020-03-01");
        Client.setCountry("GB");
        Client.setCpf("Cpf");
        Client.setEmail("jane.doe@example.org");
        Client.setFullName("Dr Jane Doe");
        Client.setId(1L);
        Client.setPassport("Passport");
        Client.setPhone("6625550144");
        LocalDate checkInDate = LocalDate.of(1970, 1, 1);
        LocalDate checkOutDate = LocalDate.of(1970, 1, 1);

        Additional additional = new Additional();
        additional.setDescription("The characteristics of someone or something");
        additional.setId(1L);
        additional.setName("Name");
        additional.setPrice(10.0d);
        additional.setType("Type");

        Additional additional2 = new Additional();
        additional2.setDescription("Description");
        additional2.setId(2L);
        additional2.setName("com.postech30.hackathon.entity.Additional");
        additional2.setPrice(0.5d);
        additional2.setType("com.postech30.hackathon.entity.Additional");

        ArrayList<Additional> additional3 = new ArrayList<>();
        additional3.add(additional2);
        additional3.add(additional);
        Booking actualBooking = new Booking(1L, Client, checkInDate, checkOutDate, additional3, 10.0d, 1);

        assertEquals("1970-01-01", actualBooking.getCheckInDate().toString());
        assertEquals("1970-01-01", actualBooking.getCheckOutDate().toString());
        assertEquals(1, actualBooking.getGuests());
        assertEquals(10.0d, actualBooking.getTotalValue());
        assertEquals(1L, actualBooking.getId().longValue());
        assertEquals(2, actualBooking.getAdditional().size());
        assertSame(Client, actualBooking.getClient());
    }
}
