package com.postech30.hackathon.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LocationDTOTest {

    @Test
    void testIdGetterAndSetter() {
        final LocationDTO locationDTOUnderTest = new LocationDTO("id", "name", "address", "zipCode", "city", "state");
        final String id = "id";
        locationDTOUnderTest.setId(id);
        assertThat(locationDTOUnderTest.getId()).isEqualTo(id);
    }

    @Test
    void testNameGetterAndSetter() {
        final LocationDTO locationDTOUnderTest = new LocationDTO("id", "name", "address", "zipCode", "city", "state");
        final String name = "name";
        locationDTOUnderTest.setName(name);
        assertThat(locationDTOUnderTest.getName()).isEqualTo(name);
    }

    @Test
    void testAddressGetterAndSetter() {
        final LocationDTO locationDTOUnderTest = new LocationDTO("id", "name", "address", "zipCode", "city", "state");
        final String address = "address";
        locationDTOUnderTest.setAddress(address);
        assertThat(locationDTOUnderTest.getAddress()).isEqualTo(address);
    }

    @Test
    void testZipCodeGetterAndSetter() {
        final LocationDTO locationDTOUnderTest = new LocationDTO("id", "name", "address", "zipCode", "city", "state");
        final String zipCode = "zipCode";
        locationDTOUnderTest.setZipCode(zipCode);
        assertThat(locationDTOUnderTest.getZipCode()).isEqualTo(zipCode);
    }

    @Test
    void testCityGetterAndSetter() {
        final LocationDTO locationDTOUnderTest = new LocationDTO("id", "name", "address", "zipCode", "city", "state");
        final String city = "city";
        locationDTOUnderTest.setCity(city);
        assertThat(locationDTOUnderTest.getCity()).isEqualTo(city);
    }

    @Test
    void testStateGetterAndSetter() {
        final LocationDTO locationDTOUnderTest = new LocationDTO("id", "name", "address", "zipCode", "city", "state");
        final String state = "state";
        locationDTOUnderTest.setState(state);
        assertThat(locationDTOUnderTest.getState()).isEqualTo(state);
    }
}
