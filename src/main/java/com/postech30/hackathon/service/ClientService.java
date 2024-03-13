package com.postech30.hackathon.service;

import com.postech30.hackathon.dto.ClientDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService {

    ClientDTO createClient(ClientDTO clientDTO);

    Page<ClientDTO> getClients(String search, Pageable pageable);

    ClientDTO getClientById(Long id);

    ClientDTO updateClient(Long id, ClientDTO clientDTO);

    void deleteClient(Long id);
}
