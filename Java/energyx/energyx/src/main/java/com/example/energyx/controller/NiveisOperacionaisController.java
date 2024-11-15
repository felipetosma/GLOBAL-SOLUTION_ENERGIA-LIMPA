package com.example.energyx.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NiveisOperacionaisController extends RepresentationModel<NiveisOperacionaisController> {

    private Long nivelOperacionalId;
    private Timestamp dataHoraMedicao;
    private double pressao;
    private double temperatura;
    private BigDecimal radiacao;
    private Long reatorId;  // Referência ao id da entidade TipoReator

}
