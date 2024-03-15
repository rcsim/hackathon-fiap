package com.postech30.hackathon.controller;

import com.postech30.hackathon.dto.LocationDTO;
import com.postech30.hackathon.entity.Additional;
import com.postech30.hackathon.entity.Location;
import com.postech30.hackathon.service.LocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping
    @Operation(summary = "Adicionar um novo serviço.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Location.class))}),
            @ApiResponse(responseCode = "201", description = "Recurso executado com sucesso.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Requisição inválida.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "401", description = "Não autorizado.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "403", description = "Acesso proibido.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<LocationDTO> createLocation(@RequestBody LocationDTO locationDTO) {
        LocationDTO createdLocation = locationService.createLocation(locationDTO);
        return ResponseEntity.ok(createdLocation);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um serviço.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Location.class))}),
            @ApiResponse(responseCode = "201", description = "Recurso executado com sucesso.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Requisição inválida.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "401", description = "Não autorizado.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "403", description = "Acesso proibido.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<LocationDTO> updateLocation(@PathVariable String id, @RequestBody LocationDTO locationDTO) {
        LocationDTO updatedLocation = locationService.updateLocation(id, locationDTO);
        return ResponseEntity.ok(updatedLocation);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um serviço.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Location.class))}),
            @ApiResponse(responseCode = "201", description = "Recurso executado com sucesso.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Requisição inválida.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "401", description = "Não autorizado.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "403", description = "Acesso proibido.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<Void> deleteLocation(@PathVariable String id) {
        locationService.deleteLocation(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar serviço por id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Location.class))}),
            @ApiResponse(responseCode = "201", description = "Recurso executado com sucesso.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Requisição inválida.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "401", description = "Não autorizado.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "403", description = "Acesso proibido.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<LocationDTO> getLocationById(@PathVariable String id) {
        LocationDTO location = locationService.getLocationById(id);
        return ResponseEntity.ok(location);
    }

    @GetMapping
    @Operation(summary = "Listar todos os serviços.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Location.class))}),
            @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Requisição inválida.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "401", description = "Não autorizado.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "403", description = "Acesso proibido.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<List<LocationDTO>> getAllLocations() {
        List<LocationDTO> locations = locationService.getAllLocations();
        return ResponseEntity.ok(locations);
    }
}
