package com.postech30.hackathon.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {ClientDTO.class})
@ExtendWith(SpringExtension.class)
class ClientDTOTest {
    @Autowired
    private ClientDTO clientDTO;

    /**
     * Method under test: {@link ClientDTO#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(clientDTO.canEqual("Other"));
        assertTrue(clientDTO.canEqual(clientDTO));
    }

    /**
     * Method under test: {@link ClientDTO#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new ClientDTO(), null);
        assertNotEquals(new ClientDTO(), "Different type to ClientDTO");
    }

    /**
     * Method under test: {@link ClientDTO#equals(Object)}
     */
    @Test
    void testEquals2() {
        ClientDTO clientDTO = new ClientDTO(1L, "GB", "Cpf", "Passport", "Dr Jane Doe", LocalDate.of(1970, 1, 1),
                "42 Main St", "6625550144", "jane.doe@example.org");
        assertNotEquals(clientDTO, new ClientDTO());
    }

    /**
     * Method under test: {@link ClientDTO#equals(Object)}
     */
    @Test
    void testEquals3() {
        ClientDTO clientDTO = new ClientDTO();
        assertNotEquals(clientDTO, new ClientDTO(1L, "GB", "Cpf", "Passport", "Dr Jane Doe", LocalDate.of(1970, 1, 1),
                "42 Main St", "6625550144", "jane.doe@example.org"));
    }

    /**
     * Method under test: {@link ClientDTO#equals(Object)}
     */
    @Test
    void testEquals4() {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setCountry("GB");
        assertNotEquals(clientDTO, new ClientDTO());
    }

    /**
     * Method under test: {@link ClientDTO#equals(Object)}
     */
    @Test
    void testEquals5() {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setCpf("Cpf");
        assertNotEquals(clientDTO, new ClientDTO());
    }

    /**
     * Method under test: {@link ClientDTO#equals(Object)}
     */
    @Test
    void testEquals6() {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setPassport("Passport");
        assertNotEquals(clientDTO, new ClientDTO());
    }

    /**
     * Method under test: {@link ClientDTO#equals(Object)}
     */
    @Test
    void testEquals7() {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setFullName("Dr Jane Doe");
        assertNotEquals(clientDTO, new ClientDTO());
    }

    /**
     * Method under test: {@link ClientDTO#equals(Object)}
     */
    @Test
    void testEquals8() {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setBirthDate(LocalDate.of(1970, 1, 1));
        assertNotEquals(clientDTO, new ClientDTO());
    }

    /**
     * Method under test: {@link ClientDTO#equals(Object)}
     */
    @Test
    void testEquals9() {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setAddress("42 Main St");
        assertNotEquals(clientDTO, new ClientDTO());
    }

    /**
     * Method under test: {@link ClientDTO#equals(Object)}
     */
    @Test
    void testEquals10() {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setPhone("6625550144");
        assertNotEquals(clientDTO, new ClientDTO());
    }

    /**
     * Method under test: {@link ClientDTO#equals(Object)}
     */
    @Test
    void testEquals11() {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setEmail("jane.doe@example.org");
        assertNotEquals(clientDTO, new ClientDTO());
    }

    /**
     * Method under test: {@link ClientDTO#equals(Object)}
     */
    @Test
    void testEquals12() {
        ClientDTO clientDTO = new ClientDTO();

        ClientDTO clientDTO2 = new ClientDTO();
        clientDTO2.setCountry("GB");
        assertNotEquals(clientDTO, clientDTO2);
    }

    /**
     * Method under test: {@link ClientDTO#equals(Object)}
     */
    @Test
    void testEquals13() {
        ClientDTO clientDTO = new ClientDTO();

        ClientDTO clientDTO2 = new ClientDTO();
        clientDTO2.setCpf("Cpf");
        assertNotEquals(clientDTO, clientDTO2);
    }

    /**
     * Method under test: {@link ClientDTO#equals(Object)}
     */
    @Test
    void testEquals14() {
        ClientDTO clientDTO = new ClientDTO();

        ClientDTO clientDTO2 = new ClientDTO();
        clientDTO2.setPassport("Passport");
        assertNotEquals(clientDTO, clientDTO2);
    }

    /**
     * Method under test: {@link ClientDTO#equals(Object)}
     */
    @Test
    void testEquals15() {
        ClientDTO clientDTO = new ClientDTO();

        ClientDTO clientDTO2 = new ClientDTO();
        clientDTO2.setFullName("Dr Jane Doe");
        assertNotEquals(clientDTO, clientDTO2);
    }

