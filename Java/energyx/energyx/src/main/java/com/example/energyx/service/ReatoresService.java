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
    private ReatoresRepository reatoresRepository;

    @Transactional
    public void insertWithProcedure(ReatoresDTO reatorDTO) {
        try {
            reatoresRepository.inserir_reator(
                    reatorDTO.getNomeReator(),
                    reatorDTO.getPressaoMax(),
                    reatorDTO.getTemperaturaMax(),
                    reatorDTO.getRadiacaoMax(),
                    reatorDTO.getFluxoRefrigeracaoMax(),
                    reatorDTO.getTipoReatorId(),
                    reatorDTO.getLocReatorId()
            );
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir reator: " + e.getMessage());
        }
    }
}
