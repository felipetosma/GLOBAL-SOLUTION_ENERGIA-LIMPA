package com.example.energyx.service;

import com.example.energyx.dto.TurnosDTO;
import com.example.energyx.entity.Turnos;
import com.example.energyx.repository.TurnosRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TurnosService {
    @Autowired
    private TurnosRepository turnosRepository;

    @Transactional
    public void insertWithProcedure(TurnosDTO turnosDTO) {
        try {
            turnosRepository.inserir_turno(
                    turnosDTO.getDataInicio(),
                    turnosDTO.getDataFim()
            );
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir turno: " + e.getMessage());
        }
    }
}