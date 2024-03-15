package com.postech30.hackathon.service;

import com.postech30.hackathon.dto.BuildingDTO;

import java.util.List;

public interface BuildingService {
    BuildingDTO createBuilding(BuildingDTO buildingDTO);

    BuildingDTO updateBuilding(String id, BuildingDTO buildingDTO);

    void deleteBuilding(String id);

    BuildingDTO getBuildingById(String id);

    List<BuildingDTO> getAllBuildings();
}
