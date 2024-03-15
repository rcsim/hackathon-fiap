package com.postech30.hackathon.repository;

import com.postech30.hackathon.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
