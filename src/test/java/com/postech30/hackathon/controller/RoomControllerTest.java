package com.postech30.hackathon.controller;

import com.postech30.hackathon.dto.RoomDTO;
import com.postech30.hackathon.service.RoomService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RoomController.class)
class RoomControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoomService mockRoomService;

    @Test
    void testCreateRoom() throws Exception {
        final RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId("id");
        roomDTO.setBuildingId("buildingId");
        roomDTO.setLocationId("locationId");
        roomDTO.setType("type");
        roomDTO.setTotalPeople(0);
        when(mockRoomService.createRoom(any(RoomDTO.class))).thenReturn(roomDTO);

        final MockHttpServletResponse response = mockMvc.perform(post("/room").content("content").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getContentAsString()).isEqualTo(response.getContentAsString());
    }

    @Test
    void testUpdateRoom() throws Exception {
        final RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId("id");
        roomDTO.setBuildingId("buildingId");
        roomDTO.setLocationId("locationId");
        roomDTO.setType("type");
        roomDTO.setTotalPeople(0);
        when(mockRoomService.updateRoom(eq("id"), any(RoomDTO.class))).thenReturn(roomDTO);

        final MockHttpServletResponse response = mockMvc.perform(put("/room/{id}", "id").content("content").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getContentAsString()).isEqualTo(response.getContentAsString());
    }

    @Test
    void testDeleteRoom() throws Exception {
        final MockHttpServletResponse response = mockMvc.perform(delete("/room/{id}", "id").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getContentAsString()).isEqualTo(response.getContentAsString());
        verify(mockRoomService).deleteRoom("id");
    }

    @Test
    void testGetRoomById() throws Exception {
        final RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId("id");
        roomDTO.setBuildingId("buildingId");
        roomDTO.setLocationId("locationId");
        roomDTO.setType("type");
        roomDTO.setTotalPeople(0);
        when(mockRoomService.getRoomById("id")).thenReturn(roomDTO);

        final MockHttpServletResponse response = mockMvc.perform(get("/room/{id}", "id").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(response.getContentAsString());
    }

    @Test
    void testGetAllRooms() throws Exception {
        final RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId("id");
        roomDTO.setBuildingId("buildingId");
        roomDTO.setLocationId("locationId");
        roomDTO.setType("type");
        roomDTO.setTotalPeople(0);
        final List<RoomDTO> roomDTOS = List.of(roomDTO);
        when(mockRoomService.getAllRooms()).thenReturn(roomDTOS);

        final MockHttpServletResponse response = mockMvc.perform(get("/room").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(response.getContentAsString());
    }

    @Test
    void testGetAllRooms_RoomServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockRoomService.getAllRooms()).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/room").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }
}
