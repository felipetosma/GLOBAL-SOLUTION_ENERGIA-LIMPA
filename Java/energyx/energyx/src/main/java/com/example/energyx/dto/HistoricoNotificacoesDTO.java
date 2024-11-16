package com.example.energyx.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoricoNotificacoesDTO {
    private Long histNotificacaoId;
    private LocalDateTime  dataHoraAtualizacaoNotif;
    private String observacaoNotificacao;
    private Long notificacaoId;
}