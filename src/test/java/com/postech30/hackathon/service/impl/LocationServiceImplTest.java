package com.postech30.hackathon.service.impl;

import com.postech30.hackathon.dto.LocationDTO;
import com.postech30.hackathon.entity.Location;
import com.postech30.hackathon.exceptions.ResourceNotFoundException;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LocationServiceImplTest {

    @Mock
    private LocationRepository mockLocationRepository;

    @InjectMocks
    private LocationServiceImpl locationServiceImplUnderTest;

    @Test
    void testCreateLocation() {
        final LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId("id");
        locationDTO.setName("name");
        locationDTO.setAddress("address");
        locationDTO.setZipCode("zipCode");
        locationDTO.setCity("city");
        locationDTO.setState("state");

        final Location location = new Location();
        location.setId(0L);
        location.setName("name");
        location.setAddress("address");
        location.setZipCode("zipCode");
        location.setCity("city");
        location.setState("state");
        when(mockLocationRepository.save(any(Location.class))).thenReturn(location);

        final LocationDTO result = locationServiceImplUnderTest.createLocation(locationDTO);

    }

    @Test
    void testUpdateLocation() {
        final LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId("id");
        locationDTO.setName("name");
        locationDTO.setAddress("address");
        locationDTO.setZipCode("zipCode");
        locationDTO.setCity("city");
        locationDTO.setState("state");

        final Location location1 = new Location();
        location1.setId(0L);
        location1.setName("name");
        location1.setAddress("address");
        location1.setZipCode("zipCode");
        location1.setCity("city");
        location1.setState("state");
        final Optional<Location> location = Optional.of(location1);
        when(mockLocationRepository.findById(0L)).thenReturn(location);

        final Location location2 = new Location();
        location2.setId(0L);
        location2.setName("name");
        location2.setAddress("address");
        location2.setZipCode("zipCode");
        location2.setCity("city");
        location2.setState("state");
        when(mockLocationRepository.save(any(Location.class))).thenReturn(location2);

        final LocationDTO result = locationServiceImplUnderTest.updateLocation(String.valueOf(0L), locationDTO);

    }

    @Test
    void testUpdateLocation_LocationRepositoryFindByIdReturnsAbsent() {
        final LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId("id");
        locationDTO.setName("name");
        locationDTO.setAddress("address");
        locationDTO.setZipCode("zipCode");
        locationDTO.setCity("city");
        locationDTO.setState("state");

        when(mockLocationRepository.findById(0L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> locationServiceImplUnderTest.updateLocation(String.valueOf(0L), locationDTO))
                .isInstanceOf(ResourceNotFoundException.class);
    }

    @Test
    void testDeleteLocation() {
        when(mockLocationRepository.existsById(0L)).thenReturn(true);
        locationServiceImplUnderTest.deleteLocation(String.valueOf(0L));

        verify(mockLocationRepository).deleteById(0L);
    }

    @Test
    void testGetLocationById() {
        final Location location1 = new Location();
        location1.setId(0L);
        location1.setName("name");
        location1.setAddress("address");
        location1.setZipCode("zipCode");
        location1.setCity("city");
        location1.setState("state");
        final Optional<Location> location = Optional.of(location1);
        when(mockLocationRepository.findById(0L)).thenReturn(location);

        final LocationDTO result = locationServiceImplUnderTest.getLocationById(String.valueOf(0L));

    }

    @Test
    void testGetLocationById_LocationRepositoryReturnsAbsent() {
        // Setup
        when(mockLocationRepository.findById(0L)).thenReturn(Optional.empty());

        // Run the test
        assertThatThrownBy(() -> locationServiceImplUnderTest.getLocationById(String.valueOf(0L)))
                .isInstanceOf(ResourceNotFoundException.class);
    }

    @Test
    void testGetAllLocations() {
        // Setup
        // Configure LocationRepository.findAll(...).
        final Location location = new Location();
        location.setId(0L);
        location.setName("name");
        location.setAddress("address");
        location.setZipCode("zipCode");
        location.setCity("city");
        location.setState("state");
        final List<Location> locations = List.of(location);
        when(mockLocationRepository.findAll()).thenReturn(locations);

        // Run the test
        final List<LocationDTO> result = locationServiceImplUnderTest.getAllLocations();

        // Verify the results
    }

    @Test
    void testGetAllLocations_LocationRepositoryReturnsNoItems() {
        // Setup
        when(mockLocationRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<LocationDTO> result = locationServiceImplUnderTest.getAllLocations();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }
}
