package com.example.energyx.repository;

import com.example.energyx.entity.HistoricoRelatorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;

@Repository
public interface HistoricoRelatorioRepository extends JpaRepository<HistoricoRelatorio, Long> {
    @Procedure(name = "inserir_historico_relatorio")
    void inserir_historico_relatorio(
            @Param("v_data_hora_atualizacao") LocalDateTime dataHoraAtualizacao,
            @Param("v_observacoes") String observacoes,
            @Param("v_relatorio_turno_id") Long relatorioTurnoId
    );
}