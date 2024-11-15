package com.example.energyx.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocalizacaoReatorController extends RepresentationModel<LocalizacaoReatorController> {

    private Long locReatorId;
    private String setor;
    private String unidade;
    private String descricao;

}
