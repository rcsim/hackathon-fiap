package com.postech30.hackathon.controller;

import com.postech30.hackathon.dto.AdditionalDTO;
import com.postech30.hackathon.entity.Additional;
import com.postech30.hackathon.exceptions.AdditionalNotFoundException;
import com.postech30.hackathon.repository.AdditionalRepository;
import com.postech30.hackathon.service.AdditionalService;
import com.postech30.hackathon.service.impl.AdditionalServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {AdditionalController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class AdditionalControllerTest {
    @Autowired
    private AdditionalController additionalController;

    @MockBean
    private AdditionalService additionalService;

    /**
     * Method under test: {@link AdditionalController#addItems(AdditionalDTO)}
     */
    @Test
    void testAddItems() throws Exception {
        Additional additional = new Additional();
        additional.setDescription("The characteristics of someone or something");
        additional.setId(1L);
        additional.setName("Name");
        additional.setPrice(10.0d);
        additional.setType("Type");
        AdditionalRepository additionalRepository = mock(AdditionalRepository.class);
        when(additionalRepository.save(Mockito.any())).thenReturn(additional);
        AdditionalController additionalController = new AdditionalController(
                new AdditionalServiceImpl(additionalRepository));
        AdditionalDTO additionalDTO = new AdditionalDTO();
        ResponseEntity<AdditionalDTO> actualAddServicesResult = additionalController.addItems(additionalDTO);
        verify(additionalRepository).save(Mockito.any());
        AdditionalDTO body = actualAddServicesResult.getBody();
        assertEquals("Name", body.getName());
        assertEquals("Item", additionalDTO.getType());
        assertEquals("The characteristics of someone or something", body.getDescription());
        assertEquals("Type", body.getType());
        assertEquals(10.0d, body.getPrice().doubleValue());
        assertEquals(1L, body.getId().longValue());
        assertEquals(201, actualAddServicesResult.getStatusCodeValue());
        assertTrue(actualAddServicesResult.hasBody());
        assertTrue(actualAddServicesResult.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link AdditionalController#findAll(String, Pageable)}
     */
    @Test
    void testFindAll() {
        AdditionalServiceImpl additionalService = mock(AdditionalServiceImpl.class);
        when(additionalService.getServices(Mockito.any(), Mockito.any()))
                .thenReturn(new PageImpl<>(new ArrayList<>()));
        ResponseEntity<Page<AdditionalDTO>> actualFindAllResult = (new AdditionalController(additionalService))
                .findAll("Search Services", null);
        verify(additionalService).getServices(eq("Search Services"), Mockito.any());
        assertEquals(200, actualFindAllResult.getStatusCodeValue());
        assertTrue(actualFindAllResult.getBody().toList().isEmpty());
        assertTrue(actualFindAllResult.hasBody());
        assertTrue(actualFindAllResult.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link AdditionalController#addServices(AdditionalDTO)}
     */
    @Test
    void testAddServices() {
        Additional additional = new Additional();
        additional.setDescription("The characteristics of someone or something");
        additional.setId(1L);
        additional.setName("Name");
        additional.setPrice(10.0d);
        additional.setType("Type");
        AdditionalRepository additionalRepository = mock(AdditionalRepository.class);
        when(additionalRepository.save(Mockito.any())).thenReturn(additional);
        AdditionalController additionalController = new AdditionalController(
                new AdditionalServiceImpl(additionalRepository));
        AdditionalDTO additionalDTO = new AdditionalDTO();
        ResponseEntity<AdditionalDTO> actualAddServicesResult = additionalController.addServices(additionalDTO);
        verify(additionalRepository).save(Mockito.any());
        AdditionalDTO body = actualAddServicesResult.getBody();
        assertEquals("Name", body.getName());
        assertEquals("Serviço", additionalDTO.getType());
        assertEquals("The characteristics of someone or something", body.getDescription());
        assertEquals("Type", body.getType());
        assertEquals(10.0d, body.getPrice().doubleValue());
        assertEquals(1L, body.getId().longValue());
        assertEquals(201, actualAddServicesResult.getStatusCodeValue());
        assertTrue(actualAddServicesResult.hasBody());
        assertTrue(actualAddServicesResult.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link AdditionalController#findById(Long)}
     */
    @Test
    void testFindById() throws AdditionalNotFoundException {

        Additional additional = new Additional();
        additional.setDescription("The characteristics of someone or something");
        additional.setId(1L);
        additional.setName("Name");
        additional.setPrice(10.0d);
        additional.setType("Type");
        Optional<Additional> ofResult = Optional.of(additional);
        AdditionalRepository additionalRepository = mock(AdditionalRepository.class);
        when(additionalRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        ResponseEntity<AdditionalDTO> actualFindByIdResult = (new AdditionalController(
                new AdditionalServiceImpl(additionalRepository))).findById(1L);
        verify(additionalRepository).findById(Mockito.<Long>any());
        AdditionalDTO body = actualFindByIdResult.getBody();
        assertEquals("Name", body.getName());
        assertEquals("The characteristics of someone or something", body.getDescription());
        assertEquals("Type", body.getType());
        assertEquals(10.0d, body.getPrice().doubleValue());
        assertEquals(1L, body.getId().longValue());
        assertEquals(200, actualFindByIdResult.getStatusCodeValue());
        assertTrue(actualFindByIdResult.hasBody());
        assertTrue(actualFindByIdResult.getHeaders().isEmpty());
    }

    /**
     * Method under test:
     * {@link AdditionalController#updateServices(Long, AdditionalDTO)}
     */
    @Test
    void testUpdateServices() throws AdditionalNotFoundException {

        Additional additional = new Additional();
        additional.setDescription("The characteristics of someone or something");
        additional.setId(1L);
        additional.setName("Name");
        additional.setPrice(10.0d);
        additional.setType("Type");

        Additional additional2 = new Additional();
        additional2.setDescription("The characteristics of someone or something");
        additional2.setId(1L);
        additional2.setName("Name");
        additional2.setPrice(10.0d);
        additional2.setType("Type");
        AdditionalRepository additionalRepository = mock(AdditionalRepository.class);
        when(additionalRepository.existsById(1L)).thenReturn(true);
        when(additionalRepository.save(Mockito.any())).thenReturn(additional2);
        when(additionalRepository.getReferenceById(Mockito.<Long>any())).thenReturn(additional);
        AdditionalController additionalController = new AdditionalController(
                new AdditionalServiceImpl(additionalRepository));
        AdditionalDTO additionalDTO = new AdditionalDTO();
        when(additionalRepository.findById(Mockito.<Long>any())).thenReturn(Optional.<Additional>of(additional));
        ResponseEntity<String> actualUpdateServicesResult = additionalController.updateServices(1L, additionalDTO);
        verify(additionalRepository).findById(Mockito.<Long>any());
        verify(additionalRepository).save(Mockito.any());
        assertEquals("Os dados do serviço foram atualizados!!", actualUpdateServicesResult.getBody());
        assertEquals("Type", additionalDTO.getType());
        assertEquals(200, actualUpdateServicesResult.getStatusCodeValue());
        assertTrue(actualUpdateServicesResult.getHeaders().isEmpty());
    }



    /**
     * Method under test: {@link AdditionalController#deleteServices(Long)}
     */
    @Test
    void testDeleteServices() throws AdditionalNotFoundException {


        AdditionalRepository additionalRepository = mock(AdditionalRepository.class);
        doNothing().when(additionalRepository).deleteById(Mockito.<Long>any());
        when(additionalRepository.existsById(1L)).thenReturn(true);
        ResponseEntity<String> actualDeleteServicesResult = (new AdditionalController(
                new AdditionalServiceImpl(additionalRepository))).deleteServices(1L);
        verify(additionalRepository).deleteById(Mockito.<Long>any());
        assertEquals("Serviço excluído!!", actualDeleteServicesResult.getBody());
        assertEquals(200, actualDeleteServicesResult.getStatusCodeValue());
        assertTrue(actualDeleteServicesResult.getHeaders().isEmpty());
    }
}
