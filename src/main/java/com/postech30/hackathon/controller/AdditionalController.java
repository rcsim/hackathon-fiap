package com.postech30.hackathon.controller;

import com.postech30.hackathon.dto.AdditionalDTO;
import com.postech30.hackathon.entity.Additional;
import com.postech30.hackathon.exceptions.AdditionalNotFoundException;
import com.postech30.hackathon.service.AdditionalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/additional")
@Transactional
public class AdditionalController {

    private final AdditionalService additionalService;

    public AdditionalController(AdditionalService additionalService) {
        this.additionalService = additionalService;
    }

    @PostMapping("/service")
    @Operation(summary = "Adicionar um novo serviço.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Additional.class))}),
            @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Requisição inválida.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "401", description = "Não autorizado.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "403", description = "Acesso proibido.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<AdditionalDTO> addServices(@Valid @RequestBody AdditionalDTO additionalDTO) {
        var servicesSave = additionalService.createServices(additionalDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(servicesSave);
    }

    @PostMapping("/item")
    @Operation(summary = "Adicionar um novo item.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Additional.class))}),
            @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Requisição inválida.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "401", description = "Não autorizado.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "403", description = "Acesso proibido.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<AdditionalDTO> addItems(@Valid @RequestBody AdditionalDTO additionalDTO) {
        var itemsSave = additionalService.createItens(additionalDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(itemsSave);
    }

    @GetMapping
    @Operation(summary = "Listar todos os serviços.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Additional.class))}),
            @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Requisição inválida.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "401", description = "Não autorizado.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "403", description = "Acesso proibido.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<Page<AdditionalDTO>> findAll(@RequestParam(defaultValue = "") String searchServices, Pageable pageable) {
        Page<AdditionalDTO> servicesPage = additionalService.getServices(searchServices, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(servicesPage);
    }

    @GetMapping(value = "{id}")
    @Operation(summary = "Listar serviço cadastrado pelo Id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Additional.class))}),
            @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Requisição inválida.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "401", description = "Não autorizado.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "403", description = "Acesso proibido.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<AdditionalDTO> findById(@PathVariable Long id) throws AdditionalNotFoundException {
        var services = additionalService.getServicesById(id);
        return ResponseEntity.ok(services);
    }

    @PutMapping(value = "{id}")
    @Operation(summary = "Atualizar serviço cadastrado pelo Id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Additional.class))}),
            @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Requisição inválida.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "401", description = "Não autorizado.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "403", description = "Acesso proibido.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<String> updateServices(@PathVariable Long id, @RequestBody @Valid AdditionalDTO additionalDTO) throws AdditionalNotFoundException {
        additionalService.updateServices(id, additionalDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Os dados do serviço foram atualizados!!");
    }

    @DeleteMapping(value = "{id}")
    @Operation(summary = "Excluir serviço cadastrado pelo Id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Additional.class))}),
            @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Requisição inválida.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "401", description = "Não autorizado.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "403", description = "Acesso proibido.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<String> deleteServices(@PathVariable Long id) throws AdditionalNotFoundException {
        additionalService.deleteServices(id);
        return ResponseEntity.status(HttpStatus.OK).body("Serviço excluído!!");
    }
}
