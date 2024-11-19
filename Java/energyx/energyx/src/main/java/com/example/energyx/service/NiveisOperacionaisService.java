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
    private NiveisOperacionaisRepository repository;

    @Transactional
    public void insertBatch(List<NiveisOperacionaisDTO> dtos) {
        for (NiveisOperacionaisDTO dto : dtos) {
            repository.inserirNivelOperacional(
                    dto.getDataHoraMedicao(),
                    dto.getPressao(),
                    dto.getTemperatura(),
                    dto.getRadiacao(),
                    dto.getFluxoRefrigeracao(),
                    dto.getReatorId()
            );
        }
    }
}