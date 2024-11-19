package com.example.energyx.repository;

import com.example.energyx.entity.Reatores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReatoresRepository extends JpaRepository<Reatores, Long> {
    @Procedure(procedureName = "inserir_reator")
    void inserirReator(
            @Param("v_nome_reator") String nomeReator,
            @Param("v_pressao_max") Long pressaoMax,
            @Param("v_temperatura_max") Long temperaturaMax,
            @Param("v_radiacao_max") Long radiacaoMax,
            @Param("v_fluxo_refrigeracao_max") Long fluxoRefrigeracaoMax,
            @Param("v_tipo_reator_id") Long tipoReatorId,
            @Param("v_loc_reator_id") Long locReatorId
    );
}