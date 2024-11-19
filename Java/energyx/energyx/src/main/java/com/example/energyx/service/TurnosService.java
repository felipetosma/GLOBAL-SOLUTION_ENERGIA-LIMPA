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
    private TurnosRepository repository;

    @Transactional
    public void insertBatch(List<TurnosDTO> dtos) {
        for (TurnosDTO dto : dtos) {
            repository.inserirTurno(dto.getDescricaoTurno());
        }
    }
}