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
    private TipoReatorService tipoReatorService;

    @PostMapping("/withProcedure")
    public ResponseEntity<String> insertTipoReator(@RequestBody @Valid TipoReatorDTO tipoReatorDTO) {
        tipoReatorService.insertWithProcedure(tipoReatorDTO);
        return ResponseEntity.ok("Tipo de reator inserido com sucesso.");
    }
}
