package com.example.energyx.repository;

import com.example.energyx.entity.Notificacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface NotificacoesRepository extends JpaRepository<Notificacoes, Long> {
    @Procedure(name = "inserir_notificacao")
    void inserir_notificacao(
            @Param("v_data_hora_notificacao") LocalDateTime dataHoraNotificacao,
            @Param("v_status_notificacao_id") Long statusNotificacaoId,
            @Param("v_operador_id") Long operadorId,
            @Param("v_reator_id") Long reatorId
    );
}