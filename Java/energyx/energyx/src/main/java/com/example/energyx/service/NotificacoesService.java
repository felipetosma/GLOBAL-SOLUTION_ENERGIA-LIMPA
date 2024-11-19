package com.example.energyx.service;

import com.example.energyx.dto.NotificacoesDTO;
import com.example.energyx.entity.Notificacoes;
import com.example.energyx.entity.Operadores;
import com.example.energyx.entity.Reatores;
import com.example.energyx.entity.StatusNotificacao;
import com.example.energyx.repository.NotificacoesRepository;
import com.example.energyx.repository.OperadoresRepository;
import com.example.energyx.repository.ReatoresRepository;
import com.example.energyx.repository.StatusNotificacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificacoesService {
    @Autowired
    private NotificacoesRepository repository;

    @Transactional
    public void insertBatch(List<NotificacoesDTO> dtos) {
        for (NotificacoesDTO dto : dtos) {
            repository.inserirNotificacao(
                    dto.getDataHoraNotificacao(),
                    dto.getStatusNotificacaoId(),
                    dto.getOperadorId(),
                    dto.getReatorId()
            );
        }
    }
}