package com.example.energyx.controller;

import com.example.energyx.dto.NotificacoesDTO;
import com.example.energyx.service.NotificacoesService;
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
@RequestMapping("/notificacoes")
public class NotificacoesController {
    @Autowired
    private NotificacoesService notificacoesService;

    @PostMapping("/withProcedure")
    public ResponseEntity<String> insertNotificacao(@RequestBody @Valid NotificacoesDTO notificacoesDTO) {
        notificacoesService.insertWithProcedure(notificacoesDTO);
        return ResponseEntity.ok("Notificação inserida com sucesso.");
    }
}