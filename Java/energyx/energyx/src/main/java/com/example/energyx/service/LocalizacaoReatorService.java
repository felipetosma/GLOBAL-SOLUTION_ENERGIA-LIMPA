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
    private LocalizacaoReatorRepository repository;

    @Transactional
    public void insertBatch(List<LocalizacaoReatorDTO> dtos) {
        for (LocalizacaoReatorDTO dto : dtos) {
            repository.inserirLocalizacaoReator(
                    dto.getSetor(),
                    dto.getUnidade(),
                    dto.getDescricao()
            );
        }
    }
}