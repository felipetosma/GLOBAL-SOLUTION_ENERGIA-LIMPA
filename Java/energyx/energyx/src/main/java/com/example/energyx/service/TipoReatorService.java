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
    private TipoReatorRepository tipoReatorRepository;

    @Transactional
    public void insertWithProcedure(TipoReatorDTO tipoReatorDTO) {
        try {
            tipoReatorRepository.inserir_tipo_reator(
                    tipoReatorDTO.getDescricaoReator(),
                    tipoReatorDTO.getCapacidadeEnergia(),
                    tipoReatorDTO.getTecnologia(),
                    tipoReatorDTO.getFabricante()
            );
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir tipo de reator: " + e.getMessage());
        }
    }
}