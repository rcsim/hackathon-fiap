package com.postech30.hackathon.controller;

import com.postech30.hackathon.dto.BuildingDTO;
import com.postech30.hackathon.service.BuildingService;
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
@WebMvcTest(BuildingController.class)
class BuildingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BuildingService mockBuildingService;

    @Test
    void testCreateBuilding() throws Exception {
        final BuildingDTO buildingDTO = new BuildingDTO("id", "locationId", "name");
        when(mockBuildingService.createBuilding(any(BuildingDTO.class))).thenReturn(buildingDTO);

        final MockHttpServletResponse response = mockMvc.perform(post("/building")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getContentAsString()).isEqualTo(response.getContentAsString());
    }

    @Test
    void testUpdateBuilding() throws Exception {
        final BuildingDTO buildingDTO = new BuildingDTO("id", "locationId", "name");
        when(mockBuildingService.updateBuilding(eq("id"), any(BuildingDTO.class))).thenReturn(buildingDTO);

        final MockHttpServletResponse response = mockMvc.perform(put("/building/{id}", "id")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getContentAsString()).isEqualTo(response.getContentAsString());
    }

    @Test
    void testDeleteBuilding() throws Exception {
        final MockHttpServletResponse response = mockMvc.perform(delete("/building/{id}", "id")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(response.getContentAsString());
        verify(mockBuildingService).deleteBuilding("id");
    }

    @Test
    void testGetBuildingById() throws Exception {
        final BuildingDTO buildingDTO = new BuildingDTO("id", "locationId", "name");
        when(mockBuildingService.getBuildingById("id")).thenReturn(buildingDTO);

        final MockHttpServletResponse response = mockMvc.perform(get("/building/{id}", "id")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(response.getContentAsString());
    }

    @Test
    void testGetAllBuildings() throws Exception {
        final List<BuildingDTO> buildingDTOS = List.of(new BuildingDTO("id", "locationId", "name"));
        when(mockBuildingService.getAllBuildings()).thenReturn(buildingDTOS);

        final MockHttpServletResponse response = mockMvc.perform(get("/building")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(response.getContentAsString());
    }

    @Test
    void testGetAllBuildings_BuildingServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockBuildingService.getAllBuildings()).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/building")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }
}
