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

    @PostMapping("/withProcedure")
    public ResponseEntity<String> insertTurno(@RequestBody @Valid TurnosDTO turnosDTO) {
        turnosService.insertWithProcedure(turnosDTO);
        return ResponseEntity.ok("Turno inserido com sucesso.");
    }
}