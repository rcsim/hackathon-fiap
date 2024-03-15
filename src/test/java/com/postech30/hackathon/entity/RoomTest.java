package com.postech30.hackathon.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

@ExtendWith(MockitoExtension.class)
class RoomTest {

    @Mock
    private Building mockBuilding;
    @Mock
    private Location mockLocation;

    private Room roomUnderTest;

    @BeforeEach
    void setUp() {
        roomUnderTest = new Room(0L, mockBuilding, mockLocation, "type", 0, 0, "otherFurniture", "bathroom", 0.0);
    }

    @Test
    void testIdGetterAndSetter() {
        final Long id = 0L;
        roomUnderTest.setId(id);
        assertThat(roomUnderTest.getId()).isEqualTo(id);
    }

    @Test
    void testBuildingGetterAndSetter() {
        final Building building = new Building();
        roomUnderTest.setBuilding(building);
        assertThat(roomUnderTest.getBuilding()).isEqualTo(building);
    }

    @Test
    void testLocationGetterAndSetter() {
        final Location location = new Location();
        roomUnderTest.setLocation(location);
        assertThat(roomUnderTest.getLocation()).isEqualTo(location);
    }

    @Test
    void testTypeGetterAndSetter() {
        final String type = "type";
        roomUnderTest.setType(type);
        assertThat(roomUnderTest.getType()).isEqualTo(type);
    }

    @Test
    void testTotalPeopleGetterAndSetter() {
        final int totalPeople = 0;
        roomUnderTest.setTotalPeople(totalPeople);
        assertThat(roomUnderTest.getTotalPeople()).isEqualTo(totalPeople);
    }

    @Test
    void testTotalBedsGetterAndSetter() {
        final int totalBeds = 0;
        roomUnderTest.setTotalBeds(totalBeds);
        assertThat(roomUnderTest.getTotalBeds()).isEqualTo(totalBeds);
    }

    @Test
    void testOtherFurnitureGetterAndSetter() {
        final String otherFurniture = "otherFurniture";
        roomUnderTest.setOtherFurniture(otherFurniture);
        assertThat(roomUnderTest.getOtherFurniture()).isEqualTo(otherFurniture);
    }

    @Test
    void testBathroomGetterAndSetter() {
        final String bathroom = "bathroom";
        roomUnderTest.setBathroom(bathroom);
        assertThat(roomUnderTest.getBathroom()).isEqualTo(bathroom);
    }

    @Test
    void testDailyRateGetterAndSetter() {
        final double dailyRate = 0.0;
        roomUnderTest.setDailyRate(dailyRate);
        assertThat(roomUnderTest.getDailyRate()).isEqualTo(dailyRate, within(0.0001));
    }
}
