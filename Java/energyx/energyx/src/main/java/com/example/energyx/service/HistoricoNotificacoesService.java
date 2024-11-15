package com.example.energyx.service;

import com.example.energyx.dto.HistoricoNotificacoesDTO;
import com.example.energyx.repository.HistoricoNotificacoesRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
public class HistoricoNotificacoesService {

    @Autowired
    private HistoricoNotificacoesRepository historicoNotificacoesRepository;

    @Transactional
    public void inserirHistoricoNotificacao(HistoricoNotificacoesDTO historicoDTO) {
        historicoNotificacoesRepository.inserir_historico_notificacao(
                historicoDTO.getDataHoraAtualizacaoNotif(),
                historicoDTO.getObservacaoNotificacao(),
                historicoDTO.getNotificacaoId()
        );
    }
}