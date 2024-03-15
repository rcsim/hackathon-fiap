package com.postech30.hackathon.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tb_rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long roomID;

    private TypeRoom typeRoom;

    private int numberOfPerson;

    private int numberOfBeds;

    private double price;

    private  Boolean available;


}