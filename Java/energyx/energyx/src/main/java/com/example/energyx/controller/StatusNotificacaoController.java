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
public class StatusNotificacaoController extends RepresentationModel<StatusNotificacaoController> {

    private Long statusNotificacaoId;
    private String descrStatus;

}
