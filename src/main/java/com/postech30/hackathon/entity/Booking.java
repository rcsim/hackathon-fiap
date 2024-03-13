package com.postech30.hackathon.entity;

import jakarta.persistence.*;
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
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_custumer")
    private Custumer idCustumer;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    @ManyToMany
    @JoinTable(name="rooms_booked", joinColumns=
            {@JoinColumn(name="room_id")}, inverseJoinColumns=
            {@JoinColumn(name="book_id")})
    private List<Room> rooms;
    @ManyToMany
    @JoinTable(name="services_booked", joinColumns=
            {@JoinColumn(name="service_id")}, inverseJoinColumns=
            {@JoinColumn(name="book_id")})
    private List<Service> services;
    private double totalValue;
    private int guests;
}
