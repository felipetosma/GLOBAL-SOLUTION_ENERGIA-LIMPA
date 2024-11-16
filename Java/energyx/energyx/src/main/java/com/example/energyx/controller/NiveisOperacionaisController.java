package com.example.energyx.controller;

import com.example.energyx.dto.NiveisOperacionaisDTO;
import com.example.energyx.service.NiveisOperacionaisService;
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
@RequestMapping("/niveis-operacionais")
public class NiveisOperacionaisController {
    @Autowired
    private NiveisOperacionaisService niveisOperacionaisService;

    @PostMapping("/withProcedure")
    public ResponseEntity<String> insertNiveisOperacionais(@RequestBody @Valid NiveisOperacionaisDTO niveisOperacionaisDTO) {
        niveisOperacionaisService.insertWithProcedure(niveisOperacionaisDTO);
        return ResponseEntity.ok("Níveis operacionais inseridos com sucesso.");
    }
}