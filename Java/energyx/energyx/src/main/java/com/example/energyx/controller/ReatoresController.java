package com.example.energyx.controller;

import com.example.energyx.dto.ReatoresDTO;
import com.example.energyx.service.ReatoresService;
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
@RequestMapping("/reatores")
public class ReatoresController {
    @Autowired
    private ReatoresService service;

    @PostMapping("/batch")
    public ResponseEntity<String> insertBatch(@RequestBody List<ReatoresDTO> dtos) {
        service.insertBatch(dtos);
        return ResponseEntity.ok("Reatores inseridos com sucesso");
    }
}
