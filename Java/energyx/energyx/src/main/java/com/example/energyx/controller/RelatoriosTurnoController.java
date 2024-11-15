package com.example.energyx.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RelatoriosTurnoController extends RepresentationModel<RelatoriosTurnoController> {

    private Long relatorioTurnoId;
    private Date dataHoraRelatorio;
    private String resumoAtividades;
    private String observacoes;
    private Long operadorId;  // Referência ao id de Operador
    private Long reatorId;  // Referência ao id de TipoReator

}
