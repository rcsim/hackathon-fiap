package com.postech30.hackathon.controller;

import com.postech30.hackathon.dto.BuildingDTO;
import com.postech30.hackathon.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/building")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @PostMapping
    public ResponseEntity<BuildingDTO> createBuilding(@RequestBody BuildingDTO building) {
        BuildingDTO createdBuilding = buildingService.createBuilding(building);
        return ResponseEntity.ok(createdBuilding);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BuildingDTO> updateBuilding(@PathVariable String id, @RequestBody BuildingDTO building) {
        BuildingDTO updatedBuilding = buildingService.updateBuilding(id, building);
        return ResponseEntity.ok(updatedBuilding);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuilding(@PathVariable String id) {
        buildingService.deleteBuilding(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuildingDTO> getBuildingById(@PathVariable String id) {
        BuildingDTO building = buildingService.getBuildingById(id);
        return ResponseEntity.ok(building);
    }

    @GetMapping
    public ResponseEntity<List<BuildingDTO>> getAllBuildings() {
        List<BuildingDTO> buildings = buildingService.getAllBuildings();
        return ResponseEntity.ok(buildings);
    }

}
