package com.postech30.hackathon.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ClientTest {
    /**
     * Method under test: {@link Client#equals(Object)}
     */
    @Test
    void testEquals() {
        Client client = new Client();
        client.setAddress("42 Main St");
        client.setBirthDate("2020-03-01");
        client.setCountry("GB");
        client.setCpf("Cpf");
        client.setEmail("jane.doe@example.org");
        client.setFullName("Dr Jane Doe");
        client.setId(1L);
        client.setPassport("Passport");
        client.setPhone("6625550144");
        assertNotEquals(client, null);
    }

    /**
     * Method under test: {@link Client#equals(Object)}
     */
    @Test
    void testEquals2() {
        Client client = new Client();
        client.setAddress("42 Main St");
        client.setBirthDate("2020-03-01");
        client.setCountry("GB");
        client.setCpf("Cpf");
        client.setEmail("jane.doe@example.org");
        client.setFullName("Dr Jane Doe");
        client.setId(1L);
        client.setPassport("Passport");
        client.setPhone("6625550144");
        assertNotEquals(client, "Different type to Client");
    }

    /**
     * Method under test: {@link Client#equals(Object)}
     */
    @Test
    void testEquals3() {
        Client client = new Client();
        client.setAddress("17 High St");
        client.setBirthDate("2020-03-01");
        client.setCountry("GB");
        client.setCpf("Cpf");
        client.setEmail("jane.doe@example.org");
        client.setFullName("Dr Jane Doe");
        client.setId(1L);
        client.setPassport("Passport");
        client.setPhone("6625550144");

        Client client2 = new Client();
        client2.setAddress("42 Main St");
        client2.setBirthDate("2020-03-01");
        client2.setCountry("GB");
        client2.setCpf("Cpf");
        client2.setEmail("jane.doe@example.org");
        client2.setFullName("Dr Jane Doe");
        client2.setId(1L);
        client2.setPassport("Passport");
        client2.setPhone("6625550144");
        assertNotEquals(client, client2);
    }

    /**
     * Method under test: {@link Client#equals(Object)}
     */
    @Test
    void testEquals4() {
        Client client = new Client();
        client.setAddress(null);
        client.setBirthDate("2020-03-01");
        client.setCountry("GB");
        client.setCpf("Cpf");
        client.setEmail("jane.doe@example.org");
        client.setFullName("Dr Jane Doe");
        client.setId(1L);
        client.setPassport("Passport");
        client.setPhone("6625550144");

        Client client2 = new Client();
        client2.setAddress("42 Main St");
        client2.setBirthDate("2020-03-01");
        client2.setCountry("GB");
        client2.setCpf("Cpf");
        client2.setEmail("jane.doe@example.org");
        client2.setFullName("Dr Jane Doe");
        client2.setId(1L);
        client2.setPassport("Passport");
        client2.setPhone("6625550144");
        assertNotEquals(client, client2);
    }

    /**
     * Method under test: {@link Client#equals(Object)}
     */
    @Test
    void testEquals5() {
        Client client = new Client();
        client.setAddress("42 Main St");
        client.setBirthDate("2020/03/01");
        client.setCountry("GB");
        client.setCpf("Cpf");
        client.setEmail("jane.doe@example.org");
        client.setFullName("Dr Jane Doe");
        client.setId(1L);
        client.setPassport("Passport");
        client.setPhone("6625550144");

        Client client2 = new Client();
        client2.setAddress("42 Main St");
        client2.setBirthDate("2020-03-01");
        client2.setCountry("GB");
        client2.setCpf("Cpf");
        client2.setEmail("jane.doe@example.org");
        client2.setFullName("Dr Jane Doe");
        client2.setId(1L);
        client2.setPassport("Passport");
        client2.setPhone("6625550144");
        assertNotEquals(client, client2);
    }

    /**
     * Method under test: {@link Client#equals(Object)}
     */
    @Test
    void testEquals6() {
        Client client = new Client();
        client.setAddress("42 Main St");
        client.setBirthDate(null);
        client.setCountry("GB");
        client.setCpf("Cpf");
        client.setEmail("jane.doe@example.org");
        client.setFullName("Dr Jane Doe");
        client.setId(1L);
        client.setPassport("Passport");
        client.setPhone("6625550144");

        Client client2 = new Client();
        client2.setAddress("42 Main St");
        client2.setBirthDate("2020-03-01");
        client2.setCountry("GB");
        client2.setCpf("Cpf");
        client2.setEmail("jane.doe@example.org");
        client2.setFullName("Dr Jane Doe");
        client2.setId(1L);
        client2.setPassport("Passport");
        client2.setPhone("6625550144");
        assertNotEquals(client, client2);
    }

    /**
     * Method under test: {@link Client#equals(Object)}
     */
    @Test
    void testEquals7() {
        Client client = new Client();
        client.setAddress("42 Main St");
        client.setBirthDate("2020-03-01");
        client.setCountry("GBR");
        client.setCpf("Cpf");
        client.setEmail("jane.doe@example.org");
        client.setFullName("Dr Jane Doe");
        client.setId(1L);
        client.setPassport("Passport");
        client.setPhone("6625550144");

        Client client2 = new Client();
        client2.setAddress("42 Main St");
        client2.setBirthDate("2020-03-01");
        client2.setCountry("GB");
        client2.setCpf("Cpf");
        client2.setEmail("jane.doe@example.org");
        client2.setFullName("Dr Jane Doe");
        client2.setId(1L);
        client2.setPassport("Passport");
        client2.setPhone("6625550144");
        assertNotEquals(client, client2);
    }

    /**
     * Method under test: {@link Client#equals(Object)}
     */
    @Test
    void testEquals8() {
        Client client = new Client();
        client.setAddress("42 Main St");
        client.setBirthDate("2020-03-01");
        client.setCountry(null);
        client.setCpf("Cpf");
        client.setEmail("jane.doe@example.org");
        client.setFullName("Dr Jane Doe");
        client.setId(1L);
        client.setPassport("Passport");
        client.setPhone("6625550144");

        Client client2 = new Client();
        client2.setAddress("42 Main St");
        client2.setBirthDate("2020-03-01");
        client2.setCountry("GB");
        client2.setCpf("Cpf");
        client2.setEmail("jane.doe@example.org");
        client2.setFullName("Dr Jane Doe");
        client2.setId(1L);
        client2.setPassport("Passport");
        client2.setPhone("6625550144");
        assertNotEquals(client, client2);
    }

    /**
     * Method under test: {@link Client#equals(Object)}
     */
    @Test
    void testEquals9() {
        Client client = new Client();
        client.setAddress("42 Main St");
        client.setBirthDate("2020-03-01");
        client.setCountry("GB");
        client.setCpf("GB");
        client.setEmail("jane.doe@example.org");
        client.setFullName("Dr Jane Doe");
        client.setId(1L);
        client.setPassport("Passport");
        client.setPhone("6625550144");

        Client client2 = new Client();
        client2.setAddress("42 Main St");
        client2.setBirthDate("2020-03-01");
        client2.setCountry("GB");
        client2.setCpf("Cpf");
        client2.setEmail("jane.doe@example.org");
        client2.setFullName("Dr Jane Doe");
        client2.setId(1L);
        client2.setPassport("Passport");
        client2.setPhone("6625550144");
        assertNotEquals(client, client2);
    }

    /**
     * Method under test: {@link Client#equals(Object)}
     */
    @Test
    void testEquals10() {
        Client client = new Client();
        client.setAddress("42 Main St");
        client.setBirthDate("2020-03-01");
        client.setCountry("GB");
        client.setCpf(null);
        client.setEmail("jane.doe@example.org");
        client.setFullName("Dr Jane Doe");
        client.setId(1L);
        client.setPassport("Passport");
        client.setPhone("6625550144");

        Client client2 = new Client();
        client2.setAddress("42 Main St");
        client2.setBirthDate("2020-03-01");
        client2.setCountry("GB");
        client2.setCpf("Cpf");
        client2.setEmail("jane.doe@example.org");
        client2.setFullName("Dr Jane Doe");
        client2.setId(1L);
        client2.setPassport("Passport");
        client2.setPhone("6625550144");
        assertNotEquals(client, client2);
    }

    /**
     * Method under test: {@link Client#equals(Object)}
     */
    @Test
    void testEquals11() {
        Client client = new Client();
        client.setAddress("42 Main St");
        client.setBirthDate("2020-03-01");
        client.setCountry("GB");
        client.setCpf("Cpf");
        client.setEmail("john.smith@example.org");
        client.setFullName("Dr Jane Doe");
        client.setId(1L);
        client.setPassport("Passport");
        client.setPhone("6625550144");

        Client client2 = new Client();
        client2.setAddress("42 Main St");
        client2.setBirthDate("2020-03-01");
        client2.setCountry("GB");
        client2.setCpf("Cpf");
        client2.setEmail("jane.doe@example.org");
        client2.setFullName("Dr Jane Doe");
        client2.setId(1L);
        client2.setPassport("Passport");
        client2.setPhone("6625550144");
        assertNotEquals(client, client2);
    }

    /**
     * Method under test: {@link Client#equals(Object)}
     */
    @Test
    void testEquals12() {
        Client client = new Client();
        client.setAddress("42 Main St");
        client.setBirthDate("2020-03-01");
        client.setCountry("GB");
        client.setCpf("Cpf");
        client.setEmail(null);
        client.setFullName("Dr Jane Doe");
        client.setId(1L);
        client.setPassport("Passport");
        client.setPhone("6625550144");

        Client client2 = new Client();
        client2.setAddress("42 Main St");
        client2.setBirthDate("2020-03-01");
        client2.setCountry("GB");
        client2.setCpf("Cpf");
        client2.setEmail("jane.doe@example.org");
        client2.setFullName("Dr Jane Doe");
        client2.setId(1L);
        client2.setPassport("Passport");
        client2.setPhone("6625550144");
        assertNotEquals(client, client2);
    }

    /**
     * Method under test: {@link Client#equals(Object)}
     */
    @Test
    void testEquals13() {
        Client client = new Client();
        client.setAddress("42 Main St");
        client.setBirthDate("2020-03-01");
        client.setCountry("GB");
        client.setCpf("Cpf");
        client.setEmail("jane.doe@example.org");
        client.setFullName("Mr John Smith");
        client.setId(1L);
        client.setPassport("Passport");
        client.setPhone("6625550144");

        Client client2 = new Client();
        client2.setAddress("42 Main St");
        client2.setBirthDate("2020-03-01");
        client2.setCountry("GB");
        client2.setCpf("Cpf");
        client2.setEmail("jane.doe@example.org");
        client2.setFullName("Dr Jane Doe");
        client2.setId(1L);
        client2.setPassport("Passport");
        client2.setPhone("6625550144");
        assertNotEquals(client, client2);
    }

    /**
     * Method under test: {@link Client#equals(Object)}
     */
    @Test
    void testEquals14() {
        Client client = new Client();
        client.setAddress("42 Main St");
        client.setBirthDate("2020-03-01");
        client.setCountry("GB");
        client.setCpf("Cpf");
        client.setEmail("jane.doe@example.org");
        client.setFullName(null);
        client.setId(1L);
        client.setPassport("Passport");
        client.setPhone("6625550144");

        Client client2 = new Client();
        client2.setAddress("42 Main St");
        client2.setBirthDate("2020-03-01");
        client2.setCountry("GB");
        client2.setCpf("Cpf");
        client2.setEmail("jane.doe@example.org");
        client2.setFullName("Dr Jane Doe");
        client2.setId(1L);
        client2.setPassport("Passport");
        client2.setPhone("6625550144");
        assertNotEquals(client, client2);
    }

    /**
     * Method under test: {@link Client#equals(Object)}
     */
    @Test
    void testEquals15() {
        Client client = new Client();
        client.setAddress("42 Main St");
        client.setBirthDate("2020-03-01");
        client.setCountry("GB");
        client.setCpf("Cpf");
        client.setEmail("jane.doe@example.org");
        client.setFullName("Dr Jane Doe");
        client.setId(2L);
        client.setPassport("Passport");
        client.setPhone("6625550144");

        Client client2 = new Client();
        client2.setAddress("42 Main St");
        client2.setBirthDate("2020-03-01");
        client2.setCountry("GB");
        client2.setCpf("Cpf");
        client2.setEmail("jane.doe@example.org");
        client2.setFullName("Dr Jane Doe");
        client2.setId(1L);
        client2.setPassport("Passport");
        client2.setPhone("6625550144");
        assertNotEquals(client, client2);
    }

    /**
     * Method under test: {@link Client#equals(Object)}
     */
    @Test
    void testEquals16() {
        Client client = new Client();
        client.setAddress("42 Main St");
        client.setBirthDate("2020-03-01");
        client.setCountry("GB");
        client.setCpf("Cpf");
        client.setEmail("jane.doe@example.org");
        client.setFullName("Dr Jane Doe");
        client.setId(null);
        client.setPassport("Passport");
        client.setPhone("6625550144");

        Client client2 = new Client();
        client2.setAddress("42 Main St");
        client2.setBirthDate("2020-03-01");
        client2.setCountry("GB");
        client2.setCpf("Cpf");
        client2.setEmail("jane.doe@example.org");
        client2.setFullName("Dr Jane Doe");
        client2.setId(1L);
        client2.setPassport("Passport");
        client2.setPhone("6625550144");
        assertNotEquals(client, client2);
    }

    /**
     * Method under test: {@link Client#equals(Object)}
     */
    @Test
    void testEquals17() {
        Client client = new Client();
        client.setAddress("42 Main St");
        client.setBirthDate("2020-03-01");
        client.setCountry("GB");
        client.setCpf("Cpf");
        client.setEmail("jane.doe@example.org");
        client.setFullName("Dr Jane Doe");
        client.setId(1L);
        client.setPassport("GB");
        client.setPhone("6625550144");

        Client client2 = new Client();
        client2.setAddress("42 Main St");
        client2.setBirthDate("2020-03-01");
        client2.setCountry("GB");
        client2.setCpf("Cpf");
        client2.setEmail("jane.doe@example.org");
        client2.setFullName("Dr Jane Doe");
        client2.setId(1L);
        client2.setPassport("Passport");
        client2.setPhone("6625550144");
        assertNotEquals(client, client2);
    }

    /**
     * Method under test: {@link Client#equals(Object)}
     */
    @Test
    void testEquals18() {
        Client client = new Client();
        client.setAddress("42 Main St");
        client.setBirthDate("2020-03-01");
        client.setCountry("GB");
        client.setCpf("Cpf");
        client.setEmail("jane.doe@example.org");
        client.setFullName("Dr Jane Doe");
        client.setId(1L);
        client.setPassport(null);
        client.setPhone("6625550144");

        Client client2 = new Client();
        client2.setAddress("42 Main St");
        client2.setBirthDate("2020-03-01");
        client2.setCountry("GB");
        client2.setCpf("Cpf");
        client2.setEmail("jane.doe@example.org");
        client2.setFullName("Dr Jane Doe");
        client2.setId(1L);
        client2.setPassport("Passport");
        client2.setPhone("6625550144");
        assertNotEquals(client, client2);
    }

    /**
     * Method under test: {@link Client#equals(Object)}
     */
    @Test
    void testEquals19() {
        Client client = new Client();
        client.setAddress("42 Main St");
        client.setBirthDate("2020-03-01");
        client.setCountry("GB");
        client.setCpf("Cpf");
        client.setEmail("jane.doe@example.org");
        client.setFullName("Dr Jane Doe");
        client.setId(1L);
        client.setPassport("Passport");
        client.setPhone("8605550118");

        Client client2 = new Client();
        client2.setAddress("42 Main St");
        client2.setBirthDate("2020-03-01");
        client2.setCountry("GB");
        client2.setCpf("Cpf");
        client2.setEmail("jane.doe@example.org");
        client2.setFullName("Dr Jane Doe");
        client2.setId(1L);
        client2.setPassport("Passport");
        client2.setPhone("6625550144");
        assertNotEquals(client, client2);
    }

    /**
     * Method under test: {@link Client#equals(Object)}
     */
    @Test
    void testEquals20() {
        Client client = new Client();
        client.setAddress("42 Main St");
        client.setBirthDate("2020-03-01");
        client.setCountry("GB");
        client.setCpf("Cpf");
        client.setEmail("jane.doe@example.org");
        client.setFullName("Dr Jane Doe");
        client.setId(1L);
        client.setPassport("Passport");
        client.setPhone(null);

        Client client2 = new Client();
        client2.setAddress("42 Main St");
        client2.setBirthDate("2020-03-01");
        client2.setCountry("GB");
        client2.setCpf("Cpf");
        client2.setEmail("jane.doe@example.org");
        client2.setFullName("Dr Jane Doe");
        client2.setId(1L);
        client2.setPassport("Passport");
        client2.setPhone("6625550144");
        assertNotEquals(client, client2);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Client#equals(Object)}
     *   <li>{@link Client#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode() {
        Client client = new Client();
        client.setAddress("42 Main St");
        client.setBirthDate("2020-03-01");
        client.setCountry("GB");
        client.setCpf("Cpf");
        client.setEmail("jane.doe@example.org");
        client.setFullName("Dr Jane Doe");
        client.setId(1L);
        client.setPassport("Passport");
        client.setPhone("6625550144");
        assertEquals(client, client);
        int expectedHashCodeResult = client.hashCode();
        assertEquals(expectedHashCodeResult, client.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Client#equals(Object)}
     *   <li>{@link Client#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode2() {
        Client client = new Client();
        client.setAddress("42 Main St");
        client.setBirthDate("2020-03-01");
        client.setCountry("GB");
        client.setCpf("Cpf");
        client.setEmail("jane.doe@example.org");
        client.setFullName("Dr Jane Doe");
        client.setId(1L);
        client.setPassport("Passport");
        client.setPhone("6625550144");

        Client client2 = new Client();
        client2.setAddress("42 Main St");
        client2.setBirthDate("2020-03-01");
        client2.setCountry("GB");
        client2.setCpf("Cpf");
        client2.setEmail("jane.doe@example.org");
        client2.setFullName("Dr Jane Doe");
        client2.setId(1L);
        client2.setPassport("Passport");
        client2.setPhone("6625550144");
        assertEquals(client, client2);
        int expectedHashCodeResult = client.hashCode();
        assertEquals(expectedHashCodeResult, client2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Client#Client()}
     *   <li>{@link Client#setAddress(String)}
     *   <li>{@link Client#setBirthDate(String)}
     *   <li>{@link Client#setCountry(String)}
     *   <li>{@link Client#setCpf(String)}
     *   <li>{@link Client#setEmail(String)}
     *   <li>{@link Client#setFullName(String)}
     *   <li>{@link Client#setId(Long)}
     *   <li>{@link Client#setPassport(String)}
     *   <li>{@link Client#setPhone(String)}
     *   <li>{@link Client#toString()}
     *   <li>{@link Client#getAddress()}
     *   <li>{@link Client#getBirthDate()}
     *   <li>{@link Client#getCountry()}
     *   <li>{@link Client#getCpf()}
     *   <li>{@link Client#getEmail()}
     *   <li>{@link Client#getFullName()}
     *   <li>{@link Client#getId()}
     *   <li>{@link Client#getPassport()}
     *   <li>{@link Client#getPhone()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        Client actualClient = new Client();
        actualClient.setAddress("42 Main St");
        actualClient.setBirthDate("2020-03-01");
        actualClient.setCountry("GB");
        actualClient.setCpf("Cpf");
        actualClient.setEmail("jane.doe@example.org");
        actualClient.setFullName("Dr Jane Doe");
        actualClient.setId(1L);
        actualClient.setPassport("Passport");
        actualClient.setPhone("6625550144");
        String actualToStringResult = actualClient.toString();
        String actualAddress = actualClient.getAddress();
        String actualBirthDate = actualClient.getBirthDate();
        String actualCountry = actualClient.getCountry();
        String actualCpf = actualClient.getCpf();
        String actualEmail = actualClient.getEmail();
        String actualFullName = actualClient.getFullName();
        Long actualId = actualClient.getId();
        String actualPassport = actualClient.getPassport();
        assertEquals("2020-03-01", actualBirthDate);
        assertEquals("42 Main St", actualAddress);
        assertEquals("6625550144", actualClient.getPhone());
        assertEquals("Client(id=1, country=GB, cpf=Cpf, passport=Passport, fullName=Dr Jane Doe, birthDate=2020-03-01,"
                + " address=42 Main St, phone=6625550144, email=jane.doe@example.org)", actualToStringResult);
        assertEquals("Cpf", actualCpf);
        assertEquals("Dr Jane Doe", actualFullName);
        assertEquals("GB", actualCountry);
        assertEquals("Passport", actualPassport);
        assertEquals("jane.doe@example.org", actualEmail);
        assertEquals(1L, actualId.longValue());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link Client#Client(Long, String, String, String, String, String, String, String, String)}
     *   <li>{@link Client#setAddress(String)}
     *   <li>{@link Client#setBirthDate(String)}
     *   <li>{@link Client#setCountry(String)}
     *   <li>{@link Client#setCpf(String)}
     *   <li>{@link Client#setEmail(String)}
     *   <li>{@link Client#setFullName(String)}
     *   <li>{@link Client#setId(Long)}
     *   <li>{@link Client#setPassport(String)}
     *   <li>{@link Client#setPhone(String)}
     *   <li>{@link Client#toString()}
     *   <li>{@link Client#getAddress()}
     *   <li>{@link Client#getBirthDate()}
     *   <li>{@link Client#getCountry()}
     *   <li>{@link Client#getCpf()}
     *   <li>{@link Client#getEmail()}
     *   <li>{@link Client#getFullName()}
     *   <li>{@link Client#getId()}
     *   <li>{@link Client#getPassport()}
     *   <li>{@link Client#getPhone()}
     * </ul>
     */
    @Test
    void testGettersAndSetters2() {
        Client actualClient = new Client(1L, "GB", "Cpf", "Passport", "Dr Jane Doe", "2020-03-01", "42 Main St",
                "6625550144", "jane.doe@example.org");
        actualClient.setAddress("42 Main St");
        actualClient.setBirthDate("2020-03-01");
        actualClient.setCountry("GB");
        actualClient.setCpf("Cpf");
        actualClient.setEmail("jane.doe@example.org");
        actualClient.setFullName("Dr Jane Doe");
        actualClient.setId(1L);
        actualClient.setPassport("Passport");
        actualClient.setPhone("6625550144");
        String actualToStringResult = actualClient.toString();
        String actualAddress = actualClient.getAddress();
        String actualBirthDate = actualClient.getBirthDate();
        String actualCountry = actualClient.getCountry();
        String actualCpf = actualClient.getCpf();
        String actualEmail = actualClient.getEmail();
        String actualFullName = actualClient.getFullName();
        Long actualId = actualClient.getId();
        String actualPassport = actualClient.getPassport();
        assertEquals("2020-03-01", actualBirthDate);
        assertEquals("42 Main St", actualAddress);
        assertEquals("6625550144", actualClient.getPhone());
        assertEquals("Client(id=1, country=GB, cpf=Cpf, passport=Passport, fullName=Dr Jane Doe, birthDate=2020-03-01,"
                + " address=42 Main St, phone=6625550144, email=jane.doe@example.org)", actualToStringResult);
        assertEquals("Cpf", actualCpf);
        assertEquals("Dr Jane Doe", actualFullName);
        assertEquals("GB", actualCountry);
        assertEquals("Passport", actualPassport);
        assertEquals("jane.doe@example.org", actualEmail);
        assertEquals(1L, actualId.longValue());
    }
}
