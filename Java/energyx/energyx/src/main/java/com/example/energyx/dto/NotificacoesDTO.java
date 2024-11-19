package com.example.energyx.dto;

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
public class NotificacoesDTO {
    private LocalDateTime dataHoraNotificacao;
    private Long statusNotificacaoId;
    private Long operadorId;
    private Long reatorId;
}