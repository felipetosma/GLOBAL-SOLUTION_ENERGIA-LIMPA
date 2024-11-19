package com.example.energyx.service;

import com.example.energyx.dto.ReatoresDTO;
import com.example.energyx.entity.Reatores;
import com.example.energyx.entity.TipoReator;
import com.example.energyx.entity.LocalizacaoReator;
import com.example.energyx.repository.ReatoresRepository;
import com.example.energyx.repository.TipoReatorRepository;
import com.example.energyx.repository.LocalizacaoReatorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReatoresService {
    @Autowired
    private ReatoresRepository repository;

    @Transactional
    public void insertBatch(List<ReatoresDTO> dtos) {
        for (ReatoresDTO dto : dtos) {
            repository.inserirReator(
                    dto.getNomeReator(),
                    dto.getPressaoMax(),
                    dto.getTemperaturaMax(),
                    dto.getRadiacaoMax(),
                    dto.getFluxoRefrigeracaoMax(),
                    dto.getTipoReatorId(),
                    dto.getLocReatorId()
            );
        }
    }
}