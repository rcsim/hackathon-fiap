package com.postech30.hackathon.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @JsonProperty
    @NotBlank(message = "O id do local é um campo de preenchimento obrigatório")
    private String locationId;

    @JsonProperty
    @NotBlank(message = "O nome do local é um campo de preenchimento obrigatório")
    private String name;
}
