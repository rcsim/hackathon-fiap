package com.postech30.hackathon.service.impl;

import com.postech30.hackathon.dto.AdditionalDTO;
import com.postech30.hackathon.entity.Additional;
import com.postech30.hackathon.repository.AdditionalRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {AdditionalServiceImpl.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class AdditionalServiceImplTest {
    @MockBean
    private AdditionalRepository additionalRepository;

    @Autowired
    private AdditionalServiceImpl additionalServiceImpl;

    /**
     * Method under test:
     * {@link AdditionalServiceImpl#createServices(AdditionalDTO)}
     */
    @Test
    void testCreateServices() {
        Additional additional = new Additional();
        additional.setDescription("The characteristics of someone or something");
        additional.setId(1L);
        additional.setName("Name");
        additional.setPrice(10.0d);
        additional.setType("Type");
        when(additionalRepository.save(Mockito.any())).thenReturn(additional);
        AdditionalDTO additionalDTO = new AdditionalDTO();
        AdditionalDTO actualCreateServicesResult = additionalServiceImpl.createServices(additionalDTO);
        verify(additionalRepository).save(Mockito.any());
        assertEquals("Name", actualCreateServicesResult.getName());
        assertEquals("Serviço", additionalDTO.getType());
        assertEquals("The characteristics of someone or something", actualCreateServicesResult.getDescription());
        assertEquals("Type", actualCreateServicesResult.getType());
        assertEquals(10.0d, actualCreateServicesResult.getPrice().doubleValue());
        assertEquals(1L, actualCreateServicesResult.getId().longValue());
    }

    /**
     * Method under test:
     * {@link AdditionalServiceImpl#createServices(AdditionalDTO)}
     */
    @Test
    void testCreateServices2() {
        when(additionalRepository.save(Mockito.any())).thenThrow(new RuntimeException("Serviço"));
        assertThrows(RuntimeException.class, () -> additionalServiceImpl.createServices(new AdditionalDTO()));
        verify(additionalRepository).save(Mockito.any());
    }

    /**
     * Method under test: {@link AdditionalServiceImpl#createItens(AdditionalDTO)}
     */
    @Test
    void testCreateItens() {
        Additional additional = new Additional();
        additional.setDescription("The characteristics of someone or something");
        additional.setId(1L);
        additional.setName("Name");
        additional.setPrice(10.0d);
        additional.setType("Type");
        when(additionalRepository.save(Mockito.any())).thenReturn(additional);
        AdditionalDTO additionalDTO = new AdditionalDTO();
        AdditionalDTO actualCreateItensResult = additionalServiceImpl.createItens(additionalDTO);
        verify(additionalRepository).save(Mockito.any());
        assertEquals("Item", additionalDTO.getType());
        assertEquals("Name", actualCreateItensResult.getName());
        assertEquals("The characteristics of someone or something", actualCreateItensResult.getDescription());
        assertEquals("Type", actualCreateItensResult.getType());
        assertEquals(10.0d, actualCreateItensResult.getPrice().doubleValue());
        assertEquals(1L, actualCreateItensResult.getId().longValue());
    }

    /**
     * Method under test: {@link AdditionalServiceImpl#createItens(AdditionalDTO)}
     */
    @Test
    void testCreateItens2() {
        when(additionalRepository.save(Mockito.any())).thenThrow(new RuntimeException("Item"));
        assertThrows(RuntimeException.class, () -> additionalServiceImpl.createItens(new AdditionalDTO()));
        verify(additionalRepository).save(Mockito.any());
    }

    /**
     * Method under test:
     * {@link AdditionalServiceImpl#getServices(String, Pageable)}
     */
    @Test
    void testGetServices() {
        when(additionalRepository.findAll(Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
        Page<AdditionalDTO> actualServices = additionalServiceImpl.getServices("", null);
        verify(additionalRepository).findAll(Mockito.<Pageable>any());
        assertTrue(actualServices.toList().isEmpty());
    }

    /**
     * Method under test:
     * {@link AdditionalServiceImpl#getServices(String, Pageable)}
     */
    @Test
    void testGetServices2() {
        Additional additional = new Additional();
        additional.setDescription("The characteristics of someone or something");
        additional.setId(1L);
        additional.setName("Name");
        additional.setPrice(10.0d);
        additional.setType("Type");

        ArrayList<Additional> content = new ArrayList<>();
        content.add(additional);
        PageImpl<Additional> pageImpl = new PageImpl<>(content);
        when(additionalRepository.findAll(Mockito.<Pageable>any())).thenReturn(pageImpl);
        Page<AdditionalDTO> actualServices = additionalServiceImpl.getServices("", null);
        verify(additionalRepository).findAll(Mockito.<Pageable>any());
        List<AdditionalDTO> toListResult = actualServices.toList();
        assertEquals(1, toListResult.size());
        AdditionalDTO getResult = toListResult.get(0);
        assertEquals("Name", getResult.getName());
        assertEquals("The characteristics of someone or something", getResult.getDescription());
        assertEquals("Type", getResult.getType());
        assertEquals(10.0d, getResult.getPrice().doubleValue());
        assertEquals(1L, getResult.getId().longValue());
    }

    /**
     * Method under test:
     * {@link AdditionalServiceImpl#getServices(String, Pageable)}
     */
    @Test
    void testGetServices3() {
        Additional additional = new Additional();
        additional.setDescription("The characteristics of someone or something");
        additional.setId(1L);
        additional.setName("Name");
        additional.setPrice(10.0d);
        additional.setType("Type");

        Additional additional2 = new Additional();
        additional2.setDescription("Description");
        additional2.setId(2L);
        additional2.setName("");
        additional2.setPrice(0.5d);
        additional2.setType("");

        ArrayList<Additional> content = new ArrayList<>();
        content.add(additional2);
        content.add(additional);
        PageImpl<Additional> pageImpl = new PageImpl<>(content);
        when(additionalRepository.findAll(Mockito.<Pageable>any())).thenReturn(pageImpl);
        Page<AdditionalDTO> actualServices = additionalServiceImpl.getServices("", null);
        verify(additionalRepository).findAll(Mockito.<Pageable>any());
        List<AdditionalDTO> toListResult = actualServices.toList();
        assertEquals(2, toListResult.size());
        AdditionalDTO getResult = toListResult.get(0);
        assertEquals("", getResult.getName());
        assertEquals("", getResult.getType());
        assertEquals("Description", getResult.getDescription());
        AdditionalDTO getResult2 = toListResult.get(1);
        assertEquals("Name", getResult2.getName());
        assertEquals("The characteristics of someone or something", getResult2.getDescription());
        assertEquals("Type", getResult2.getType());
        assertEquals(0.5d, getResult.getPrice().doubleValue());
        assertEquals(10.0d, getResult2.getPrice().doubleValue());
        assertEquals(1L, getResult2.getId().longValue());
        assertEquals(2L, getResult.getId().longValue());
    }

    /**
     * Method under test:
     * {@link AdditionalServiceImpl#getServices(String, Pageable)}
     */
    @Test
    void testGetServices4() {
        when(additionalRepository.findByNameIgnoreCaseOrDescriptionIgnoreCaseOrPriceIgnoreCaseOrTypeIgnoreCase(
                Mockito.any(), Mockito.any(), Mockito.<Double>any(), Mockito.any(),
                Mockito.any())).thenReturn(new PageImpl<>(new ArrayList<>()));
        Page<AdditionalDTO> actualServices = additionalServiceImpl.getServices("42", null);
        verify(additionalRepository).findByNameIgnoreCaseOrDescriptionIgnoreCaseOrPriceIgnoreCaseOrTypeIgnoreCase(eq("42"),
                eq("42"), Mockito.<Double>any(), eq("42"), Mockito.any());
        assertTrue(actualServices.toList().isEmpty());
    }

    /**
     * Method under test:
     * {@link AdditionalServiceImpl#getServices(String, Pageable)}
     */
    @Test
    void testGetServices5() {
        when(additionalRepository.findByNameIgnoreCaseOrDescriptionIgnoreCaseOrPriceIgnoreCaseOrTypeIgnoreCase(
                Mockito.any(), Mockito.any(), Mockito.<Double>any(), Mockito.any(),
                Mockito.any())).thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> additionalServiceImpl.getServices("42", null));
        verify(additionalRepository).findByNameIgnoreCaseOrDescriptionIgnoreCaseOrPriceIgnoreCaseOrTypeIgnoreCase(eq("42"),
                eq("42"), Mockito.<Double>any(), eq("42"), Mockito.any());
    }

    /**
     * Method under test: {@link AdditionalServiceImpl#getServicesById(Long)}
     */
    @Test
    void testGetServicesById() {
        Additional additional = new Additional();
        additional.setDescription("The characteristics of someone or something");
        additional.setId(1L);
        additional.setName("Name");
        additional.setPrice(10.0d);
        additional.setType("Type");
        Optional<Additional> ofResult = Optional.of(additional);
        when(additionalRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        AdditionalDTO actualServicesById = additionalServiceImpl.getServicesById(1L);
        verify(additionalRepository).findById(Mockito.<Long>any());
        assertEquals("Name", actualServicesById.getName());
        assertEquals("The characteristics of someone or something", actualServicesById.getDescription());
        assertEquals("Type", actualServicesById.getType());
        assertEquals(10.0d, actualServicesById.getPrice().doubleValue());
        assertEquals(1L, actualServicesById.getId().longValue());
    }

    /**
     * Method under test: {@link AdditionalServiceImpl#getServicesById(Long)}
     */
    @Test
    void testGetServicesById2() {
        Optional<Additional> emptyResult = Optional.empty();
        when(additionalRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);
        assertThrows(RuntimeException.class, () -> additionalServiceImpl.getServicesById(1L));
        verify(additionalRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link AdditionalServiceImpl#getServicesById(Long)}
     */
    @Test
    void testGetServicesById3() {
        when(additionalRepository.findById(Mockito.<Long>any())).thenThrow(new RuntimeException("Serviço não encontrado"));
        assertThrows(RuntimeException.class, () -> additionalServiceImpl.getServicesById(1L));
        verify(additionalRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test:
     * {@link AdditionalServiceImpl#updateServices(Long, AdditionalDTO)}
     */
    @Test
    void testUpdateServices() {
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
        when(additionalRepository.existsById(1L)).thenReturn(true);
        when(additionalRepository.save(Mockito.any())).thenReturn(additional2);
        when(additionalRepository.getReferenceById(Mockito.<Long>any())).thenReturn(additional);
        AdditionalDTO additionalDTO = new AdditionalDTO();
        AdditionalDTO actualUpdateServicesResult = additionalServiceImpl.updateServices(1L, additionalDTO);
        verify(additionalRepository).getReferenceById(Mockito.<Long>any());
        verify(additionalRepository).save(Mockito.any());
        assertEquals("Name", actualUpdateServicesResult.getName());
        assertEquals("The characteristics of someone or something", actualUpdateServicesResult.getDescription());
        assertEquals("Type", additionalDTO.getType());
        assertEquals("Type", actualUpdateServicesResult.getType());
        assertEquals(10.0d, actualUpdateServicesResult.getPrice().doubleValue());
        assertEquals(1L, actualUpdateServicesResult.getId().longValue());
    }

    /**
     * Method under test:
     * {@link AdditionalServiceImpl#updateServices(Long, AdditionalDTO)}
     */
    @Test
    void testUpdateServices2() {
        Additional additional = new Additional();
        additional.setDescription("The characteristics of someone or something");
        additional.setId(1L);
        additional.setName("Name");
        additional.setPrice(10.0d);
        additional.setType("Type");
        when(additionalRepository.existsById(1L)).thenReturn(true);
        when(additionalRepository.save(Mockito.any())).thenThrow(new RuntimeException("foo"));
        when(additionalRepository.getReferenceById(Mockito.<Long>any())).thenReturn(additional);
        assertThrows(RuntimeException.class, () -> additionalServiceImpl.updateServices(1L, new AdditionalDTO()));
        verify(additionalRepository).getReferenceById(Mockito.<Long>any());
        verify(additionalRepository).save(Mockito.any());
    }

    /**
     * Method under test: {@link AdditionalServiceImpl#deleteServices(Long)}
     */
    @Test
    void testDeleteServices() {
        when(additionalRepository.existsById(1L)).thenReturn(true);
        doNothing().when(additionalRepository).deleteById(Mockito.<Long>any());
        additionalServiceImpl.deleteServices(1L);
        verify(additionalRepository).deleteById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link AdditionalServiceImpl#deleteServices(Long)}
     */
    @Test
    void testDeleteServices2() {
        when(additionalRepository.existsById(1L)).thenReturn(true);
        doThrow(new RuntimeException("foo")).when(additionalRepository).deleteById(Mockito.<Long>any());
        assertThrows(RuntimeException.class, () -> additionalServiceImpl.deleteServices(1L));
        verify(additionalRepository).deleteById(Mockito.<Long>any());
    }
}
