package com.example.energyx.service;

import com.example.energyx.dto.RelatoriosTurnoDTO;
import com.example.energyx.entity.RelatoriosTurno;
import com.example.energyx.entity.Operadores;
import com.example.energyx.entity.Reatores;
import com.example.energyx.repository.RelatoriosTurnoRepository;
import com.example.energyx.repository.OperadoresRepository;
import com.example.energyx.repository.ReatoresRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RelatoriosTurnoService {
    @Autowired
    private RelatoriosTurnoRepository relatoriosTurnoRepository;

    @Transactional
    public void insertWithProcedure(RelatoriosTurnoDTO relatoriosTurnoDTO) {
        try {
            relatoriosTurnoRepository.inserir_relatorio_turno(
                    relatoriosTurnoDTO.getDataHoraRelatorio(),
                    relatoriosTurnoDTO.getResumoAtividades(),
                    relatoriosTurnoDTO.getObservacoes(),
                    relatoriosTurnoDTO.getOperadorId(),
                    relatoriosTurnoDTO.getReatorId()
            );
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir relatório de turno: " + e.getMessage());
        }
    }
}