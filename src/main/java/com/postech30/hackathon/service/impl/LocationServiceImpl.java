package com.postech30.hackathon.service.impl;

import com.postech30.hackathon.dto.LocationDTO;
import com.postech30.hackathon.entity.Location;
import com.postech30.hackathon.exceptions.ResourceNotFoundException;
import com.postech30.hackathon.mapper.LocationMapper;
import com.postech30.hackathon.repository.LocationRepository;
import com.postech30.hackathon.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public LocationDTO createLocation(LocationDTO locationDTO) {

        Location location = LocationMapper.toEntity(locationDTO);

        return LocationMapper.fromEntity(locationRepository.save(location));
    }

    @Override
    public LocationDTO updateLocation(String id, LocationDTO locationDTO) {
        Location location = locationRepository.findById(Long.valueOf(id)).orElseThrow(() -> new ResourceNotFoundException("Localização não Encontrada"));
        location = mapTo(location, locationDTO);
        return LocationMapper.fromEntity(locationRepository.save(location));
    }

    @Override
    public void deleteLocation(String id) {

        if (!locationRepository.existsById(Long.valueOf(id))) {
            throw new ResourceNotFoundException("Localização não Encontrada");
        }
        locationRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public LocationDTO getLocationById(String id) {

        Location location = locationRepository.findById(Long.valueOf(id)).orElseThrow(() -> new ResourceNotFoundException("Localização não Encontrada"));
        return LocationMapper.fromEntity(location);
    }

    @Override
    public List<LocationDTO> getAllLocations() {

        return locationRepository.findAll().stream()
                .map(LocationMapper::fromEntity)
                .collect(Collectors.toList());
    }

    private Location mapTo(Location location, LocationDTO locationDTO) {
        location.setAddress(locationDTO.getAddress());
        location.setName(locationDTO.getName());
        location.setState(locationDTO.getState());
        location.setZipCode(locationDTO.getZipCode());
        location.setCity(locationDTO.getCity());
        return location;
    }


}
