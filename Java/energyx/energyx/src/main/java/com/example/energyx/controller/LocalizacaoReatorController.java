package com.example.energyx.controller;

import com.example.energyx.dto.LocalizacaoReatorDTO;
import com.example.energyx.service.LocalizacaoReatorService;
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
@RequestMapping("/localizacao-reator")
public class LocalizacaoReatorController {
    @Autowired
    private LocalizacaoReatorService service;

    @PostMapping("/batch")
    public ResponseEntity<String> insertBatch(@RequestBody List<LocalizacaoReatorDTO> dtos) {
        service.insertBatch(dtos);
        return ResponseEntity.ok("Localizações de reator inseridas com sucesso");
    }
}