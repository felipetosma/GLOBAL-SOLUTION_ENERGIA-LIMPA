package com.example.energyx.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "gs_el_relatorios_turno")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RelatoriosTurno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "relatorio_turno_id")
    private Long relatorioTurnoId;

    @Column(name = "data_hora_relatorio", nullable = false)
    private Date dataHoraRelatorio;

    @Column(name = "resumo_atividades", nullable = false, length = 200)
    private String resumoAtividades;

    @Column(name = "observacoes", length = 300)
    private String observacoes;

    @ManyToOne(optional = false)
    @JoinColumn(name = "operador_id", nullable = false)
    private Operadores operador;

    @ManyToOne(optional = false)
    @JoinColumn(name = "reator_id", nullable = false)
    private Reatores reator;
}