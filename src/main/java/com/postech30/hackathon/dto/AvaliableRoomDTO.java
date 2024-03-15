package com.postech30.hackathon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AvaliableRoomDTO {
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
