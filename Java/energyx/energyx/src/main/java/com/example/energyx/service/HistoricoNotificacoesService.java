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
    private HistoricoNotificacoesRepository repository;

    @Transactional
    public void insertBatch(List<HistoricoNotificacoesDTO> dtos) {
        for (HistoricoNotificacoesDTO dto : dtos) {
            repository.inserirHistoricoNotificacao(
                    dto.getDataHoraAtualizacaoNotif(),
                    dto.getObservacaoNotificacao(),
                    dto.getNotificacaoId()
            );
        }
    }
}