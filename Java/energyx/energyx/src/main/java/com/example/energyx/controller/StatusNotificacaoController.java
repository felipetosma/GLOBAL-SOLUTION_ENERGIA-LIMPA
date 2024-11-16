package com.example.energyx.controller;

import com.example.energyx.dto.StatusNotificacaoDTO;
import com.example.energyx.service.StatusNotificacaoService;
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
@RequestMapping("/status-notificacao")
public class StatusNotificacaoController {
    @Autowired
    private StatusNotificacaoService statusNotificacaoService;

    @PostMapping("/withProcedure")
    public ResponseEntity<String> insertStatusNotificacao(@RequestBody @Valid StatusNotificacaoDTO statusNotificacaoDTO) {
        statusNotificacaoService.insertWithProcedure(statusNotificacaoDTO);
        return ResponseEntity.ok("Status de notificação inserido com sucesso.");
    }
}