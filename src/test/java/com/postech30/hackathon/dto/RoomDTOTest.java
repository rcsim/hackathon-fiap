package com.postech30.hackathon.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class RoomDTOTest {

    @Test
    void testIdGetterAndSetter() {
        final RoomDTO roomDTOUnderTest = new RoomDTO("id", "buildingId", "locationId", "type", 0, 0, "otherFurniture",
                "bathroom", 0.0);
        final String id = "id";
        roomDTOUnderTest.setId(id);
        assertThat(roomDTOUnderTest.getId()).isEqualTo(id);
    }

    @Test
    void testBuildingIdGetterAndSetter() {
        final RoomDTO roomDTOUnderTest = new RoomDTO("id", "buildingId", "locationId", "type", 0, 0, "otherFurniture",
                "bathroom", 0.0);
        final String buildingId = "buildingId";
        roomDTOUnderTest.setBuildingId(buildingId);
        assertThat(roomDTOUnderTest.getBuildingId()).isEqualTo(buildingId);
    }

    @Test
    void testLocationIdGetterAndSetter() {
        final RoomDTO roomDTOUnderTest = new RoomDTO("id", "buildingId", "locationId", "type", 0, 0, "otherFurniture",
                "bathroom", 0.0);
        final String locationId = "locationId";
        roomDTOUnderTest.setLocationId(locationId);
        assertThat(roomDTOUnderTest.getLocationId()).isEqualTo(locationId);
    }

    @Test
    void testTypeGetterAndSetter() {
        final RoomDTO roomDTOUnderTest = new RoomDTO("id", "buildingId", "locationId", "type", 0, 0, "otherFurniture",
                "bathroom", 0.0);
        final String type = "type";
        roomDTOUnderTest.setType(type);
        assertThat(roomDTOUnderTest.getType()).isEqualTo(type);
    }

    @Test
    void testTotalPeopleGetterAndSetter() {
        final RoomDTO roomDTOUnderTest = new RoomDTO("id", "buildingId", "locationId", "type", 0, 0, "otherFurniture",
                "bathroom", 0.0);
        final int totalPeople = 0;
        roomDTOUnderTest.setTotalPeople(totalPeople);
        assertThat(roomDTOUnderTest.getTotalPeople()).isEqualTo(totalPeople);
    }

    @Test
    void testTotalBedsGetterAndSetter() {
        final RoomDTO roomDTOUnderTest = new RoomDTO("id", "buildingId", "locationId", "type", 0, 0, "otherFurniture",
                "bathroom", 0.0);
        final int totalBeds = 0;
        roomDTOUnderTest.setTotalBeds(totalBeds);
        assertThat(roomDTOUnderTest.getTotalBeds()).isEqualTo(totalBeds);
    }

    @Test
    void testOtherFurnitureGetterAndSetter() {
        final RoomDTO roomDTOUnderTest = new RoomDTO("id", "buildingId", "locationId", "type", 0, 0, "otherFurniture",
                "bathroom", 0.0);
        final String otherFurniture = "otherFurniture";
        roomDTOUnderTest.setOtherFurniture(otherFurniture);
        assertThat(roomDTOUnderTest.getOtherFurniture()).isEqualTo(otherFurniture);
    }

    @Test
    void testBathroomGetterAndSetter() {
        final RoomDTO roomDTOUnderTest = new RoomDTO("id", "buildingId", "locationId", "type", 0, 0, "otherFurniture",
                "bathroom", 0.0);
        final String bathroom = "bathroom";
        roomDTOUnderTest.setBathroom(bathroom);
        assertThat(roomDTOUnderTest.getBathroom()).isEqualTo(bathroom);
    }

    @Test
    void testDailyRateGetterAndSetter() {
        final RoomDTO roomDTOUnderTest = new RoomDTO("id", "buildingId", "locationId", "type", 0, 0, "otherFurniture",
                "bathroom", 0.0);
        final double dailyRate = 0.0;
        roomDTOUnderTest.setDailyRate(dailyRate);
        assertThat(roomDTOUnderTest.getDailyRate()).isEqualTo(dailyRate, within(0.0001));
    }
}
