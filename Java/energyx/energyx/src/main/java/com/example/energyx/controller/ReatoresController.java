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
    private ReatoresService reatoresService;

    @PostMapping("/withProcedure")
    public ResponseEntity<String> insertReator(@RequestBody @Valid ReatoresDTO reatoresDTO) {
        reatoresService.insertWithProcedure(reatoresDTO);
        return ResponseEntity.ok("Reator inserido com sucesso.");
    }
}
