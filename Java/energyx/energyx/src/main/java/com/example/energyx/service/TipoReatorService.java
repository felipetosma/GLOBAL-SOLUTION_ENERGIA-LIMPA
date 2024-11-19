package com.example.energyx.service;

import com.example.energyx.dto.TipoReatorDTO;
import com.example.energyx.entity.TipoReator;
import com.example.energyx.repository.TipoReatorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoReatorService {
    @Autowired
    private TipoReatorRepository repository;

    @Transactional
    public void insertBatch(List<TipoReatorDTO> dtos) {
        for (TipoReatorDTO dto : dtos) {
            repository.inserirTipoReator(
                    dto.getDescricaoReator(),
                    dto.getCapacidadeEnergia(),
                    dto.getTecnologia(),
                    dto.getFabricante()
            );
        }
    }
}