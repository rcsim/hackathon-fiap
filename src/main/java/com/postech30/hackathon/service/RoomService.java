package com.postech30.hackathon.service;

import com.postech30.hackathon.dto.AvaliableRoomDTO;
import com.postech30.hackathon.dto.RoomDTO;

import java.util.List;

public interface RoomService {

    RoomDTO createRoom(RoomDTO roomDTO);

    RoomDTO updateRoom(String id, RoomDTO roomDTO);

    void deleteRoom(String id);

    RoomDTO getRoomById(String id);

    List<RoomDTO> getAllRooms();

    List<RoomDTO> getAvaliableRooms(AvaliableRoomDTO avaliableRoomDTO);
}
