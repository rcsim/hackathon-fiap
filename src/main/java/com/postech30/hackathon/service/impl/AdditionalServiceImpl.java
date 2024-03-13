package com.postech30.hackathon.service.impl;

import com.postech30.hackathon.dto.AdditionalDTO;
import com.postech30.hackathon.entity.Additional;
import com.postech30.hackathon.mapper.AdditionalMapper;
import com.postech30.hackathon.repository.AdditionalRepository;
import com.postech30.hackathon.service.AdditionalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class AdditionalServiceImpl implements AdditionalService {

    private final AdditionalRepository additionalRepository;

    public AdditionalServiceImpl(AdditionalRepository additionalRepository) {
        this.additionalRepository = additionalRepository;
    }

    @Override
    @Transactional
    public AdditionalDTO createServices(AdditionalDTO additionalDTO) {
        additionalDTO.setType("Serviço");
        Additional savedService = additionalRepository.save(AdditionalMapper.toEntity(additionalDTO));
        return AdditionalMapper.toDTO(savedService);
    }

    @Override
    @Transactional
    public AdditionalDTO createItens(AdditionalDTO additionalDTO) {
        additionalDTO.setType("Item");
        Additional savedService = additionalRepository.save(AdditionalMapper.toEntity(additionalDTO));
        return AdditionalMapper.toDTO(savedService);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AdditionalDTO> getServices(String search, Pageable pageable) {
        Page<Additional> page;
        if (Objects.equals(search, "")) {
            page = additionalRepository.findAll(pageable);
        } else {
            page = additionalRepository.findByNameIgnoreCaseOrDescriptionIgnoreCaseOrPriceIgnoreCaseOrTypeIgnoreCase(search, search, Double.valueOf(search), search, pageable);
        }
        return page.map(AdditionalMapper::toDTO);
    }

    @Override
    public AdditionalDTO getServicesById(Long id) {
        Additional additional = additionalRepository.findById(id).orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
        return AdditionalMapper.toDTO(additional);

    }

    @Override
    public AdditionalDTO updateServices(Long id, AdditionalDTO additionalDTO) {
        Additional additional = additionalRepository.getReferenceById(id);
        additionalDTO.setType(additional.getType());
        mapTo(additionalDTO, additional);
        return AdditionalMapper.toDTO(additionalRepository.save(additional));
    }

    @Override
    public void deleteServices(Long id) {
        additionalRepository.deleteById(id);
    }

    private Additional mapTo(AdditionalDTO additionalDTO, Additional additional) {
        additional.setName(additionalDTO.getName());
        additional.setDescription(additionalDTO.getDescription());
        additional.setPrice(additionalDTO.getPrice());
        additional.setType(additionalDTO.getType());
        return additional;
    }
}
