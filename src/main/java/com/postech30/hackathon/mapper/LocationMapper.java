package com.postech30.hackathon.mapper;

import com.postech30.hackathon.dto.LocationDTO;
import com.postech30.hackathon.entity.Location;

public class LocationMapper {

    public static LocationDTO fromEntity(Location location) {
        LocationDTO dto = new LocationDTO();
        dto.setId(String.valueOf(location.getId()));
        dto.setName(location.getName());
        dto.setAddress(location.getAddress());
        dto.setZipCode(location.getZipCode());
        dto.setCity(location.getCity());
        dto.setState(location.getState());
        return dto;
    }

    public static Location toEntity(LocationDTO locationDTO) {
        Location location = new Location();
        location.setName(locationDTO.getName());
        location.setAddress(locationDTO.getAddress());
        location.setZipCode(locationDTO.getZipCode());
        location.setCity(locationDTO.getCity());
        location.setState(locationDTO.getState());
        return location;
    }
}
