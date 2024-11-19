package com.example.energyx.repository;

import com.example.energyx.entity.HistoricoNotificacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;

@Repository
public interface HistoricoNotificacoesRepository extends JpaRepository<HistoricoNotificacoes, Long> {
    @Procedure(procedureName = "inserir_historico_notificacao")
    void inserirHistoricoNotificacao(
            @Param("v_data_hora_atualizacao_notif") LocalDateTime dataHoraAtualizacaoNotif,
            @Param("v_observacao_notificacao") String observacaoNotificacao,
            @Param("v_notificacao_id") Long notificacaoId
    );
}