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
public class RoomDTO {

    private String id;

    @JsonProperty
    @NotBlank(message = "O id do prédio é um campo de preenchimento obrigatório")
    private String buildingId;

    @JsonProperty
    @NotBlank(message = "O id do local é um campo de preenchimento obrigatório")
    private String locationId;


    @JsonProperty
    @NotBlank(message = "O tipo do quarto é um campo de preenchimento obrigatório")
    private String type;

    @JsonProperty
    @NotNull(message = "O número de pessoas é um campo de preenchimento obrigatório")
    private int totalPeople;

    @JsonProperty
    @NotNull(message = "O número de camas é um campo de preenchimento obrigatório")
    private int totalBeds;

    @JsonProperty
    @NotBlank(message = "Outros móveis é um campo de preenchimento obrigatório")
    private String otherFurniture;

    @JsonProperty
    @NotBlank(message = "O número de banheiros é um campo de preenchimento obrigatório")
    private String bathroom;

    @JsonProperty
    @NotNull(message = "A nota do quarto é um campo de preenchimento obrigatório")
    private double dailyRate;
}
