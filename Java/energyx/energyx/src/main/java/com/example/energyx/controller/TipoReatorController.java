package com.example.energyx.controller;

import com.example.energyx.dto.TipoReatorDTO;
import com.example.energyx.service.TipoReatorService;
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
@RequestMapping("/tipo-reator")
public class TipoReatorController {
    @Autowired
    private TipoReatorService service;

    @PostMapping("/batch")
    public ResponseEntity<String> insertBatch(@RequestBody List<TipoReatorDTO> dtos) {
        service.insertBatch(dtos);
        return ResponseEntity.ok("Tipos de reator inseridos com sucesso");
    }
}
