package com.postech30.hackathon.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    private String id;
    private String buildingId;
    private String locationId;
    private String type;
    private int totalPeople;
    private int totalBeds;
    private String otherFurniture;
    private String bathroom;
    private double dailyRate;
}
