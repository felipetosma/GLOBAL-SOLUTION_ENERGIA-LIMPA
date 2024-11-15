package com.example.energyx.repository;

import com.example.energyx.entity.HistoricoNotificacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface HistoricoNotificacoesRepository extends JpaRepository<HistoricoNotificacoes, Long> {

    @Procedure(name = "inserir_historico_notificacao")
    void inserir_historico_notificacao(
            @Param("p_data_hora_atualizacao_notif") Timestamp dataHoraAtualizacao,
            @Param("p_observacao_notificacao") String observacaoNotificacao,
            @Param("p_notificacao_id") Long notificacaoId
    );
}
