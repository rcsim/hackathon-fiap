package com.postech30.hackathon.controller;

import com.postech30.hackathon.dto.ClientDTO;
import com.postech30.hackathon.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Cadastro de Clientes",
            description = "Adiciona um Cliente na base de dados do sistema, todos os parâmetros são obrigatórios")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Cliente adicionado"),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "422", description = "Parâmetro não pode ser nulo")
    })
    @PostMapping
    public ResponseEntity<ClientDTO> addClient(@RequestBody @Valid ClientDTO clientDTO){
        var clientSave = clientService.createClient(clientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientSave);
    }

    @Operation(summary = "Busca de Clientes", description = "Busca todos os Clientes na base de dados do sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de Clientes cadastrados no sistema. Retorna uma lista vazia caso não exista Clientes cadastrados"),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "422", description = "Parâmetro não pode ser nulo")
    })
    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findAll(@RequestParam(defaultValue = "") String searchClient, Pageable pageable) {
        Page<ClientDTO> clientPage = clientService.getClients(searchClient, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(clientPage);
    }

    @Operation(summary = "Busca de Cliente por ID", description = "Busca o Cliente na base de dados do sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Retorna Cliente associada ao Id informado."),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "422", description = "Parâmetro não pode ser nulo")})
    @GetMapping(value = "{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
        var client = clientService.getClientById(id);
        return ResponseEntity.ok(client);
    }

    @Operation(summary = "Edita um Cliente", description = "Edita um Cliente na base de dados do sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente editado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado"),
            @ApiResponse(responseCode = "422", description = "Parâmetro não pode ser nulo")})
    @PutMapping(value = "{id}")
    public ResponseEntity<String> updateClient(@PathVariable Long id, @RequestBody @Valid ClientDTO clientDTO) {
        clientService.updateClient(id, clientDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Os dados do cliente foram atualizados!!");
    }

    @Operation(summary = "Deleta um Cliente", description = "Deleta um Cliente na base de dados do sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente deletado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado"),
            @ApiResponse(responseCode = "422", description = "Parâmetro não pode ser nulo")})
    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente excluido!!");
    }
}
