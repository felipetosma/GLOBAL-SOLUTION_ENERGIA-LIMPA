package com.example.energyx.service;

import com.example.energyx.dto.OperadoresDTO;
import com.example.energyx.repository.OperadoresRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperadoresService {

    @Autowired
    private OperadoresRepository operadoresRepository;

    @Transactional
    public void insertWithProcedure(OperadoresDTO operadoresDTO) {
        try {
            operadoresRepository.inserir_operador(
                    operadoresDTO.getNomeOperador(),
                    operadoresDTO.getSenhaOperador(),
                    operadoresDTO.getCargo(),
                    operadoresDTO.getTurnoId(),
                    operadoresDTO.getLor()
            );
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir operador: " + e.getMessage());
        }
    }
}