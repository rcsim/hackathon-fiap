package com.postech30.hackathon.service.impl;

import com.postech30.hackathon.dto.BookingDTO;
import com.postech30.hackathon.entity.*;
import com.postech30.hackathon.exceptions.BookingNotFoundException;
import com.postech30.hackathon.exceptions.ResourceNotFoundException;
import com.postech30.hackathon.exceptions.RoomNotAvailableException;
import com.postech30.hackathon.repository.AdditionalRepository;
import com.postech30.hackathon.repository.BookingRepository;
import com.postech30.hackathon.repository.ClientRepository;
import com.postech30.hackathon.repository.RoomRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookingServiceImplTest {

    @Mock
    private BookingRepository mockBookingRepository;
    @Mock
    private RoomRepository mockRoomRepository;
    @Mock
    private AdditionalRepository mockAdditionalRepository;
    @Mock
    private ClientRepository mockClientRepository;
    @Mock
    private EmailServiceImpl mockEmailService;

    @InjectMocks
    private BookingServiceImpl bookingServiceImplUnderTest;

    @Test
    void testGetAll() {
        // Setup
        // Configure BookingRepository.findAll(...).
        final Booking booking = new Booking();
        booking.setId(0L);
        final Client client = new Client();
        client.setId(0L);
        booking.setClient(client);
        booking.setCheckInDate(LocalDate.of(2020, 1, 1));
        booking.setCheckOutDate(LocalDate.of(2020, 1, 1));
        final Room room = new Room();
        room.setId(0L);
        room.setDailyRate(0.0);
        booking.setRooms(List.of(room));
        final Additional additional = new Additional();
        additional.setPrice(0.0);
        booking.setAdditional(List.of(additional));
        booking.setTotalValue(0.0);
        booking.setGuests(0);
        final Page<Booking> bookings = new PageImpl<>(List.of(booking));
        when(mockBookingRepository.findAll(any(Pageable.class))).thenReturn(bookings);

        // Run the test
        final Page<BookingDTO> result = bookingServiceImplUnderTest.getAll(PageRequest.of(0, 1));

        // Verify the results
    }

    @Test
    void testGetAll_BookingRepositoryReturnsNoItems() {
        // Setup
        when(mockBookingRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(Collections.emptyList()));

        // Run the test
        final Page<BookingDTO> result = bookingServiceImplUnderTest.getAll(PageRequest.of(0, 1));

        // Verify the results
    }

    @Test
    void testGetBookingById() throws Exception {
        // Setup
        // Configure BookingRepository.findById(...).
        final Booking booking1 = new Booking();
        booking1.setId(0L);
        final Client client = new Client();
        client.setId(0L);
        booking1.setClient(client);
        booking1.setCheckInDate(LocalDate.of(2020, 1, 1));
        booking1.setCheckOutDate(LocalDate.of(2020, 1, 1));
        final Room room = new Room();
        room.setId(0L);
        room.setDailyRate(0.0);
        booking1.setRooms(List.of(room));
        final Additional additional = new Additional();
        additional.setPrice(0.0);
        booking1.setAdditional(List.of(additional));
        booking1.setTotalValue(0.0);
        booking1.setGuests(0);
        final Optional<Booking> booking = Optional.of(booking1);
        when(mockBookingRepository.findById(0L)).thenReturn(booking);

        // Run the test
        final BookingDTO result = bookingServiceImplUnderTest.getBookingById(0L);

        // Verify the results
    }

    @Test
    void testGetBookingById_BookingRepositoryReturnsAbsent() {
        // Setup
        when(mockBookingRepository.findById(0L)).thenReturn(Optional.empty());

        // Run the test
        assertThatThrownBy(() -> bookingServiceImplUnderTest.getBookingById(0L))
                .isInstanceOf(BookingNotFoundException.class);
    }

    @Test
    void testBook_ThrowsRoomNotAvailableException() {
        // Setup
        final BookingDTO bookingDto = new BookingDTO();
        bookingDto.setId(0L);
        bookingDto.setIdClient(0L);
        bookingDto.setCheckInDate(LocalDate.of(2020, 1, 1));
        bookingDto.setCheckOutDate(LocalDate.of(2020, 1, 1));
        bookingDto.setRooms(List.of(0L));
        bookingDto.setServices(List.of(0L));
        bookingDto.setTotalValue(0.0);
        bookingDto.setGuests(0);

        // Configure ClientRepository.findById(...).
        final Client client1 = new Client();
        client1.setId(0L);
        client1.setCountry("country");
        client1.setCpf("cpf");
        client1.setPassport("passport");
        client1.setFullName("fullName");
        final Optional<Client> client = Optional.of(client1);
        when(mockClientRepository.findById(0L)).thenReturn(client);

        // Configure BookingRepository.save(...).
        final Booking booking = new Booking();
        booking.setId(0L);
        final Client client2 = new Client();
        client2.setId(0L);
        booking.setClient(client2);
        booking.setCheckInDate(LocalDate.of(2020, 1, 1));
        booking.setCheckOutDate(LocalDate.of(2020, 1, 1));
        final Room room = new Room();
        room.setId(0L);
        room.setDailyRate(0.0);
        booking.setRooms(List.of(room));
        final Additional additional = new Additional();
        additional.setPrice(0.0);
        booking.setAdditional(List.of(additional));
        booking.setTotalValue(0.0);
        booking.setGuests(0);
        when(mockBookingRepository.save(any(Booking.class))).thenReturn(booking);

        // Configure AdditionalRepository.findAllById(...).
        final List<Additional> additionals = List.of(new Additional(0L, "name", "description", 0.0, "type"));
        when(mockAdditionalRepository.findAllById(List.of(0L))).thenReturn(additionals);

        // Configure RoomRepository.findAllById(...).
        final Room room1 = new Room();
        room1.setId(0L);
        final Building building = new Building();
        building.setId(0L);
        final Location location = new Location();
        building.setLocation(location);
        room1.setBuilding(building);
        room1.setDailyRate(0.0);
        final List<Room> rooms = List.of(room1);
        when(mockRoomRepository.findAllById(List.of(0L))).thenReturn(rooms);

        // Configure BookingRepository.findBookingsByRoomIdAndOverlappingDates(...).
        final Booking booking1 = new Booking();
        booking1.setId(0L);
        final Client client3 = new Client();
        client3.setId(0L);
        booking1.setClient(client3);
        booking1.setCheckInDate(LocalDate.of(2020, 1, 1));
        booking1.setCheckOutDate(LocalDate.of(2020, 1, 1));
        final Room room2 = new Room();
        room2.setId(0L);
        room2.setDailyRate(0.0);
        booking1.setRooms(List.of(room2));
        final Additional additional1 = new Additional();
        additional1.setPrice(0.0);
        booking1.setAdditional(List.of(additional1));
        booking1.setTotalValue(0.0);
        booking1.setGuests(0);
        final List<Booking> bookings = List.of(booking1);
        when(mockBookingRepository.findBookingsByRoomIdAndOverlappingDates(0L, LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 1, 1))).thenReturn(bookings);

        // Run the test
        assertThatThrownBy(() -> bookingServiceImplUnderTest.book(bookingDto))
                .isInstanceOf(RoomNotAvailableException.class);
    }

    @Test
    void testBook_ClientRepositoryReturnsAbsent() {
        // Setup
        final BookingDTO bookingDto = new BookingDTO();
        bookingDto.setId(0L);
        bookingDto.setIdClient(0L);
        bookingDto.setCheckInDate(LocalDate.of(2020, 1, 1));
        bookingDto.setCheckOutDate(LocalDate.of(2020, 1, 1));
        bookingDto.setRooms(List.of(0L));
        bookingDto.setServices(List.of(0L));
        bookingDto.setTotalValue(0.0);
        bookingDto.setGuests(0);

        when(mockClientRepository.findById(0L)).thenReturn(Optional.empty());

        // Run the test
        assertThatThrownBy(() -> bookingServiceImplUnderTest.book(bookingDto))
                .isInstanceOf(ResourceNotFoundException.class);
    }

    @Test
    void testBook_AdditionalRepositoryReturnsNoItems() {
        // Setup
        final BookingDTO bookingDto = new BookingDTO();
        bookingDto.setId(0L);
        bookingDto.setIdClient(0L);
        bookingDto.setCheckInDate(LocalDate.of(2020, 1, 1));
        bookingDto.setCheckOutDate(LocalDate.of(2020, 1, 1));
        bookingDto.setRooms(List.of(0L));
        bookingDto.setServices(List.of(0L));
        bookingDto.setTotalValue(0.0);
        bookingDto.setGuests(0);

        // Configure ClientRepository.findById(...).
        final Client client1 = new Client();
        client1.setId(0L);
        client1.setCountry("country");
        client1.setCpf("cpf");
        client1.setPassport("passport");
        client1.setFullName("fullName");
        final Optional<Client> client = Optional.of(client1);
        when(mockClientRepository.findById(0L)).thenReturn(client);

        // Configure BookingRepository.save(...).
        final Booking booking = new Booking();
        booking.setId(0L);
        final Client client2 = new Client();
        client2.setId(0L);
        booking.setClient(client2);
        booking.setCheckInDate(LocalDate.of(2020, 1, 1));
        booking.setCheckOutDate(LocalDate.of(2020, 1, 1));
        final Room room = new Room();
        room.setId(0L);
        room.setDailyRate(0.0);
        booking.setRooms(List.of(room));
        final Additional additional = new Additional();
        additional.setPrice(0.0);
        booking.setAdditional(List.of(additional));
        booking.setTotalValue(0.0);
        booking.setGuests(0);
        when(mockBookingRepository.save(any(Booking.class))).thenReturn(booking);

        when(mockAdditionalRepository.findAllById(List.of(0L))).thenReturn(Collections.emptyList());

        // Configure RoomRepository.findAllById(...).
        final Room room1 = new Room();
        room1.setId(0L);
        final Building building = new Building();
        building.setId(0L);
        final Location location = new Location();
        building.setLocation(location);
        room1.setBuilding(building);
        room1.setDailyRate(0.0);
        final List<Room> rooms = List.of(room1);
        when(mockRoomRepository.findAllById(List.of(0L))).thenReturn(rooms);

        // Configure BookingRepository.findBookingsByRoomIdAndOverlappingDates(...).
        final Booking booking1 = new Booking();
        booking1.setId(0L);
        final Client client3 = new Client();
        client3.setId(0L);
        booking1.setClient(client3);
        booking1.setCheckInDate(LocalDate.of(2020, 1, 1));
        booking1.setCheckOutDate(LocalDate.of(2020, 1, 1));
        final Room room2 = new Room();
        room2.setId(0L);
        room2.setDailyRate(0.0);
        booking1.setRooms(List.of(room2));
        final Additional additional1 = new Additional();
        additional1.setPrice(0.0);
        booking1.setAdditional(List.of(additional1));
        booking1.setTotalValue(0.0);
        booking1.setGuests(0);
        final List<Booking> bookings = List.of(booking1);
        when(mockBookingRepository.findBookingsByRoomIdAndOverlappingDates(0L, LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 1, 1))).thenReturn(bookings);

        // Run the test
        assertThatThrownBy(() -> bookingServiceImplUnderTest.book(bookingDto))
                .isInstanceOf(RoomNotAvailableException.class);
    }

    @Test
    void testUpdateBooking() throws Exception {
        // Setup
        final BookingDTO bookingDto = new BookingDTO();
        bookingDto.setId(0L);
        bookingDto.setIdClient(0L);
        bookingDto.setCheckInDate(LocalDate.of(2020, 1, 1));
        bookingDto.setCheckOutDate(LocalDate.of(2020, 1, 1));
        bookingDto.setRooms(List.of(0L));
        bookingDto.setServices(List.of(0L));
        bookingDto.setTotalValue(0.0);
        bookingDto.setGuests(0);

        // Configure BookingRepository.findById(...).
        final Booking booking1 = new Booking();
        booking1.setId(0L);
        final Client client = new Client();
        client.setId(0L);
        booking1.setClient(client);
        booking1.setCheckInDate(LocalDate.of(2020, 1, 1));
        booking1.setCheckOutDate(LocalDate.of(2020, 1, 1));
        final Room room = new Room();
        room.setId(0L);
        room.setDailyRate(0.0);
        booking1.setRooms(List.of(room));
        final Additional additional = new Additional();
        additional.setPrice(0.0);
        booking1.setAdditional(List.of(additional));
        booking1.setTotalValue(0.0);
        booking1.setGuests(0);
        final Optional<Booking> booking = Optional.of(booking1);
        when(mockBookingRepository.findById(0L)).thenReturn(booking);

        // Configure AdditionalRepository.findAllById(...).
        final List<Additional> additionals = List.of(new Additional(0L, "name", "description", 0.0, "type"));
        when(mockAdditionalRepository.findAllById(List.of(0L))).thenReturn(additionals);

        // Configure BookingRepository.save(...).
        final Booking booking2 = new Booking();
        booking2.setId(0L);
        final Client client1 = new Client();
        client1.setId(0L);
        booking2.setClient(client1);
        booking2.setCheckInDate(LocalDate.of(2020, 1, 1));
        booking2.setCheckOutDate(LocalDate.of(2020, 1, 1));
        final Room room1 = new Room();
        room1.setId(0L);
        room1.setDailyRate(0.0);
        booking2.setRooms(List.of(room1));
        final Additional additional1 = new Additional();
        additional1.setPrice(0.0);
        booking2.setAdditional(List.of(additional1));
        booking2.setTotalValue(0.0);
        booking2.setGuests(0);
        when(mockBookingRepository.save(any(Booking.class))).thenReturn(booking2);

        // Run the test
        final BookingDTO result = bookingServiceImplUnderTest.updateBooking(0L, bookingDto);

        // Verify the results
    }

    @Test
    void testUpdateBooking_BookingRepositoryFindByIdReturnsAbsent() {
        // Setup
        final BookingDTO bookingDto = new BookingDTO();
        bookingDto.setId(0L);
        bookingDto.setIdClient(0L);
        bookingDto.setCheckInDate(LocalDate.of(2020, 1, 1));
        bookingDto.setCheckOutDate(LocalDate.of(2020, 1, 1));
        bookingDto.setRooms(List.of(0L));
        bookingDto.setServices(List.of(0L));
        bookingDto.setTotalValue(0.0);
        bookingDto.setGuests(0);

        when(mockBookingRepository.findById(0L)).thenReturn(Optional.empty());

        // Run the test
        assertThatThrownBy(() -> bookingServiceImplUnderTest.updateBooking(0L, bookingDto))
                .isInstanceOf(BookingNotFoundException.class);
    }

    @Test
    void testUpdateBooking_AdditionalRepositoryReturnsNoItems() throws Exception {
        // Setup
        final BookingDTO bookingDto = new BookingDTO();
        bookingDto.setId(0L);
        bookingDto.setIdClient(0L);
        bookingDto.setCheckInDate(LocalDate.of(2020, 1, 1));
        bookingDto.setCheckOutDate(LocalDate.of(2020, 1, 1));
        bookingDto.setRooms(List.of(0L));
        bookingDto.setServices(List.of(0L));
        bookingDto.setTotalValue(0.0);
        bookingDto.setGuests(0);

        // Configure BookingRepository.findById(...).
        final Booking booking1 = new Booking();
        booking1.setId(0L);
        final Client client = new Client();
        client.setId(0L);
        booking1.setClient(client);
        booking1.setCheckInDate(LocalDate.of(2020, 1, 1));
        booking1.setCheckOutDate(LocalDate.of(2020, 1, 1));
        final Room room = new Room();
        room.setId(0L);
        room.setDailyRate(0.0);
        booking1.setRooms(List.of(room));
        final Additional additional = new Additional();
        additional.setPrice(0.0);
        booking1.setAdditional(List.of(additional));
        booking1.setTotalValue(0.0);
        booking1.setGuests(0);
        final Optional<Booking> booking = Optional.of(booking1);
        when(mockBookingRepository.findById(0L)).thenReturn(booking);

        when(mockAdditionalRepository.findAllById(List.of(0L))).thenReturn(Collections.emptyList());

        // Configure BookingRepository.save(...).
        final Booking booking2 = new Booking();
        booking2.setId(0L);
        final Client client1 = new Client();
        client1.setId(0L);
        booking2.setClient(client1);
        booking2.setCheckInDate(LocalDate.of(2020, 1, 1));
        booking2.setCheckOutDate(LocalDate.of(2020, 1, 1));
        final Room room1 = new Room();
        room1.setId(0L);
        room1.setDailyRate(0.0);
        booking2.setRooms(List.of(room1));
        final Additional additional1 = new Additional();
        additional1.setPrice(0.0);
        booking2.setAdditional(List.of(additional1));
        booking2.setTotalValue(0.0);
        booking2.setGuests(0);
        when(mockBookingRepository.save(any(Booking.class))).thenReturn(booking2);

        // Run the test
        final BookingDTO result = bookingServiceImplUnderTest.updateBooking(0L, bookingDto);

        // Verify the results
    }

    @Test
    void testDelete() {
        // Setup
        // Run the test
        when(mockBookingRepository.existsById(0L)).thenReturn(true);
        bookingServiceImplUnderTest.delete(0L);

        // Verify the results
        verify(mockBookingRepository).deleteById(0L);
    }
}
