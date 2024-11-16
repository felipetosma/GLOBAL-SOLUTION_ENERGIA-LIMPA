package com.example.energyx.controller;

import com.example.energyx.dto.RelatoriosTurnoDTO;
import com.example.energyx.service.RelatoriosTurnoService;
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
@RequestMapping("/relatorios-turno")
public class RelatoriosTurnoController {
    @Autowired
    private RelatoriosTurnoService relatoriosTurnoService;

    @PostMapping("/withProcedure")
    public ResponseEntity<String> insertRelatorioTurno(@RequestBody @Valid RelatoriosTurnoDTO relatoriosTurnoDTO) {
        relatoriosTurnoService.insertWithProcedure(relatoriosTurnoDTO);
        return ResponseEntity.ok("Relatório de turno inserido com sucesso.");
    }
}