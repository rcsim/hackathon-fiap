package com.postech30.hackathon.controller;

import com.postech30.hackathon.dto.LocationDTO;
import com.postech30.hackathon.service.LocationService;
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
@WebMvcTest(LocationController.class)
class LocationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocationService mockLocationService;

    @Test
    void testCreateLocation() throws Exception {
        final LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId("id");
        locationDTO.setName("name");
        locationDTO.setAddress("address");
        locationDTO.setZipCode("zipCode");
        locationDTO.setCity("city");
        when(mockLocationService.createLocation(any(LocationDTO.class))).thenReturn(locationDTO);

        final MockHttpServletResponse response = mockMvc.perform(post("/location").content("content").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getContentAsString()).isEqualTo(response.getContentAsString());
    }

    @Test
    void testUpdateLocation() throws Exception {
        final LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId("id");
        locationDTO.setName("name");
        locationDTO.setAddress("address");
        locationDTO.setZipCode("zipCode");
        locationDTO.setCity("city");
        when(mockLocationService.updateLocation(eq("id"), any(LocationDTO.class))).thenReturn(locationDTO);

        final MockHttpServletResponse response = mockMvc.perform(put("/location/{id}", "id").content("content").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getContentAsString()).isEqualTo(response.getContentAsString());
    }

    @Test
    void testDeleteLocation() throws Exception {
        final MockHttpServletResponse response = mockMvc.perform(delete("/location/{id}", "id").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getContentAsString()).isEqualTo(response.getContentAsString());
        verify(mockLocationService).deleteLocation("id");
    }

    @Test
    void testGetLocationById() throws Exception {
        final LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId("id");
        locationDTO.setName("name");
        locationDTO.setAddress("address");
        locationDTO.setZipCode("zipCode");
        locationDTO.setCity("city");
        when(mockLocationService.getLocationById("id")).thenReturn(locationDTO);

        final MockHttpServletResponse response = mockMvc.perform(get("/location/{id}", "id").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(response.getContentAsString());
    }

    @Test
    void testGetAllLocations() throws Exception {
        final LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId("id");
        locationDTO.setName("name");
        locationDTO.setAddress("address");
        locationDTO.setZipCode("zipCode");
        locationDTO.setCity("city");
        final List<LocationDTO> locationDTOS = List.of(locationDTO);
        when(mockLocationService.getAllLocations()).thenReturn(locationDTOS);

        final MockHttpServletResponse response = mockMvc.perform(get("/location").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(response.getContentAsString());
    }

    @Test
    void testGetAllLocations_LocationServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockLocationService.getAllLocations()).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/location").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }
}
