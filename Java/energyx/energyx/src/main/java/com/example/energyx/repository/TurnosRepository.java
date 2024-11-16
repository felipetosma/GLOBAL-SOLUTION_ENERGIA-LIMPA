package com.example.energyx.repository;

import com.example.energyx.entity.Turnos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TurnosRepository extends JpaRepository<Turnos, Long> {
    @Procedure(name = "inserir_turno")
    void inserir_turno(
            @Param("v_data_inicio") Date dataInicio,
            @Param("v_data_fim") Date dataFim
    );
}