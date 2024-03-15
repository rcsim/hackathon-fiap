package com.postech30.hackathon.repository;

import com.postech30.hackathon.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("SELECT b FROM Booking b JOIN b.rooms r WHERE r.id = :roomId AND ((b.checkInDate <= :checkInDate AND b.checkOutDate >= :checkInDate) OR (b.checkInDate <= :checkOutDate AND b.checkOutDate >= :checkOutDate))")
    List<Booking> findBookingsByRoomIdAndOverlappingDates(Long roomId, LocalDate checkInDate, LocalDate checkOutDate);
}
