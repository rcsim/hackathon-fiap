package com.postech30.hackathon.controller;

import com.postech30.hackathon.dto.ClientDTO;
import com.postech30.hackathon.entity.Client;
import com.postech30.hackathon.repository.ClientRepository;
import com.postech30.hackathon.service.ClientService;
import com.postech30.hackathon.service.impl.ClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class ClientControllerTest {
    /**
     * Method under test: {@link ClientController#addClient(ClientDTO)}
     */
    @Test
    void testAddClient() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        ClientServiceImpl clientService = mock(ClientServiceImpl.class);
        when(clientService.createClient(Mockito.any())).thenReturn(new ClientDTO());
        ClientController clientController = new ClientController(clientService);
        ResponseEntity<ClientDTO> actualAddClientResult = clientController.addClient(new ClientDTO());
        verify(clientService).createClient(Mockito.any());
        assertEquals(201, actualAddClientResult.getStatusCodeValue());
        assertTrue(actualAddClientResult.hasBody());
        assertTrue(actualAddClientResult.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link ClientController#findAll(String, Pageable)}
     */
    @Test
    void testFindAll() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        ClientRepository clientRepository = mock(ClientRepository.class);
        when(clientRepository
                .findByCountryIgnoreCaseContainingOrCpfIgnoreCaseContainingOrPassportIgnoreCaseContainingOrFullNameIgnoreCaseContainingOrBirthDateIgnoreCaseContainingOrAddressIgnoreCaseContainingOrPhoneIgnoreCaseContainingOrEmailIgnoreCaseContaining(
                        Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(),
                        Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(),
                        Mockito.any())).thenReturn(new PageImpl<>(new ArrayList<>()));
        ResponseEntity<Page<ClientDTO>> actualFindAllResult = (new ClientController(
                new ClientServiceImpl(clientRepository))).findAll("Search Client", null);
        verify(clientRepository)
                .findByCountryIgnoreCaseContainingOrCpfIgnoreCaseContainingOrPassportIgnoreCaseContainingOrFullNameIgnoreCaseContainingOrBirthDateIgnoreCaseContainingOrAddressIgnoreCaseContainingOrPhoneIgnoreCaseContainingOrEmailIgnoreCaseContaining(
                        eq("Search Client"), eq("Search Client"), eq("Search Client"), eq("Search Client"), eq("Search Client"),
                        eq("Search Client"), eq("Search Client"), eq("Search Client"), Mockito.any());
        assertEquals(200, actualFindAllResult.getStatusCodeValue());
        assertTrue(actualFindAllResult.getBody().toList().isEmpty());
        assertTrue(actualFindAllResult.hasBody());
        assertTrue(actualFindAllResult.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link ClientController#findById(Long)}
     */
    @Test
    void testFindById() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
        Optional<Client> ofResult = Optional.of(client);
        ClientRepository clientRepository = mock(ClientRepository.class);
        when(clientRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        ResponseEntity<ClientDTO> actualFindByIdResult = (new ClientController(new ClientServiceImpl(clientRepository)))
                .findById(1L);
        verify(clientRepository).findById(Mockito.<Long>any());
        ClientDTO body = actualFindByIdResult.getBody();
        assertEquals("2020-03-01", body.getBirthDate().toString());
        assertEquals("42 Main St", body.getAddress());
        assertEquals("6625550144", body.getPhone());
        assertEquals("Cpf", body.getCpf());
        assertEquals("Dr Jane Doe", body.getFullName());
        assertEquals("GB", body.getCountry());
        assertEquals("Passport", body.getPassport());
        assertEquals("jane.doe@example.org", body.getEmail());
        assertEquals(1L, body.getId().longValue());
        assertEquals(200, actualFindByIdResult.getStatusCodeValue());
        assertTrue(actualFindByIdResult.hasBody());
        assertTrue(actualFindByIdResult.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link ClientController#updateClient(Long, ClientDTO)}
     */
    @Test
    void testUpdateClient() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        ClientService clientService = mock(ClientService.class);
        when(clientService.updateClient(Mockito.<Long>any(), Mockito.any())).thenReturn(new ClientDTO());
        ClientController clientController = new ClientController(clientService);
        ResponseEntity<String> actualUpdateClientResult = clientController.updateClient(1L, new ClientDTO());
        verify(clientService).updateClient(Mockito.<Long>any(), Mockito.any());
        assertEquals("Os dados do cliente foram atualizados!!", actualUpdateClientResult.getBody());
        assertEquals(200, actualUpdateClientResult.getStatusCodeValue());
        assertTrue(actualUpdateClientResult.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link ClientController#deleteClient(Long)}
     */
    @Test
    void testDeleteClient() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        ClientRepository clientRepository = mock(ClientRepository.class);
        doNothing().when(clientRepository).deleteById(Mockito.<Long>any());
        ResponseEntity<String> actualDeleteClientResult = (new ClientController(new ClientServiceImpl(clientRepository)))
                .deleteClient(1L);
        verify(clientRepository).deleteById(Mockito.<Long>any());
        assertEquals("Cliente excluido!!", actualDeleteClientResult.getBody());
        assertEquals(200, actualDeleteClientResult.getStatusCodeValue());
        assertTrue(actualDeleteClientResult.getHeaders().isEmpty());
    }
}
