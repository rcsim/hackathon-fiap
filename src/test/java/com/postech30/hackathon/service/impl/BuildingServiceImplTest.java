package com.postech30.hackathon.service.impl;

import com.postech30.hackathon.dto.BuildingDTO;
import com.postech30.hackathon.entity.Building;
import com.postech30.hackathon.entity.Location;
import com.postech30.hackathon.exceptions.ResourceNotFoundException;
import com.postech30.hackathon.repository.BuildingRepository;
import com.postech30.hackathon.repository.LocationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BuildingServiceImplTest {

    @Mock
    private BuildingRepository mockBuildingRepository;
    @Mock
    private LocationRepository mockLocationRepository;

    @InjectMocks
    private BuildingServiceImpl buildingServiceImplUnderTest;

    @Test
    void testUpdateBuilding_BuildingRepositoryFindByIdReturnsAbsent() {
        // Setup
        final BuildingDTO buildingDTO = new BuildingDTO("id", "locationId", "name");
        when(mockBuildingRepository.findById(0L)).thenReturn(Optional.empty());

        // Run the test
        assertThatThrownBy(() -> buildingServiceImplUnderTest.updateBuilding(String.valueOf(0L), buildingDTO))
                .isInstanceOf(ResourceNotFoundException.class);
    }

    @Test
    void testDeleteBuilding() {
        // Setup
        // Run the test
        when(mockBuildingRepository.existsById(0L)).thenReturn(true);
        buildingServiceImplUnderTest.deleteBuilding(String.valueOf(0L));

        // Verify the results
        verify(mockBuildingRepository).deleteById(0L);
    }

    @Test
    void testGetBuildingById() {
        // Setup
        // Configure BuildingRepository.findById(...).
        final Building building1 = new Building();
        building1.setId(0L);
        final Location location = new Location();
        location.setId(0L);
        location.setName("name");
        building1.setLocation(location);
        building1.setName("name");
        final Optional<Building> building = Optional.of(building1);
        when(mockBuildingRepository.findById(0L)).thenReturn(building);

        // Run the test
        final BuildingDTO result = buildingServiceImplUnderTest.getBuildingById(String.valueOf(0L));

        // Verify the results
    }

    @Test
    void testGetBuildingById_BuildingRepositoryReturnsAbsent() {
        // Setup
        when(mockBuildingRepository.findById(0L)).thenReturn(Optional.empty());

        // Run the test
        assertThatThrownBy(() -> buildingServiceImplUnderTest.getBuildingById(String.valueOf(0L)))
                .isInstanceOf(ResourceNotFoundException.class);
    }

    @Test
    void testGetAllBuildings() {
        // Setup
        // Configure BuildingRepository.findAll(...).
        final Building building = new Building();
        building.setId(0L);
        final Location location = new Location();
        location.setId(0L);
        location.setName("name");
        building.setLocation(location);
        building.setName("name");
        final List<Building> buildings = List.of(building);
        when(mockBuildingRepository.findAll()).thenReturn(buildings);

        // Run the test
        final List<BuildingDTO> result = buildingServiceImplUnderTest.getAllBuildings();

        // Verify the results
    }

    @Test
    void testGetAllBuildings_BuildingRepositoryReturnsNoItems() {
        // Setup
        when(mockBuildingRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<BuildingDTO> result = buildingServiceImplUnderTest.getAllBuildings();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }
}
