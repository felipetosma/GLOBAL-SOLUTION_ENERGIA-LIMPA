package com.example.energyx.repository;

import com.example.energyx.entity.NiveisOperacionais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface NiveisOperacionaisRepository extends JpaRepository<NiveisOperacionais, Long> {
    @Procedure(procedureName = "inserir_nivel_operacional")
    void inserirNivelOperacional(
            @Param("v_data_hora_medicao") Date dataHoraMedicao,
            @Param("v_pressao") Long pressao,
            @Param("v_temperatura") Long temperatura,
            @Param("v_radiacao") Long radiacao,
            @Param("v_fluxo_refrigeracao") Long fluxoRefrigeracao,
            @Param("v_reator_id") Long reatorId
    );
}