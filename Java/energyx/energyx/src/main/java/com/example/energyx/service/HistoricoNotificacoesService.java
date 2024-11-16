package com.example.energyx.service;

import com.example.energyx.dto.HistoricoNotificacoesDTO;
import com.example.energyx.entity.HistoricoNotificacoes;
import com.example.energyx.entity.Notificacoes;
import com.example.energyx.repository.HistoricoNotificacoesRepository;
import com.example.energyx.repository.NotificacoesRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoricoNotificacoesService {
    @Autowired
    private HistoricoNotificacoesRepository historicoNotificacoesRepository;

    @Transactional
    public void insertWithProcedure(HistoricoNotificacoesDTO historicoNotificacoesDTO) {
        try {
            historicoNotificacoesRepository.inserir_historico_notificacao(
                    historicoNotificacoesDTO.getDataHoraAtualizacaoNotif(),
                    historicoNotificacoesDTO.getObservacaoNotificacao(),
                    historicoNotificacoesDTO.getNotificacaoId()
            );
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir histórico de notificação: " + e.getMessage());
        }
    }
}
