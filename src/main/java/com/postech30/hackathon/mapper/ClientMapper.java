package com.postech30.hackathon.mapper;

import com.postech30.hackathon.dto.ClientDTO;
import com.postech30.hackathon.entity.Client;

import java.time.LocalDate;

public class ClientMapper {

    public static ClientDTO toDTO(Client client) {
        return new ClientDTO(
                client.getId(),
                client.getCountry(),
                client.getCpf(),
                client.getPassport(),
                client.getFullName(),
                LocalDate.parse(client.getBirthDate()),
                client.getAddress(),
                client.getPhone(),
                client.getEmail()
        );
    }

    public static Client toEntity(ClientDTO clientDTO) {
        return new Client(
                clientDTO.getId(),
                clientDTO.getCountry(),
                clientDTO.getCpf(),
                clientDTO.getPassport(),
                clientDTO.getFullName(),
                clientDTO.getBirthDate().toString(),
                clientDTO.getAddress(),
                clientDTO.getPhone(),
                clientDTO.getEmail()
        );
    }
}
