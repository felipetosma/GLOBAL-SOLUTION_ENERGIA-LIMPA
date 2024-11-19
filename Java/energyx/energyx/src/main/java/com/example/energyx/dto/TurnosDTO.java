package com.example.energyx.dto;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurnosDTO {
    private String descricaoTurno;
}