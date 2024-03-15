package com.postech30.hackathon.service.impl;

import com.postech30.hackathon.dto.AvailableRoomDTO;
import com.postech30.hackathon.dto.RoomDTO;
import com.postech30.hackathon.entity.*;
import com.postech30.hackathon.repository.BookingRepository;
import com.postech30.hackathon.repository.BuildingRepository;
import com.postech30.hackathon.repository.LocationRepository;
import com.postech30.hackathon.repository.RoomRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoomServiceImplTest {

    @Mock
    private RoomRepository mockRoomRepository;
    @Mock
    private BuildingRepository mockBuildingRepository;
    @Mock
    private LocationRepository mockLocationRepository;
    @Mock
    private BookingRepository mockBookingRepository;

    @InjectMocks
    private RoomServiceImpl roomServiceImplUnderTest;

    @Test
    void testGetAllRooms() {
        final Room room = new Room();
        room.setId(0L);
        final Building building = new Building();
        building.setId(0L);
        room.setBuilding(building);
        final Location location = new Location();
        location.setId(0L);
        room.setLocation(location);
        room.setType("type");
        room.setTotalPeople(0);
        room.setTotalBeds(0);
        room.setOtherFurniture("otherFurniture");
        room.setBathroom("bathroom");
        room.setDailyRate(0.0);
        final List<Room> rooms = List.of(room);
        when(mockRoomRepository.findAll()).thenReturn(rooms);

        final List<RoomDTO> result = roomServiceImplUnderTest.getAllRooms();

    }

    @Test
    void testGetAllRoomsRoomRepositoryReturnsNoItems() {
        when(mockRoomRepository.findAll()).thenReturn(Collections.emptyList());

        final List<RoomDTO> result = roomServiceImplUnderTest.getAllRooms();

        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetAvaliableRooms() {
        final AvailableRoomDTO availableRoomDTO = new AvailableRoomDTO(LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 1, 1));

        final Room room = new Room();
        room.setId(0L);
        final Building building = new Building();
        building.setId(0L);
        room.setBuilding(building);
        final Location location = new Location();
        location.setId(0L);
        room.setLocation(location);
        room.setType("type");
        room.setTotalPeople(0);
        room.setTotalBeds(0);
        room.setOtherFurniture("otherFurniture");
        room.setBathroom("bathroom");
        room.setDailyRate(0.0);
        final List<Room> rooms = List.of(room);
        when(mockRoomRepository.findAll()).thenReturn(rooms);

        final Booking booking = new Booking();
        booking.setId(0L);
        final Client client = new Client();
        client.setId(0L);
        client.setCountry("country");
        client.setCpf("cpf");
        booking.setClient(client);
        final List<Booking> bookings = List.of(booking);
        when(mockBookingRepository.findBookingsByRoomIdAndOverlappingDates(0L, LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 1, 1))).thenReturn(bookings);

        final List<RoomDTO> result = roomServiceImplUnderTest.getAvaliableRooms(availableRoomDTO);

        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetAvaliableRoomsRoomRepositoryReturnsNoItems() {
        final AvailableRoomDTO availableRoomDTO = new AvailableRoomDTO(LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 1, 1));
        when(mockRoomRepository.findAll()).thenReturn(Collections.emptyList());

        final List<RoomDTO> result = roomServiceImplUnderTest.getAvaliableRooms(availableRoomDTO);

        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetAvaliableRooms_BookingRepositoryReturnsNoItems() {
        final AvailableRoomDTO availableRoomDTO = new AvailableRoomDTO(LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 1, 1));

        final Room room = new Room();
        room.setId(0L);
        final Building building = new Building();
        building.setId(0L);
        room.setBuilding(building);
        final Location location = new Location();
        location.setId(0L);
        room.setLocation(location);
        room.setType("type");
        room.setTotalPeople(0);
        room.setTotalBeds(0);
        room.setOtherFurniture("otherFurniture");
        room.setBathroom("bathroom");
        room.setDailyRate(0.0);
        final List<Room> rooms = List.of(room);
        when(mockRoomRepository.findAll()).thenReturn(rooms);

        when(mockBookingRepository.findBookingsByRoomIdAndOverlappingDates(0L, LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 1, 1))).thenReturn(Collections.emptyList());

        final List<RoomDTO> result = roomServiceImplUnderTest.getAvaliableRooms(availableRoomDTO);

    }
}
