package com.postech30.hackathon.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    private Long id;

    @JsonProperty
    @NotBlank(message = "O país é um campo de preenchimento obrigatório")
    private String country;

    @JsonProperty
    @NotBlank(message = "O CPF é um campo de preenchimento obrigatório")
    private String cpf;

    @JsonProperty
    @NotBlank(message = "O passaporte é um campo de preenchimento obrigatório")
    private String passport;

    @JsonProperty
    @NotBlank(message = "O nome completo é um campo de preenchimento obrigatório")
    private String fullName;

    //Change the type of the attribute to a Date
    @JsonProperty
    @NotNull(message = "A data de nascimento é um campo de preenchimento obrigatório")
    private LocalDate birthDate;

    @JsonProperty
    @NotBlank(message = "O endereço é um campo de preenchimento obrigatório")
    private String address;

    @JsonProperty
    @NotBlank(message = "O telefone é um campo de preenchimento obrigatório")
    private String phone;

    @JsonProperty
    @Email
    @NotBlank(message = "O e-mail é um campo de preenchimento obrigatório")
    private String email;
}
