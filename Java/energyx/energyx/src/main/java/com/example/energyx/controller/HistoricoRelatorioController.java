package com.example.energyx.controller;

import com.example.energyx.dto.HistoricoRelatorioDTO;
import com.example.energyx.service.HistoricoRelatorioService;
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
@RequestMapping("/historico-relatorio")
public class HistoricoRelatorioController {
    @Autowired
    private HistoricoRelatorioService historicoRelatorioService;

    @PostMapping("/withProcedure")
    public ResponseEntity<String> insertHistoricoRelatorio(@RequestBody @Valid HistoricoRelatorioDTO historicoRelatorioDTO) {
        historicoRelatorioService.insertWithProcedure(historicoRelatorioDTO);
        return ResponseEntity.ok("Histórico de relatório inserido com sucesso.");
    }
}