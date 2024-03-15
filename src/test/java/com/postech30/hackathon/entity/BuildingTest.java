package com.postech30.hackathon.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class BuildingTest {

    @Mock
    private Location mockLocation;

    @Test
    void testIdGetterAndSetter() {
        final Building buildingUnderTest = new Building(0L, mockLocation, "name");
        final Long id = 0L;
        buildingUnderTest.setId(id);
        assertThat(buildingUnderTest.getId()).isEqualTo(id);
    }

    @Test
    void testLocationGetterAndSetter() {
        final Building buildingUnderTest = new Building(0L, mockLocation, "name");
        final Location location = new Location();
        buildingUnderTest.setLocation(location);
        assertThat(buildingUnderTest.getLocation()).isEqualTo(location);
    }

    @Test
    void testNameGetterAndSetter() {
        final Building buildingUnderTest = new Building(0L, mockLocation, "name");
        final String name = "name";
        buildingUnderTest.setName(name);
        assertThat(buildingUnderTest.getName()).isEqualTo(name);
    }
}
