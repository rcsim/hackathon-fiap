package com.postech30.hackathon.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BuildingDTO {
    private String id;
    private String locationId;
    private String name;
}
