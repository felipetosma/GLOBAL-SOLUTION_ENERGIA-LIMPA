package com.example.energyx.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "gs_el_niveis_operacionais")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NiveisOperacionais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nivel_operacional_id")
    private Long nivelOperacionalId;

    @Column(name = "data_hora_medicao", nullable = false)
    private Date dataHoraMedicao;

    @Column(name = "pressao", nullable = false, precision = 20)
    private Long pressao;

    @Column(name = "temperatura", nullable = false, precision = 20)
    private Long temperatura;

    @Column(name = "radiacao", nullable = false, precision = 20)
    private Long radiacao;

    @Column(name = "fluxo_refrigeracao", nullable = false, precision = 20)
    private Long fluxoRefrigeracao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "reator_id", nullable = false)
    private Reatores reator;
}