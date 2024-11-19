package com.example.energyx.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReatoresDTO {
    private String nomeReator;
    private Long pressaoMax;
    private Long temperaturaMax;
    private Long radiacaoMax;
    private Long fluxoRefrigeracaoMax;
    private Long tipoReatorId;
    private Long locReatorId;
}