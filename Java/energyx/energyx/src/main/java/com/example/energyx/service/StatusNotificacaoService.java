package com.example.energyx.service;

import com.example.energyx.dto.StatusNotificacaoDTO;
import com.example.energyx.entity.StatusNotificacao;
import com.example.energyx.repository.StatusNotificacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusNotificacaoService {
    @Autowired
    private StatusNotificacaoRepository repository;

    @Transactional
    public void insertBatch(List<StatusNotificacaoDTO> dtos) {
        for (StatusNotificacaoDTO dto : dtos) {
            repository.inserirStatusNotificacao(
                    dto.getDescrStatus()
            );
        }
    }
}
