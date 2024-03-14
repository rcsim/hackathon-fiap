package com.postech30.hackathon.controller;

import com.postech30.hackathon.dto.BookingDTO;
import com.postech30.hackathon.service.BookingService;
import com.postech30.hackathon.service.impl.EmailServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookingController.class)
class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookingService mockBookingService;
    @MockBean
    private EmailServiceImpl mockEmailService;

    @Test
    void testGetBooking1() throws Exception {
        final BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(0L);
        bookingDTO.setIdClient(0L);
        bookingDTO.setCheckInDate(LocalDate.of(2020, 1, 1));
        bookingDTO.setCheckOutDate(LocalDate.of(2020, 1, 1));
        bookingDTO.setRooms(List.of(0L));
        final Page<BookingDTO> bookingDTOS = new PageImpl<>(List.of(bookingDTO));
        when(mockBookingService.getAll(any(Pageable.class))).thenReturn(bookingDTOS);

        final MockHttpServletResponse response = mockMvc.perform(get("/book")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void testGetBooking1_BookingServiceReturnsNoItems() throws Exception {
        when(mockBookingService.getAll(any(Pageable.class))).thenReturn(new PageImpl<>(Collections.emptyList()));

        final MockHttpServletResponse response = mockMvc.perform(get("/book")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void testGetBooking2() throws Exception {
        final BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(0L);
        bookingDTO.setIdClient(0L);
        bookingDTO.setCheckInDate(LocalDate.of(2020, 1, 1));
        bookingDTO.setCheckOutDate(LocalDate.of(2020, 1, 1));
        bookingDTO.setRooms(List.of(0L));
        when(mockBookingService.getBookingById(0L)).thenReturn(bookingDTO);

        final MockHttpServletResponse response = mockMvc.perform(get("/book/{id}", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void testDeleteBooking() throws Exception {
        final MockHttpServletResponse response = mockMvc.perform(delete("/book/{id}", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("Reserva deletada com sucesso");
        verify(mockBookingService).delete(0L);
    }
}
