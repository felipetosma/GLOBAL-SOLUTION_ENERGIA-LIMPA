package com.example.energyx.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "gs_el_historico_relatorio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoricoRelatorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hist_relatorio_id")
    private Long histRelatorioId;

    @Column(name = "data_hora_atualizacao", nullable = false)
    private LocalDateTime dataHoraAtualizacao;

    @Column(name = "observacoes", length = 150)
    private String observacoes;

    @ManyToOne(optional = false)
    @JoinColumn(name = "relatorio_turno_id", nullable = false)
    private RelatoriosTurno relatorioTurno;
}