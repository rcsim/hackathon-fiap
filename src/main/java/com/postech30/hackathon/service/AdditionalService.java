package com.postech30.hackathon.service;

import com.postech30.hackathon.dto.AdditionalDTO;
import com.postech30.hackathon.exceptions.AdditionalNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdditionalService {
    AdditionalDTO createServices(AdditionalDTO additionalDTO);

    AdditionalDTO createItens(AdditionalDTO additionalDTO);

    Page<AdditionalDTO> getServices(String search, Pageable pageable);

    AdditionalDTO getServicesById(Long id) throws AdditionalNotFoundException;

    AdditionalDTO updateServices(Long id, AdditionalDTO additionalDTO) throws AdditionalNotFoundException;

    void deleteServices(Long id) throws AdditionalNotFoundException;
}
