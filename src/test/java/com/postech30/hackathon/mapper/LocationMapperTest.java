package com.postech30.hackathon.mapper;

import com.postech30.hackathon.dto.LocationDTO;
import com.postech30.hackathon.entity.Location;
import org.junit.jupiter.api.Test;

class LocationMapperTest {

    @Test
    void testFromEntity() {
        // Setup
        final Location location = new Location();
        location.setId(0L);
        location.setName("name");
        location.setAddress("address");
        location.setZipCode("zipCode");
        location.setCity("city");
        location.setState("state");

        // Run the test
        final LocationDTO result = LocationMapper.fromEntity(location);

        // Verify the results
    }

    @Test
    void testToEntity() {
        // Setup
        final LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId("id");
        locationDTO.setName("name");
        locationDTO.setAddress("address");
        locationDTO.setZipCode("zipCode");
        locationDTO.setCity("city");
        locationDTO.setState("state");

        // Run the test
        final Location result = LocationMapper.toEntity(locationDTO);

        // Verify the results
    }
}
