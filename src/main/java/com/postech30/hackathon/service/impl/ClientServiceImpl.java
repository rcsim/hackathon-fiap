package com.postech30.hackathon.service.impl;

import com.postech30.hackathon.dto.ClientDTO;
import com.postech30.hackathon.entity.Client;
import com.postech30.hackathon.exceptions.ResourceNotFoundException;
import com.postech30.hackathon.mapper.ClientMapper;
import com.postech30.hackathon.repository.ClientRepository;
import com.postech30.hackathon.service.ClientService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    @Transactional
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client savedClient = clientRepository.save(ClientMapper.toEntity(clientDTO));
        return ClientMapper.toDTO(savedClient);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ClientDTO> getClients(String search, Pageable pageable) {
        Page<Client> page;
        if (Objects.equals(search, "")) {
            page = clientRepository.findAll(pageable);
        } else {
            page = clientRepository.findByCountryIgnoreCaseContainingOrCpfIgnoreCaseContainingOrPassportIgnoreCaseContainingOrFullNameIgnoreCaseContainingOrBirthDateIgnoreCaseContainingOrAddressIgnoreCaseContainingOrPhoneIgnoreCaseContainingOrEmailIgnoreCaseContaining(search, search, search, search, search, search, search, search, pageable);
        }
        return page.map(ClientMapper::toDTO);
    }

    @Override
    public ClientDTO getClientById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        return ClientMapper.toDTO(client);
    }

    @Override
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        if (!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente não encontrado");
        }
        Client client = clientRepository.getReferenceById(id);
        client = mapTo(clientDTO, client);
        return ClientMapper.toDTO(clientRepository.save(client));
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public Client mapTo(ClientDTO clientDTO, Client client) {
        client.setCountry(clientDTO.getCountry());
        client.setCpf(clientDTO.getCpf());
        client.setPassport(clientDTO.getPassport());
        client.setFullName(clientDTO.getFullName());
        client.setBirthDate(clientDTO.getBirthDate().toString());
        client.setAddress(clientDTO.getAddress());
        client.setPhone(clientDTO.getPhone());
        client.setEmail(clientDTO.getEmail());
        return client;
    }
}
