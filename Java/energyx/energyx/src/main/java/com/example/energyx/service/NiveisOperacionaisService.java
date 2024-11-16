package com.example.energyx.service;

import com.example.energyx.dto.NiveisOperacionaisDTO;
import com.example.energyx.entity.NiveisOperacionais;
import com.example.energyx.entity.Reatores;
import com.example.energyx.repository.NiveisOperacionaisRepository;
import com.example.energyx.repository.ReatoresRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NiveisOperacionaisService {
    @Autowired
    private NiveisOperacionaisRepository niveisOperacionaisRepository;

    @Transactional
    public void insertWithProcedure(NiveisOperacionaisDTO niveisOperacionaisDTO) {
        try {
            niveisOperacionaisRepository.inserir_niveis_operacionais(
                    niveisOperacionaisDTO.getDataHoraMedicao(),
                    niveisOperacionaisDTO.getPressao(),
                    niveisOperacionaisDTO.getTemperatura(),
                    niveisOperacionaisDTO.getRadiacao(),
                    niveisOperacionaisDTO.getFluxoRefrigeracao(),
                    niveisOperacionaisDTO.getReatorId()
            );
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir níveis operacionais: " + e.getMessage());
        }
    }
}