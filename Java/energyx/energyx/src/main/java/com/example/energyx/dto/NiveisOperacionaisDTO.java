package com.example.energyx.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NiveisOperacionaisDTO {
    private Date dataHoraMedicao;
    private Long pressao;
    private Long temperatura;
    private Long radiacao;
    private Long fluxoRefrigeracao;
    private Long reatorId;
}