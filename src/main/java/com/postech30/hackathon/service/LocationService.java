package com.postech30.hackathon.service;

import com.postech30.hackathon.dto.LocationDTO;

import java.util.List;

public interface LocationService {

    LocationDTO createLocation(LocationDTO locationDTO);
    LocationDTO updateLocation(String id, LocationDTO locationDTO);
    void deleteLocation(String id);
    LocationDTO getLocationById(String id);
    List<LocationDTO> getAllLocations();
}
