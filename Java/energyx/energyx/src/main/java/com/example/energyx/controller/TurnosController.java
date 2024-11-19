package com.example.energyx.controller;

import com.example.energyx.dto.TurnosDTO;
import com.example.energyx.service.TurnosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/turnos")
public class TurnosController {
    @Autowired
    private TurnosService turnosService;

   // Novo endpoint para inserção em lote
    @PostMapping("/batch")
    public ResponseEntity<String> insertTurnosBatch(@RequestBody @Valid List<TurnosDTO> turnosDTO) {
        turnosService.insertBatch(turnosDTO);
        return ResponseEntity.ok("Turnos inseridos com sucesso.");
    }
}