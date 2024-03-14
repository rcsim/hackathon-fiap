package com.postech30.hackathon.mapper;

import com.postech30.hackathon.dto.AdditionalDTO;
import com.postech30.hackathon.entity.Additional;

public class AdditionalMapper {

    public static AdditionalDTO toDTO(Additional additional) {
        return new AdditionalDTO(additional.getId(), additional.getName(), additional.getDescription(), additional.getPrice(), additional.getType());
    }

    public static Additional toEntity(AdditionalDTO additionalDTO) {
        return new Additional(additionalDTO.getId(), additionalDTO.getName(), additionalDTO.getDescription(), additionalDTO.getPrice(), additionalDTO.getType());
    }
}
