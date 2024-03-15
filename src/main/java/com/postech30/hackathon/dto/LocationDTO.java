package com.postech30.hackathon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationDTO {

    private String id;

    @JsonProperty
    @NotBlank(message = "O nome do local é um campo de preenchimento obrigatório")
    private String name;

    @JsonProperty
    @NotBlank(message = "O endereço do local é um campo de preenchimento obrigatório")
    private String address;

    @JsonProperty
    @NotBlank(message = "O CEP do local é um campo de preenchimento obrigatório")
    private String zipCode;

    @JsonProperty
    @NotBlank(message = "A cidade do local é um campo de preenchimento obrigatório")
    private String city;

    @JsonProperty
    @NotBlank(message = "O estado do local é um campo de preenchimento obrigatório")
    private String state;
}
