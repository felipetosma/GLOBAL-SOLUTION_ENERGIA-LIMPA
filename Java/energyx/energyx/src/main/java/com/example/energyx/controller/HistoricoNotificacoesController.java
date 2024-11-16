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
    private HistoricoNotificacoesService historicoNotificacoesService;

    @PostMapping("/withProcedure")
    public ResponseEntity<String> insertHistoricoNotificacao(@RequestBody @Valid HistoricoNotificacoesDTO historicoNotificacoesDTO) {
        historicoNotificacoesService.insertWithProcedure(historicoNotificacoesDTO);
        return ResponseEntity.ok("Histórico de notificação inserido com sucesso.");
    }
}