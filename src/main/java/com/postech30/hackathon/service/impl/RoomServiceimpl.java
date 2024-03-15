package com.postech30.hackathon.service.impl;


import com.postech30.hackathon.dto.AvaliableRoomDTO;
import com.postech30.hackathon.dto.RoomDTO;
import com.postech30.hackathon.entity.Booking;
import com.postech30.hackathon.entity.Building;
import com.postech30.hackathon.entity.Location;
import com.postech30.hackathon.entity.Room;
import com.postech30.hackathon.exceptions.ResourceNotFoundException;
import com.postech30.hackathon.repository.BookingRepository;
import com.postech30.hackathon.repository.BuildingRepository;
import com.postech30.hackathon.repository.LocationRepository;
import com.postech30.hackathon.repository.RoomRepository;
import com.postech30.hackathon.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceimpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private BookingRepository bookingRepository;


    @Override
    public RoomDTO createRoom(RoomDTO roomDTO) {
        Room room = toEntity(roomDTO);
        return fromEntity(roomRepository.save(room));
    }

    @Override
    public RoomDTO updateRoom(String id, RoomDTO roomDTO) {
        Room room = roomRepository.findById(Long.valueOf(id)).orElseThrow(() -> new ResourceNotFoundException("Quarto não Encontrado"));
        Location location = locationRepository.findById(Long.valueOf(roomDTO.getLocationId())).orElseThrow(() -> new ResourceNotFoundException("Localização não Encontrada"));
        Building building = buildingRepository.findById(Long.valueOf(roomDTO.getBuildingId())).orElseThrow(() -> new ResourceNotFoundException("Predio não Encontrado"));

        room.setBuilding(building);
        room.setLocation(location);
        room.setType(roomDTO.getType());
        room.setTotalPeople(roomDTO.getTotalPeople());
        room.setTotalBeds(roomDTO.getTotalBeds());
        room.setOtherFurniture(roomDTO.getOtherFurniture());
        room.setBathroom(roomDTO.getBathroom());
        room.setDailyRate(roomDTO.getDailyRate());

        return fromEntity(roomRepository.save(room));
    }

    @Override
    public void deleteRoom(String id) {
        roomRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public RoomDTO getRoomById(String id) {
       Room room= roomRepository.findById(Long.valueOf(id)).orElseThrow(() -> new ResourceNotFoundException("Quarto não Encontrado"));
            return fromEntity(room);
    }

    @Override
    public List<RoomDTO> getAllRooms() {
       return roomRepository.findAll().stream()
               .map(this::fromEntity)
               .collect(Collectors.toList());
    }

    @Override
    public List<RoomDTO> getAvaliableRooms(AvaliableRoomDTO avaliableRoomDTO) {

        List<Room> allRooms = roomRepository.findAll();
        var roomAvaliable = allRooms.stream()
                .filter(room -> isRoomAvailable(room, avaliableRoomDTO.getCheckInDate(), avaliableRoomDTO.getCheckOutDate()))
                .collect(Collectors.toList());
        return roomAvaliable.stream().map(this::fromEntity).collect(Collectors.toList());
    }
    private boolean isRoomAvailable(Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        List<Booking> bookings = bookingRepository.findBookingsByRoomIdAndOverlappingDates(room.getId(), checkInDate, checkOutDate);

        return bookings.isEmpty();
    }


    private RoomDTO fromEntity(Room room) {
        RoomDTO dto = new RoomDTO();
        dto.setId(String.valueOf(room.getId()));
        dto.setBuildingId(String.valueOf(room.getBuilding().getId()));
        dto.setLocationId(String.valueOf(room.getLocation().getId()));
        dto.setType(room.getType());
        dto.setTotalPeople(room.getTotalPeople());
        dto.setTotalBeds(room.getTotalBeds());
        dto.setOtherFurniture(room.getOtherFurniture());
        dto.setBathroom(room.getBathroom());
        dto.setDailyRate(room.getDailyRate());
        return dto;
    }
    private Room toEntity(RoomDTO roomDTO) {
        Room room = new Room();
        room.setId(Long.valueOf(roomDTO.getId()));
        Building building = buildingRepository.findById(Long.valueOf(roomDTO.getBuildingId())).orElseThrow(() -> new ResourceNotFoundException("Predio não Encontrado"));
        Location location = locationRepository.findById(Long.valueOf(roomDTO.getLocationId())).orElseThrow(() -> new ResourceNotFoundException("Localização não Encontrada"));
        room.setBuilding(building);
        room.setLocation(location);
        room.setType(roomDTO.getType());
        room.setTotalPeople(roomDTO.getTotalPeople());
        room.setTotalBeds(roomDTO.getTotalBeds());
        room.setOtherFurniture(roomDTO.getOtherFurniture());
        room.setBathroom(roomDTO.getBathroom());
        room.setDailyRate(roomDTO.getDailyRate());
        return room;
    }

}
