package com.example.energyx.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificacoesController extends RepresentationModel<NotificacoesController> {

    private Long notificacaoId;
    private LocalDateTime dataHoraNotificacao;
    private Long statusNotificacaoId;  // Referência ao id de StatusNotificacao
    private Long operadorId;  // Referência ao id de Operadores
    private Long reatorId;  // Referência ao id de Reatores

}