package com.postech30.hackathon.controller;

import com.postech30.hackathon.dto.ClientDTO;
import com.postech30.hackathon.service.ClientService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/client")
@Validated
@Transactional
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientDTO> addClient(@RequestBody @Valid ClientDTO clientDTO){
        var clientSave = clientService.createClient(clientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientSave);
    }

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findAll(@RequestParam(defaultValue = "") String searchClient, Pageable pageable) {
        Page<ClientDTO> clientPage = clientService.getClients(searchClient, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(clientPage);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
        var client = clientService.getClientById(id);
        return ResponseEntity.ok(client);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<String> updateClient(@PathVariable Long id, @RequestBody @Valid ClientDTO clientDTO) {
        clientService.updateClient(id, clientDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Os dados do cliente foram atualizados!!");
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente excluido!!");
    }
}
