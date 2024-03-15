package com.postech30.hackathon.service.impl;

import com.postech30.hackathon.dto.BuildingDTO;
import com.postech30.hackathon.entity.Building;
import com.postech30.hackathon.entity.Location;
import com.postech30.hackathon.exceptions.ResourceNotFoundException;
import com.postech30.hackathon.repository.BuildingRepository;
import com.postech30.hackathon.repository.LocationRepository;
import com.postech30.hackathon.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public BuildingDTO createBuilding(BuildingDTO buildingDTO) {
        Building building = mapToEntity(buildingDTO);
        return mapToDTO(buildingRepository.save(building));
    }

    @Override
    public BuildingDTO updateBuilding(String id, BuildingDTO buildingDTO) {
        Building building = buildingRepository.findById(Long.valueOf(id)).orElseThrow(() -> new ResourceNotFoundException("Predio não Encontrado"));
        building.setName(buildingDTO.getName());
        Location location = locationRepository.findById(Long.valueOf(buildingDTO.getLocationId())).orElseThrow(() -> new ResourceNotFoundException("Localização enviado no body não encontrada"));
        building.setLocation(location);
        return mapToDTO(buildingRepository.save(building));
    }

    @Override
    public void deleteBuilding(String id) {
        buildingRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public BuildingDTO getBuildingById(String id) {

        Building building = buildingRepository.findById(Long.valueOf(id)).orElseThrow(() -> new ResourceNotFoundException("Predio não Encontrado"));
        return mapToDTO(building);
    }

    @Override
    public List<BuildingDTO> getAllBuildings() {
        return buildingRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private BuildingDTO mapToDTO(Building building) {
        BuildingDTO dto = new BuildingDTO();
        dto.setId(String.valueOf(building.getId()));
        dto.setLocationId(String.valueOf(building.getLocation().getId()));
        dto.setName(building.getName());
        return dto;
    }

    private Building mapToEntity(BuildingDTO buildingDTO) {
        Building building = new Building();
        Location location = locationRepository.findById(Long.valueOf(buildingDTO.getLocationId())).orElseThrow(() -> new ResourceNotFoundException("Localização não Encontrada"));
        building.setLocation(location);
        building.setName(buildingDTO.getName());
        return building;
    }

}
