package com.example.energyx.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "gs_el_reatores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reatores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reator_id")
    private Long reatorId;

    @Column(name = "nome_reator", nullable = false, length = 50)
    private String nomeReator;

    @Column(name = "pressao_max", nullable = false, precision = 20)
    private Long pressaoMax;

    @Column(name = "temperatura_max", nullable = false, precision = 20)
    private Long temperaturaMax;

    @Column(name = "radiacao_max", nullable = false, precision = 20)
    private Long radiacaoMax;

    @Column(name = "fluxo_refrigeracao_max", nullable = false, precision = 20)
    private Long fluxoRefrigeracaoMax;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tipo_reator_id", nullable = false)
    private TipoReator tipoReator;

    @ManyToOne(optional = false)
    @JoinColumn(name = "loc_reator_id", nullable = false)
    private LocalizacaoReator localizacaoReator;
}

