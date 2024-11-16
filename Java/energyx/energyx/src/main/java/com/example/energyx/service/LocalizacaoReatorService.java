package com.example.energyx.service;

import com.example.energyx.dto.LocalizacaoReatorDTO;
import com.example.energyx.entity.LocalizacaoReator;
import com.example.energyx.repository.LocalizacaoReatorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalizacaoReatorService {
    @Autowired
    private LocalizacaoReatorRepository localizacaoReatorRepository;

    @Transactional
    public void insertWithProcedure(LocalizacaoReatorDTO localizacaoReatorDTO) {
        try {
            localizacaoReatorRepository.inserir_localizacao_reator(
                    localizacaoReatorDTO.getSetor(),
                    localizacaoReatorDTO.getUnidade(),
                    localizacaoReatorDTO.getDescricao()
            );
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir localização do reator: " + e.getMessage());
        }
    }
}