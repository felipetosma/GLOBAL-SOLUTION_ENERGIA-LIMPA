package com.example.energyx.dto;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoNotificacoesDTO {
    private Long histNotificacaoId;
    private Timestamp dataHoraAtualizacaoNotif;
    private String observacaoNotificacao;
    private Long notificacaoId;
}
