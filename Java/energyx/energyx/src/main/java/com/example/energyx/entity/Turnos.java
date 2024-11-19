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
@Table(name = "gs_el_turnos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Turnos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "turno_id")
    private Long turnoId;

    @Column(name = "descricao_turno", nullable = false, length = 50)
    @NotBlank(message = "A descrição do turno é obrigatória")
    private String descricaoTurno;
}