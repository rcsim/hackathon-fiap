package com.postech30.hackathon.dto;

import com.postech30.hackathon.entity.Booking;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
    private Long id;
    private Long idCustumer;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private List<Long> rooms;
    private List<Long> services;
    private double totalValue;
    private int guests;


}
