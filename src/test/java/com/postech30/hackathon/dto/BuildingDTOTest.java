package com.postech30.hackathon.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BuildingDTOTest {

    @Test
    void testIdGetterAndSetter() {
        final BuildingDTO buildingDTOUnderTest = new BuildingDTO("id", "locationId", "name");
        final String id = "id";
        buildingDTOUnderTest.setId(id);
        assertThat(buildingDTOUnderTest.getId()).isEqualTo(id);
    }

    @Test
    void testLocationIdGetterAndSetter() {
        final BuildingDTO buildingDTOUnderTest = new BuildingDTO("id", "locationId", "name");
        final String locationId = "locationId";
        buildingDTOUnderTest.setLocationId(locationId);
        assertThat(buildingDTOUnderTest.getLocationId()).isEqualTo(locationId);
    }

    @Test
    void testNameGetterAndSetter() {
        final BuildingDTO buildingDTOUnderTest = new BuildingDTO("id", "locationId", "name");
        final String name = "name";
        buildingDTOUnderTest.setName(name);
        assertThat(buildingDTOUnderTest.getName()).isEqualTo(name);
    }
}