    /**
     * Method under test: {@link ClientDTO#equals(Object)}
     */
    @Test
    void testEquals16() {
        ClientDTO clientDTO = new ClientDTO();

        ClientDTO clientDTO2 = new ClientDTO();
        clientDTO2.setBirthDate(LocalDate.of(1970, 1, 1));
        assertNotEquals(clientDTO, clientDTO2);
    }

    /**
     * Method under test: {@link ClientDTO#equals(Object)}
     */
    @Test
    void testEquals17() {
        ClientDTO clientDTO = new ClientDTO();

        ClientDTO clientDTO2 = new ClientDTO();
        clientDTO2.setAddress("42 Main St");
        assertNotEquals(clientDTO, clientDTO2);
    }

    /**
     * Method under test: {@link ClientDTO#equals(Object)}
     */
    @Test
    void testEquals18() {
        ClientDTO clientDTO = new ClientDTO();

        ClientDTO clientDTO2 = new ClientDTO();
        clientDTO2.setPhone("6625550144");
        assertNotEquals(clientDTO, clientDTO2);
    }

    /**
     * Method under test: {@link ClientDTO#equals(Object)}
     */
    @Test
    void testEquals19() {
        ClientDTO clientDTO = new ClientDTO();

        ClientDTO clientDTO2 = new ClientDTO();
        clientDTO2.setEmail("jane.doe@example.org");
        assertNotEquals(clientDTO, clientDTO2);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ClientDTO#equals(Object)}
     *   <li>{@link ClientDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode() {
        ClientDTO clientDTO = new ClientDTO();
        assertEquals(clientDTO, clientDTO);
        int expectedHashCodeResult = clientDTO.hashCode();
        assertEquals(expectedHashCodeResult, clientDTO.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ClientDTO#equals(Object)}
     *   <li>{@link ClientDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode2() {
        ClientDTO clientDTO = new ClientDTO();
        ClientDTO clientDTO2 = new ClientDTO();
        assertEquals(clientDTO, clientDTO2);
        int expectedHashCodeResult = clientDTO.hashCode();
        assertEquals(expectedHashCodeResult, clientDTO2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ClientDTO#equals(Object)}
     *   <li>{@link ClientDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode3() {
        ClientDTO clientDTO = new ClientDTO(1L, "GB", "Cpf", "Passport", "Dr Jane Doe", LocalDate.of(1970, 1, 1),
                "42 Main St", "6625550144", "jane.doe@example.org");
        ClientDTO clientDTO2 = new ClientDTO(1L, "GB", "Cpf", "Passport", "Dr Jane Doe", LocalDate.of(1970, 1, 1),
                "42 Main St", "6625550144", "jane.doe@example.org");

        assertEquals(clientDTO, clientDTO2);
        int expectedHashCodeResult = clientDTO.hashCode();
        assertEquals(expectedHashCodeResult, clientDTO2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ClientDTO#ClientDTO()}
     *   <li>{@link ClientDTO#setAddress(String)}
     *   <li>{@link ClientDTO#setBirthDate(LocalDate)}
     *   <li>{@link ClientDTO#setCountry(String)}
     *   <li>{@link ClientDTO#setCpf(String)}
     *   <li>{@link ClientDTO#setEmail(String)}
     *   <li>{@link ClientDTO#setFullName(String)}
     *   <li>{@link ClientDTO#setId(Long)}
     *   <li>{@link ClientDTO#setPassport(String)}
     *   <li>{@link ClientDTO#setPhone(String)}
     *   <li>{@link ClientDTO#toString()}
     *   <li>{@link ClientDTO#getAddress()}
     *   <li>{@link ClientDTO#getBirthDate()}
     *   <li>{@link ClientDTO#getCountry()}
     *   <li>{@link ClientDTO#getCpf()}
     *   <li>{@link ClientDTO#getEmail()}
     *   <li>{@link ClientDTO#getFullName()}
     *   <li>{@link ClientDTO#getId()}
     *   <li>{@link ClientDTO#getPassport()}
     *   <li>{@link ClientDTO#getPhone()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        ClientDTO actualClientDTO = new ClientDTO();
        actualClientDTO.setAddress("42 Main St");
        LocalDate birthDate = LocalDate.of(1970, 1, 1);
        actualClientDTO.setBirthDate(birthDate);
        actualClientDTO.setCountry("GB");
        actualClientDTO.setCpf("Cpf");
        actualClientDTO.setEmail("jane.doe@example.org");
        actualClientDTO.setFullName("Dr Jane Doe");
        actualClientDTO.setId(1L);
        actualClientDTO.setPassport("Passport");
        actualClientDTO.setPhone("6625550144");
        String actualToStringResult = actualClientDTO.toString();
        String actualAddress = actualClientDTO.getAddress();
        LocalDate actualBirthDate = actualClientDTO.getBirthDate();
        String actualCountry = actualClientDTO.getCountry();
        String actualCpf = actualClientDTO.getCpf();
        String actualEmail = actualClientDTO.getEmail();
        String actualFullName = actualClientDTO.getFullName();
        Long actualId = actualClientDTO.getId();
        String actualPassport = actualClientDTO.getPassport();
        assertEquals("42 Main St", actualAddress);
        assertEquals("6625550144", actualClientDTO.getPhone());
        assertEquals("ClientDTO(id=1, country=GB, cpf=Cpf, passport=Passport, fullName=Dr Jane Doe, birthDate=1970-01-01,"
                + " address=42 Main St, phone=6625550144, email=jane.doe@example.org)", actualToStringResult);
        assertEquals("Cpf", actualCpf);
        assertEquals("Dr Jane Doe", actualFullName);
        assertEquals("GB", actualCountry);
        assertEquals("Passport", actualPassport);
        assertEquals("jane.doe@example.org", actualEmail);
        assertEquals(1L, actualId.longValue());
        assertSame(birthDate, actualBirthDate);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link ClientDTO#ClientDTO(Long, String, String, String, String, LocalDate, String, String, String)}
     *   <li>{@link ClientDTO#setAddress(String)}
     *   <li>{@link ClientDTO#setBirthDate(LocalDate)}
     *   <li>{@link ClientDTO#setCountry(String)}
     *   <li>{@link ClientDTO#setCpf(String)}
     *   <li>{@link ClientDTO#setEmail(String)}
     *   <li>{@link ClientDTO#setFullName(String)}
     *   <li>{@link ClientDTO#setId(Long)}
     *   <li>{@link ClientDTO#setPassport(String)}
     *   <li>{@link ClientDTO#setPhone(String)}
     *   <li>{@link ClientDTO#toString()}
     *   <li>{@link ClientDTO#getAddress()}
     *   <li>{@link ClientDTO#getBirthDate()}
     *   <li>{@link ClientDTO#getCountry()}
     *   <li>{@link ClientDTO#getCpf()}
     *   <li>{@link ClientDTO#getEmail()}
     *   <li>{@link ClientDTO#getFullName()}
     *   <li>{@link ClientDTO#getId()}
     *   <li>{@link ClientDTO#getPassport()}
     *   <li>{@link ClientDTO#getPhone()}
     * </ul>
     */
    @Test
    void testGettersAndSetters2() {
        ClientDTO actualClientDTO = new ClientDTO(1L, "GB", "Cpf", "Passport", "Dr Jane Doe", LocalDate.of(1970, 1, 1),
                "42 Main St", "6625550144", "jane.doe@example.org");
        actualClientDTO.setAddress("42 Main St");
        LocalDate birthDate = LocalDate.of(1970, 1, 1);
        actualClientDTO.setBirthDate(birthDate);
        actualClientDTO.setCountry("GB");
        actualClientDTO.setCpf("Cpf");
        actualClientDTO.setEmail("jane.doe@example.org");
        actualClientDTO.setFullName("Dr Jane Doe");
        actualClientDTO.setId(1L);
        actualClientDTO.setPassport("Passport");
        actualClientDTO.setPhone("6625550144");
        String actualToStringResult = actualClientDTO.toString();
        String actualAddress = actualClientDTO.getAddress();
        LocalDate actualBirthDate = actualClientDTO.getBirthDate();
        String actualCountry = actualClientDTO.getCountry();
        String actualCpf = actualClientDTO.getCpf();
        String actualEmail = actualClientDTO.getEmail();
        String actualFullName = actualClientDTO.getFullName();
        Long actualId = actualClientDTO.getId();
        String actualPassport = actualClientDTO.getPassport();
        assertEquals("42 Main St", actualAddress);
        assertEquals("6625550144", actualClientDTO.getPhone());
        assertEquals("ClientDTO(id=1, country=GB, cpf=Cpf, passport=Passport, fullName=Dr Jane Doe, birthDate=1970-01-01,"
                + " address=42 Main St, phone=6625550144, email=jane.doe@example.org)", actualToStringResult);
        assertEquals("Cpf", actualCpf);
        assertEquals("Dr Jane Doe", actualFullName);
        assertEquals("GB", actualCountry);
        assertEquals("Passport", actualPassport);
        assertEquals("jane.doe@example.org", actualEmail);
        assertEquals(1L, actualId.longValue());
        assertSame(birthDate, actualBirthDate);
    }
}
