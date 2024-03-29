package com.postech30.hackathon.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
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
public class BookingDTO {

    private Long id;

    @JsonProperty
    @NotNull(message = "idCliente é um campo obrigatório ")
    private Long idClient;

    @JsonProperty
    @NotNull(message = "data de checkin é um campo obrigatório ")
    private LocalDate checkInDate;

    @JsonProperty
    @NotNull(message = "data de checkout é um campo obrigatório ")
    private LocalDate checkOutDate;

    @JsonProperty
    private List<Long> rooms;

    private List<Long> services;

    private double totalValue;

    private int guests;


}
