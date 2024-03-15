package com.postech30.hackathon.service.impl;

import com.postech30.hackathon.dto.ClientDTO;
import com.postech30.hackathon.entity.Client;
import com.postech30.hackathon.exceptions.ResourceNotFoundException;
import com.postech30.hackathon.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest {

    @Mock
    private ClientRepository mockClientRepository;

    private ClientServiceImpl clientServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        clientServiceImplUnderTest = new ClientServiceImpl(mockClientRepository);
    }

    @Test
    void testCreateClient() {
        final ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(0L);
        clientDTO.setCountry("country");
        clientDTO.setCpf("cpf");
        clientDTO.setPassport("passport");
        clientDTO.setFullName("fullName");
        clientDTO.setBirthDate(LocalDate.of(2020, 1, 1));
        clientDTO.setAddress("address");
        clientDTO.setPhone("phone");
        clientDTO.setEmail("email");

        final ClientDTO expectedResult = new ClientDTO();
        expectedResult.setId(0L);
        expectedResult.setCountry("country");
        expectedResult.setCpf("cpf");
        expectedResult.setPassport("passport");
        expectedResult.setFullName("fullName");
        expectedResult.setBirthDate(LocalDate.of(2020, 1, 1));
        expectedResult.setAddress("address");
        expectedResult.setPhone("phone");
        expectedResult.setEmail("email");

        final Client client = new Client();
        client.setId(0L);
        client.setCountry("country");
        client.setCpf("cpf");
        client.setPassport("passport");
        client.setFullName("fullName");
        client.setBirthDate("2020-01-01");
        client.setAddress("address");
        client.setPhone("phone");
        client.setEmail("email");
        final Client entity = new Client();
        entity.setId(0L);
        entity.setCountry("country");
        entity.setCpf("cpf");
        entity.setPassport("passport");
        entity.setFullName("fullName");
        entity.setBirthDate("2020-01-01");
        entity.setAddress("address");
        entity.setPhone("phone");
        entity.setEmail("email");
        when(mockClientRepository.save(entity)).thenReturn(client);

        final ClientDTO result = clientServiceImplUnderTest.createClient(clientDTO);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetClientsClientRepositoryFindByCountryIgnoreCaseContainingOrCpfIgnoreCaseContainingOrPassportIgnoreCaseContainingOrFullNameIgnoreCaseContainingOrBirthDateIgnoreCaseContainingOrAddressIgnoreCaseContainingOrPhoneIgnoreCaseContainingOrEmailIgnoreCaseContainingReturnsNoItems() {
        when(mockClientRepository.findByCountryIgnoreCaseContainingOrCpfIgnoreCaseContainingOrPassportIgnoreCaseContainingOrFullNameIgnoreCaseContainingOrBirthDateIgnoreCaseContainingOrAddressIgnoreCaseContainingOrPhoneIgnoreCaseContainingOrEmailIgnoreCaseContaining(eq("search"), eq("search"), eq("search"), eq("search"), eq("search"), eq("search"), eq("search"), eq("search"), any(Pageable.class))).thenReturn(new PageImpl<>(Collections.emptyList()));

        final Page<ClientDTO> result = clientServiceImplUnderTest.getClients("search", PageRequest.of(0, 1));

    }

    @Test
    void testGetClientById() {
        final ClientDTO expectedResult = new ClientDTO();
        expectedResult.setId(0L);
        expectedResult.setCountry("country");
        expectedResult.setCpf("cpf");
        expectedResult.setPassport("passport");
        expectedResult.setFullName("fullName");
        expectedResult.setBirthDate(LocalDate.of(2020, 1, 1));
        expectedResult.setAddress("address");
        expectedResult.setPhone("phone");
        expectedResult.setEmail("email");

        final Client client1 = new Client();
        client1.setId(0L);
        client1.setCountry("country");
        client1.setCpf("cpf");
        client1.setPassport("passport");
        client1.setFullName("fullName");
        client1.setBirthDate("2020-01-01");
        client1.setAddress("address");
        client1.setPhone("phone");
        client1.setEmail("email");
        final Optional<Client> client = Optional.of(client1);
        when(mockClientRepository.findById(0L)).thenReturn(client);

        final ClientDTO result = clientServiceImplUnderTest.getClientById(0L);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetClientByIdClientRepositoryReturnsAbsent() {
        when(mockClientRepository.findById(0L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> clientServiceImplUnderTest.getClientById(0L)).isInstanceOf(ResourceNotFoundException.class);
    }

    @Test
    void testUpdateClient() {
        final ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(0L);
        clientDTO.setCountry("country");
        clientDTO.setCpf("cpf");
        clientDTO.setPassport("passport");
        clientDTO.setFullName("fullName");
        clientDTO.setBirthDate(LocalDate.of(2020, 1, 1));
        clientDTO.setAddress("address");
        clientDTO.setPhone("phone");
        clientDTO.setEmail("email");

        final ClientDTO expectedResult = new ClientDTO();
        expectedResult.setId(0L);
        expectedResult.setCountry("country");
        expectedResult.setCpf("cpf");
        expectedResult.setPassport("passport");
        expectedResult.setFullName("fullName");
        expectedResult.setBirthDate(LocalDate.of(2020, 1, 1));
        expectedResult.setAddress("address");
        expectedResult.setPhone("phone");
        expectedResult.setEmail("email");

        when(mockClientRepository.existsById(0L)).thenReturn(true);

        final Client client = new Client();
        client.setId(0L);
        client.setCountry("country");
        client.setCpf("cpf");
        client.setPassport("passport");
        client.setFullName("fullName");
        client.setBirthDate("birthDate");
        client.setAddress("address");
        client.setPhone("phone");
        client.setEmail("email");
        when(mockClientRepository.getReferenceById(0L)).thenReturn(client);

        final Client client1 = new Client();
        client1.setId(0L);
        client1.setCountry("country");
        client1.setCpf("cpf");
        client1.setPassport("passport");
        client1.setFullName("fullName");
        client1.setBirthDate("2020-01-01");
        client1.setAddress("address");
        client1.setPhone("phone");
        client1.setEmail("email");
        final Client entity = new Client();
        entity.setId(0L);
        entity.setCountry("country");
        entity.setCpf("cpf");
        entity.setPassport("passport");
        entity.setFullName("fullName");
        entity.setBirthDate("2020-01-01");
        entity.setAddress("address");
        entity.setPhone("phone");
        entity.setEmail("email");
        when(mockClientRepository.save(entity)).thenReturn(client1);

        final ClientDTO result = clientServiceImplUnderTest.updateClient(0L, clientDTO);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testUpdateClientClientRepositoryExistsByIdReturnsFalse() {
        final ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(0L);
        clientDTO.setCountry("country");
        clientDTO.setCpf("cpf");
        clientDTO.setPassport("passport");
        clientDTO.setFullName("fullName");
        clientDTO.setBirthDate(LocalDate.of(2020, 1, 1));
        clientDTO.setAddress("address");
        clientDTO.setPhone("phone");
        clientDTO.setEmail("email");

        when(mockClientRepository.existsById(0L)).thenReturn(false);

        assertThatThrownBy(() -> clientServiceImplUnderTest.updateClient(0L, clientDTO)).isInstanceOf(ResourceNotFoundException.class);
    }

    @Test
    void testDeleteClient() {

        when(mockClientRepository.existsById(0L)).thenReturn(true);
        clientServiceImplUnderTest.deleteClient(0L);

        verify(mockClientRepository).deleteById(0L);
    }

    @Test
    void testMapTo() {
        final ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(0L);
        clientDTO.setCountry("country");
        clientDTO.setCpf("cpf");
        clientDTO.setPassport("passport");
        clientDTO.setFullName("fullName");
        clientDTO.setBirthDate(LocalDate.of(2020, 1, 1));
        clientDTO.setAddress("address");
        clientDTO.setPhone("phone");
        clientDTO.setEmail("email");

        final Client client = new Client();
        client.setId(0L);
        client.setCountry("country");
        client.setCpf("cpf");
        client.setPassport("passport");
        client.setFullName("fullName");
        client.setBirthDate("2020-01-01");
        client.setAddress("address");
        client.setPhone("phone");
        client.setEmail("email");

        final Client expectedResult = new Client();
        expectedResult.setId(0L);
        expectedResult.setCountry("country");
        expectedResult.setCpf("cpf");
        expectedResult.setPassport("passport");
        expectedResult.setFullName("fullName");
        expectedResult.setBirthDate("2020-01-01");
        expectedResult.setAddress("address");
        expectedResult.setPhone("phone");
        expectedResult.setEmail("email");

        final Client result = clientServiceImplUnderTest.mapTo(clientDTO, client);

        assertThat(result).isEqualTo(expectedResult);
    }
}
