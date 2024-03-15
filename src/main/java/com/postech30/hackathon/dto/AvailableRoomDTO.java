package com.postech30.hackathon.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AvailableRoomDTO {

    @JsonProperty
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "A data de check-in é um campo de preenchimento obrigatório")
    private LocalDate checkInDate;

    @JsonProperty
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "A data de check-out é um campo de preenchimento obrigatório")
    private LocalDate checkOutDate;
}
