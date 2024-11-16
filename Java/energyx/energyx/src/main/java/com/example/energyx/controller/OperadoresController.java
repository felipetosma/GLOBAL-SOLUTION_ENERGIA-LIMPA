package com.example.energyx.controller;

import com.example.energyx.dto.OperadoresDTO;
import com.example.energyx.service.OperadoresService;
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
@RequestMapping("/operadores")
public class OperadoresController {

    @Autowired
    private OperadoresService operadoresService;

    @PostMapping("/withProcedure")
    public ResponseEntity<String> insertOperador(@RequestBody @Valid OperadoresDTO operadoresDTO) {
        operadoresService.insertWithProcedure(operadoresDTO);
        return ResponseEntity.ok("Operador inserido com sucesso.");
    }

}