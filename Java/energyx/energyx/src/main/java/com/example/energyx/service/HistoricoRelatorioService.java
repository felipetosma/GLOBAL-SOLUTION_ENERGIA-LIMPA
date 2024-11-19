package com.example.energyx.service;

import com.example.energyx.dto.HistoricoRelatorioDTO;
import com.example.energyx.entity.HistoricoRelatorio;
import com.example.energyx.entity.RelatoriosTurno;
import com.example.energyx.repository.HistoricoRelatorioRepository;
import com.example.energyx.repository.RelatoriosTurnoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoricoRelatorioService {
    @Autowired
    private HistoricoRelatorioRepository repository;

    @Transactional
    public void insertBatch(List<HistoricoRelatorioDTO> dtos) {
        for (HistoricoRelatorioDTO dto : dtos) {
            repository.inserirHistoricoRelatorio(
                    dto.getDataHoraAtualizacao(),
                    dto.getObservacoes(),
                    dto.getRelatorioTurnoId()
            );
        }
    }
}
