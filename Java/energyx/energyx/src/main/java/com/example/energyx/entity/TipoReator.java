package com.example.energyx.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "gs_el_tipo_reator")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoReator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_reator_id")
    private Long tipoReatorId;

    @Column(name = "descricao_reator", nullable = false, length = 200)
    private String descricaoReator;

    @Column(name = "capacidade_energia", nullable = false, precision = 30)
    private Long capacidadeEnergia;

    @Column(name = "tecnologia", nullable = false, length = 50)
    private String tecnologia;

    @Column(name = "fabricante", nullable = false, length = 50)
    private String fabricante;
}