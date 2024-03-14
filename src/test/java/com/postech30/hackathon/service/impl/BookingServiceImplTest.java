package com.postech30.hackathon.service.impl;

import com.postech30.hackathon.dto.BookingDTO;
import com.postech30.hackathon.entity.Additional;
import com.postech30.hackathon.entity.Booking;
import com.postech30.hackathon.entity.Client;
import com.postech30.hackathon.exceptions.BookingNotFoundException;
import com.postech30.hackathon.exceptions.ResourceNotFoundException;
import com.postech30.hackathon.repository.AdditionalRepository;
import com.postech30.hackathon.repository.BookingRepository;
import com.postech30.hackathon.repository.ClientRepository;
import jakarta.mail.MessagingException;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookingServiceImplTest {

    @Mock
    private BookingRepository mockBookingRepository;
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
        final Booking booking = new Booking();
        booking.setId(0L);
        final Client client = new Client();
        client.setId(0L);
        booking.setClient(client);
        booking.setCheckInDate(LocalDate.of(2020, 1, 1));
        booking.setCheckOutDate(LocalDate.of(2020, 1, 1));
        final Additional additional = new Additional();
        additional.setPrice(0.0);
        booking.setAdditional(List.of(additional));
        booking.setTotalValue(0.0);
        booking.setGuests(0);
        final Page<Booking> bookings = new PageImpl<>(List.of(booking));
        when(mockBookingRepository.findAll(any(Pageable.class))).thenReturn(bookings);

        final Page<BookingDTO> result = bookingServiceImplUnderTest.getAll(PageRequest.of(0, 1));

    }

    @Test
    void testGetAllBookingRepositoryReturnsNoItems() {
        when(mockBookingRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(Collections.emptyList()));

        final Page<BookingDTO> result = bookingServiceImplUnderTest.getAll(PageRequest.of(0, 1));

    }

    @Test
    void testGetBookingById() throws Exception {
        final Booking booking1 = new Booking();
        booking1.setId(0L);
        final Client client = new Client();
        client.setId(0L);
        booking1.setClient(client);
        booking1.setCheckInDate(LocalDate.of(2020, 1, 1));
        booking1.setCheckOutDate(LocalDate.of(2020, 1, 1));
        final Additional additional = new Additional();
        additional.setPrice(0.0);
        booking1.setAdditional(List.of(additional));
        booking1.setTotalValue(0.0);
        booking1.setGuests(0);
        final Optional<Booking> booking = Optional.of(booking1);
        when(mockBookingRepository.findById(0L)).thenReturn(booking);

        final BookingDTO result = bookingServiceImplUnderTest.getBookingById(0L);

    }

    @Test
    void testGetBookingByIdBookingRepositoryReturnsAbsent() {
        when(mockBookingRepository.findById(0L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> bookingServiceImplUnderTest.getBookingById(0L))
                .isInstanceOf(BookingNotFoundException.class);
    }

    @Test
    void testBook() throws Exception {
        final BookingDTO bookingDto = new BookingDTO();
        bookingDto.setId(0L);
        bookingDto.setIdClient(0L);
        bookingDto.setCheckInDate(LocalDate.of(2020, 1, 1));
        bookingDto.setCheckOutDate(LocalDate.of(2020, 1, 1));
        bookingDto.setServices(List.of(0L));
        bookingDto.setTotalValue(0.0);
        bookingDto.setGuests(0);

        final Client client1 = new Client();
        client1.setId(0L);
        client1.setCountry("country");
        client1.setCpf("cpf");
        client1.setPassport("passport");
        client1.setFullName("fullName");
        final Optional<Client> client = Optional.of(client1);
        when(mockClientRepository.findById(0L)).thenReturn(client);

        final Booking booking = new Booking();
        booking.setId(0L);
        final Client client2 = new Client();
        client2.setId(0L);
        booking.setClient(client2);
        booking.setCheckInDate(LocalDate.of(2020, 1, 1));
        booking.setCheckOutDate(LocalDate.of(2020, 1, 1));
        final Additional additional = new Additional();
        additional.setPrice(0.0);
        booking.setAdditional(List.of(additional));
        booking.setTotalValue(0.0);
        booking.setGuests(0);
        when(mockBookingRepository.save(any(Booking.class))).thenReturn(booking);

        final List<Additional> additionals = List.of(new Additional(0L, "name", "description", 0.0, "type"));
        when(mockAdditionalRepository.findAllById(List.of(0L))).thenReturn(additionals);

        final BookingDTO result = bookingServiceImplUnderTest.book(bookingDto);

        verify(mockEmailService).sendMail(any(Booking.class));
    }

    @Test
    void testBookClientRepositoryReturnsAbsent() {
        final BookingDTO bookingDto = new BookingDTO();
        bookingDto.setId(0L);
        bookingDto.setIdClient(0L);
        bookingDto.setCheckInDate(LocalDate.of(2020, 1, 1));
        bookingDto.setCheckOutDate(LocalDate.of(2020, 1, 1));
        bookingDto.setServices(List.of(0L));
        bookingDto.setTotalValue(0.0);
        bookingDto.setGuests(0);

        when(mockClientRepository.findById(0L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> bookingServiceImplUnderTest.book(bookingDto))
                .isInstanceOf(ResourceNotFoundException.class);
    }

    @Test
    void testBookAdditionalRepositoryReturnsNoItems() throws Exception {
        final BookingDTO bookingDto = new BookingDTO();
        bookingDto.setId(0L);
        bookingDto.setIdClient(0L);
        bookingDto.setCheckInDate(LocalDate.of(2020, 1, 1));
        bookingDto.setCheckOutDate(LocalDate.of(2020, 1, 1));
        bookingDto.setServices(List.of(0L));
        bookingDto.setTotalValue(0.0);
        bookingDto.setGuests(0);

        final Client client1 = new Client();
        client1.setId(0L);
        client1.setCountry("country");
        client1.setCpf("cpf");
        client1.setPassport("passport");
        client1.setFullName("fullName");
        final Optional<Client> client = Optional.of(client1);
        when(mockClientRepository.findById(0L)).thenReturn(client);

        final Booking booking = new Booking();
        booking.setId(0L);
        final Client client2 = new Client();
        client2.setId(0L);
        booking.setClient(client2);
        booking.setCheckInDate(LocalDate.of(2020, 1, 1));
        booking.setCheckOutDate(LocalDate.of(2020, 1, 1));
        final Additional additional = new Additional();
        additional.setPrice(0.0);
        booking.setAdditional(List.of(additional));
        booking.setTotalValue(0.0);
        booking.setGuests(0);
        when(mockBookingRepository.save(any(Booking.class))).thenReturn(booking);

        when(mockAdditionalRepository.findAllById(List.of(0L))).thenReturn(Collections.emptyList());

        final BookingDTO result = bookingServiceImplUnderTest.book(bookingDto);

        verify(mockEmailService).sendMail(any(Booking.class));
    }

    @Test
    void testBookEmailServiceImplThrowsMessagingException() throws Exception {
        final BookingDTO bookingDto = new BookingDTO();
        bookingDto.setId(0L);
        bookingDto.setIdClient(0L);
        bookingDto.setCheckInDate(LocalDate.of(2020, 1, 1));
        bookingDto.setCheckOutDate(LocalDate.of(2020, 1, 1));
        bookingDto.setServices(List.of(0L));
        bookingDto.setTotalValue(0.0);
        bookingDto.setGuests(0);

        final Client client1 = new Client();
        client1.setId(0L);
        client1.setCountry("country");
        client1.setCpf("cpf");
        client1.setPassport("passport");
        client1.setFullName("fullName");
        final Optional<Client> client = Optional.of(client1);
        when(mockClientRepository.findById(0L)).thenReturn(client);

        final Booking booking = new Booking();
        booking.setId(0L);
        final Client client2 = new Client();
        client2.setId(0L);
        booking.setClient(client2);
        booking.setCheckInDate(LocalDate.of(2020, 1, 1));
        booking.setCheckOutDate(LocalDate.of(2020, 1, 1));
        final Additional additional = new Additional();
        additional.setPrice(0.0);
        booking.setAdditional(List.of(additional));
        booking.setTotalValue(0.0);
        booking.setGuests(0);
        when(mockBookingRepository.save(any(Booking.class))).thenReturn(booking);

        final List<Additional> additionals = List.of(new Additional(0L, "name", "description", 0.0, "type"));
        when(mockAdditionalRepository.findAllById(List.of(0L))).thenReturn(additionals);

        doThrow(MessagingException.class).when(mockEmailService).sendMail(any(Booking.class));

        assertThatThrownBy(() -> bookingServiceImplUnderTest.book(bookingDto)).isInstanceOf(MessagingException.class);
    }

    @Test
    void testUpdateBooking() throws Exception {
        final BookingDTO bookingDto = new BookingDTO();
        bookingDto.setId(0L);
        bookingDto.setIdClient(0L);
        bookingDto.setCheckInDate(LocalDate.of(2020, 1, 1));
        bookingDto.setCheckOutDate(LocalDate.of(2020, 1, 1));
        bookingDto.setServices(List.of(0L));
        bookingDto.setTotalValue(0.0);
        bookingDto.setGuests(0);

        final Booking booking1 = new Booking();
        booking1.setId(0L);
        final Client client = new Client();
        client.setId(0L);
        booking1.setClient(client);
        booking1.setCheckInDate(LocalDate.of(2020, 1, 1));
        booking1.setCheckOutDate(LocalDate.of(2020, 1, 1));
        final Additional additional = new Additional();
        additional.setPrice(0.0);
        booking1.setAdditional(List.of(additional));
        booking1.setTotalValue(0.0);
        booking1.setGuests(0);
        final Optional<Booking> booking = Optional.of(booking1);
        when(mockBookingRepository.findById(0L)).thenReturn(booking);

        final List<Additional> additionals = List.of(new Additional(0L, "name", "description", 0.0, "type"));
        when(mockAdditionalRepository.findAllById(List.of(0L))).thenReturn(additionals);

        final Booking booking2 = new Booking();
        booking2.setId(0L);
        final Client client1 = new Client();
        client1.setId(0L);
        booking2.setClient(client1);
        booking2.setCheckInDate(LocalDate.of(2020, 1, 1));
        booking2.setCheckOutDate(LocalDate.of(2020, 1, 1));
        final Additional additional1 = new Additional();
        additional1.setPrice(0.0);
        booking2.setAdditional(List.of(additional1));
        booking2.setTotalValue(0.0);
        booking2.setGuests(0);
        when(mockBookingRepository.save(any(Booking.class))).thenReturn(booking2);

        final BookingDTO result = bookingServiceImplUnderTest.updateBooking(0L, bookingDto);

    }

    @Test
    void testUpdateBookingBookingRepositoryFindByIdReturnsAbsent() {
        final BookingDTO bookingDto = new BookingDTO();
        bookingDto.setId(0L);
        bookingDto.setIdClient(0L);
        bookingDto.setCheckInDate(LocalDate.of(2020, 1, 1));
        bookingDto.setCheckOutDate(LocalDate.of(2020, 1, 1));
        bookingDto.setServices(List.of(0L));
        bookingDto.setTotalValue(0.0);
        bookingDto.setGuests(0);

        when(mockBookingRepository.findById(0L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> bookingServiceImplUnderTest.updateBooking(0L, bookingDto))
                .isInstanceOf(BookingNotFoundException.class);
    }

    @Test
    void testUpdateBookingAdditionalRepositoryReturnsNoItems() throws Exception {
        final BookingDTO bookingDto = new BookingDTO();
        bookingDto.setId(0L);
        bookingDto.setIdClient(0L);
        bookingDto.setCheckInDate(LocalDate.of(2020, 1, 1));
        bookingDto.setCheckOutDate(LocalDate.of(2020, 1, 1));
        bookingDto.setServices(List.of(0L));
        bookingDto.setTotalValue(0.0);
        bookingDto.setGuests(0);

        final Booking booking1 = new Booking();
        booking1.setId(0L);
        final Client client = new Client();
        client.setId(0L);
        booking1.setClient(client);
        booking1.setCheckInDate(LocalDate.of(2020, 1, 1));
        booking1.setCheckOutDate(LocalDate.of(2020, 1, 1));
        final Additional additional = new Additional();
        additional.setPrice(0.0);
        booking1.setAdditional(List.of(additional));
        booking1.setTotalValue(0.0);
        booking1.setGuests(0);
        final Optional<Booking> booking = Optional.of(booking1);
        when(mockBookingRepository.findById(0L)).thenReturn(booking);

        when(mockAdditionalRepository.findAllById(List.of(0L))).thenReturn(Collections.emptyList());

        final Booking booking2 = new Booking();
        booking2.setId(0L);
        final Client client1 = new Client();
        client1.setId(0L);
        booking2.setClient(client1);
        booking2.setCheckInDate(LocalDate.of(2020, 1, 1));
        booking2.setCheckOutDate(LocalDate.of(2020, 1, 1));
        final Additional additional1 = new Additional();
        additional1.setPrice(0.0);
        booking2.setAdditional(List.of(additional1));
        booking2.setTotalValue(0.0);
        booking2.setGuests(0);
        when(mockBookingRepository.save(any(Booking.class))).thenReturn(booking2);

        final BookingDTO result = bookingServiceImplUnderTest.updateBooking(0L, bookingDto);

    }

    @Test
    void testDelete() {
        bookingServiceImplUnderTest.delete(0L);

        verify(mockBookingRepository).deleteById(0L);
    }
}
