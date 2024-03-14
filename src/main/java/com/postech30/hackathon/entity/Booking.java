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
@Table(name = "tb_bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client Client;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    //    @ManyToMany
//    @JoinTable(name="rooms_booked", joinColumns=
//            {@JoinColumn(name="room_id")}, inverseJoinColumns=
//            {@JoinColumn(name="book_id")})
//    private List<Room> rooms;
    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinTable(name = "services_booked",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    private List<Additional> additional;
    private double totalValue;
    private int guests;
}
