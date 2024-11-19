package com.example.energyx.repository;

import com.example.energyx.entity.StatusNotificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusNotificacaoRepository extends JpaRepository<StatusNotificacao, Long> {
    @Procedure(procedureName = "inserir_status_notificacao")
    void inserirStatusNotificacao(
            @Param("v_descr_status") String descrStatus
    );
}