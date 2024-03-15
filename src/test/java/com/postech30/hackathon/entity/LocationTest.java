package com.postech30.hackathon.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LocationTest {

    private Location locationUnderTest;

    @BeforeEach
    void setUp() {
        locationUnderTest = new Location(0L, "name", "address", "zipCode", "city", "state");
    }

    @Test
    void testIdGetterAndSetter() {
        final Long id = 0L;
        locationUnderTest.setId(id);
        assertThat(locationUnderTest.getId()).isEqualTo(id);
    }

    @Test
    void testNameGetterAndSetter() {
        final String name = "name";
        locationUnderTest.setName(name);
        assertThat(locationUnderTest.getName()).isEqualTo(name);
    }

    @Test
    void testAddressGetterAndSetter() {
        final String address = "address";
        locationUnderTest.setAddress(address);
        assertThat(locationUnderTest.getAddress()).isEqualTo(address);
    }

    @Test
    void testZipCodeGetterAndSetter() {
        final String zipCode = "zipCode";
        locationUnderTest.setZipCode(zipCode);
        assertThat(locationUnderTest.getZipCode()).isEqualTo(zipCode);
    }

    @Test
    void testCityGetterAndSetter() {
        final String city = "city";
        locationUnderTest.setCity(city);
        assertThat(locationUnderTest.getCity()).isEqualTo(city);
    }

    @Test
    void testStateGetterAndSetter() {
        final String state = "state";
        locationUnderTest.setState(state);
        assertThat(locationUnderTest.getState()).isEqualTo(state);
    }
}
