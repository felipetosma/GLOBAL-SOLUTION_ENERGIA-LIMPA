package com.example.energyx.repository;

import com.example.energyx.entity.RelatoriosTurno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface RelatoriosTurnoRepository extends JpaRepository<RelatoriosTurno, Long> {
    @Procedure(procedureName = "inserir_relatorio_turno")
    void inserirRelatorioTurno(
            @Param("v_data_hora_relatorio") Date dataHoraRelatorio,
            @Param("v_resumo_atividades") String resumoAtividades,
            @Param("v_observacoes") String observacoes,
            @Param("v_operador_id") Long operadorId,
            @Param("v_reator_id") Long reatorId
    );
}