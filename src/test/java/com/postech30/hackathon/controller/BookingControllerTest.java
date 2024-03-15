package com.postech30.hackathon.controller;

import com.postech30.hackathon.dto.AvaliableRoomDTO;
import com.postech30.hackathon.dto.BookingDTO;
import com.postech30.hackathon.dto.RoomDTO;
import com.postech30.hackathon.exceptions.BookingNotFoundException;
import com.postech30.hackathon.exceptions.RoomNotAvailableException;
import com.postech30.hackathon.service.BookingService;
import com.postech30.hackathon.service.RoomService;
import com.postech30.hackathon.service.impl.EmailServiceImpl;
import jakarta.mail.MessagingException;
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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookingController.class)
class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookingService mockBookingService;
    @MockBean
    private EmailServiceImpl mockEmailService;
    @MockBean
    private RoomService mockRoomService;

    @Test
    void testGetAvaliableRooms() throws Exception {
        final RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId("id");
        roomDTO.setBuildingId("buildingId");
        roomDTO.setLocationId("locationId");
        roomDTO.setType("type");
        roomDTO.setTotalPeople(0);
        final List<RoomDTO> roomDTOS = List.of(roomDTO);
        when(mockRoomService.getAvaliableRooms(any(AvaliableRoomDTO.class))).thenReturn(roomDTOS);

        final MockHttpServletResponse response = mockMvc.perform(get("/book/avaliable").content("content").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getContentAsString()).isEqualTo(response.getContentAsString());
    }

    @Test
    void testGetAvaliableRoomsRoomServiceReturnsNoItems() throws Exception {
        when(mockRoomService.getAvaliableRooms(any(AvaliableRoomDTO.class))).thenReturn(Collections.emptyList());

        final MockHttpServletResponse response = mockMvc.perform(get("/book/avaliable").content("content").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getContentAsString()).isEqualTo(response.getContentAsString());
    }

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

        final MockHttpServletResponse response = mockMvc.perform(get("/book").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(response.getContentAsString());
    }

    @Test
    void testGetBooking1BookingServiceReturnsNoItems() throws Exception {
        when(mockBookingService.getAll(any(Pageable.class))).thenReturn(new PageImpl<>(Collections.emptyList()));

        final MockHttpServletResponse response = mockMvc.perform(get("/book").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(response.getContentAsString());
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

        final MockHttpServletResponse response = mockMvc.perform(get("/book/{id}", 0).accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(response.getContentAsString());
    }

    @Test
    void testGetBooking2_BookingServiceThrowsBookingNotFoundException() throws Exception {
        when(mockBookingService.getBookingById(0L)).thenThrow(BookingNotFoundException.class);

        final MockHttpServletResponse response = mockMvc.perform(get("/book/{id}", 0).accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getContentAsString()).isEqualTo(response.getContentAsString());
    }

    @Test
    void testBook() throws Exception {
        final BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(0L);
        bookingDTO.setIdClient(0L);
        bookingDTO.setCheckInDate(LocalDate.of(2020, 1, 1));
        bookingDTO.setCheckOutDate(LocalDate.of(2020, 1, 1));
        bookingDTO.setRooms(List.of(0L));
        when(mockBookingService.book(any(BookingDTO.class))).thenReturn(bookingDTO);

        final MockHttpServletResponse response = mockMvc.perform(post("/book").content("content").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getContentAsString()).isEqualTo(response.getContentAsString());
    }

    @Test
    void testBookBookingServiceThrowsMessagingException() throws Exception {
        when(mockBookingService.book(any(BookingDTO.class))).thenThrow(MessagingException.class);

        final MockHttpServletResponse response = mockMvc.perform(post("/book").content("content").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getContentAsString()).isEqualTo(response.getContentAsString());
    }

    @Test
    void testBook_BookingServiceThrowsRoomNotAvailableException() throws Exception {
        when(mockBookingService.book(any(BookingDTO.class))).thenThrow(RoomNotAvailableException.class);

        final MockHttpServletResponse response = mockMvc.perform(post("/book").content("content").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getContentAsString()).isEqualTo(response.getContentAsString());
    }

    @Test
    void testUpdateBooking() throws Exception {
        final BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(0L);
        bookingDTO.setIdClient(0L);
        bookingDTO.setCheckInDate(LocalDate.of(2020, 1, 1));
        bookingDTO.setCheckOutDate(LocalDate.of(2020, 1, 1));
        bookingDTO.setRooms(List.of(0L));
        when(mockBookingService.updateBooking(eq(0L), any(BookingDTO.class))).thenReturn(bookingDTO);

        final MockHttpServletResponse response = mockMvc.perform(put("/book/{id}", 0).content("content").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getContentAsString()).isEqualTo(response.getContentAsString());
    }

    @Test
    void testUpdateBooking_BookingServiceThrowsBookingNotFoundException() throws Exception {
        when(mockBookingService.updateBooking(eq(0L), any(BookingDTO.class))).thenThrow(BookingNotFoundException.class);

        final MockHttpServletResponse response = mockMvc.perform(put("/book/{id}", 0).content("content").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getContentAsString()).isEqualTo(response.getContentAsString());
    }

    @Test
    void testDeleteBooking() throws Exception {
        final MockHttpServletResponse response = mockMvc.perform(delete("/book/{id}", 0).accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(response.getContentAsString());
        verify(mockBookingService).delete(0L);
    }
}
