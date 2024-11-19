package com.example.energyx.service;

import com.example.energyx.dto.OperadoresDTO;
import com.example.energyx.repository.OperadoresRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperadoresService {
    @Autowired
    private OperadoresRepository repository;

    @Transactional
    public void insertBatch(List<OperadoresDTO> dtos) {
        for (OperadoresDTO dto : dtos) {
            repository.inserirOperador(
                    dto.getNomeOperador(),
                    dto.getSenhaOperador(),
                    dto.getCargo(),
                    dto.getTurnoId(),
                    dto.getLor()
            );
        }
    }
}