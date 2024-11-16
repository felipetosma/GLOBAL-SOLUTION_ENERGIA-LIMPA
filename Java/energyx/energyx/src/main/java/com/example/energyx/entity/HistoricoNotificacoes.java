package com.example.energyx.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "gs_el_historico_notificacoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoricoNotificacoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hist_notificacao_id")
    private Long histNotificacaoId;

    @Column(name = "data_hora_atualizacao_notif", nullable = false)
    private LocalDateTime  dataHoraAtualizacaoNotif;

    @Column(name = "observacao_notificacao", length = 250)
    private String observacaoNotificacao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "notificacao_id", nullable = false)
    private Notificacoes notificacao;
}