package com.postech30.hackathon.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.postech30.hackathon.dto.BookingDTO;
import com.postech30.hackathon.mock.BookingMock;
import com.postech30.hackathon.service.BookingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookingService bookingService;

    @Test
    public void testGetBooking() throws Exception {
        Page<BookingDTO> bookings = new PageImpl<>(List.of(new BookingDTO()));
        when(bookingService.getAll(any(Pageable.class))).thenReturn(bookings);

        mockMvc.perform(MockMvcRequestBuilders.get("/book")
                        .param("page", "0")
                        .param("size", "5"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetBookingById() throws Exception {
        Long id = 1L; // Use um ID válido aqui
        BookingDTO bookingDTO = new BookingDTO();
        when(bookingService.getBookingById(id)).thenReturn(bookingDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/book/" + id))
                .andExpect(status().isOk());
    }
    @Test
    public void testBook() throws Exception {
        BookingDTO bookingDTO = BookingMock.getBookingMock();
        when(bookingService.book(bookingDTO)).thenReturn(bookingDTO);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        String json = objectMapper.writeValueAsString(bookingDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/book")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }
    @Test
    public void testUpdateBooking() throws Exception {
        Long id = 1L;
        BookingDTO bookingDTO = BookingMock.getBookingMock();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        String json = objectMapper.writeValueAsString(bookingDTO);
        when(bookingService.updateBooking(id, bookingDTO)).thenReturn(bookingDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/book")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }
    @Test
    public void testDeleteBooking() throws Exception {
        Long id = 1L;
        doNothing().when(bookingService).delete(id);

        mockMvc.perform(MockMvcRequestBuilders.delete("/book/" + id))
                .andExpect(status().isOk());
    }



}
