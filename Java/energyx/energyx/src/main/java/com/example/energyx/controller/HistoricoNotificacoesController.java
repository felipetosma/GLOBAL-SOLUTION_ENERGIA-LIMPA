package com.example.energyx.controller;

import com.example.energyx.dto.HistoricoNotificacoesDTO;
import com.example.energyx.service.HistoricoNotificacoesService;
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
@RequestMapping("/historico-notificacoes")
public class HistoricoNotificacoesController {
    @Autowired
    private HistoricoNotificacoesService service;

    @PostMapping("/batch")
    public ResponseEntity<String> insertBatch(@RequestBody List<HistoricoNotificacoesDTO> dtos) {
        service.insertBatch(dtos);
        return ResponseEntity.ok("Históricos de notificações inseridos com sucesso");
    }
}