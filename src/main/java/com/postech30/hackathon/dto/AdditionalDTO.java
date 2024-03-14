package com.postech30.hackathon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdditionalDTO {

    private Long id;

    @JsonProperty
    @NotBlank(message = "O nome do serviço é um campo de preenchimento obrigatório")
    private String name;

    @JsonProperty
    private String description;

    @JsonProperty
    @NotNull(message = "O valor do serviço é um campo de preenchimento obrigatório")
    private Double price;

    private String type;

}
