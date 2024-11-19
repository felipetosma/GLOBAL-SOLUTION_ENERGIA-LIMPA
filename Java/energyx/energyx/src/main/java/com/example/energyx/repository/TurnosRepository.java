package com.example.energyx.repository;

import com.example.energyx.entity.Turnos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;


@Repository
public interface TurnosRepository extends JpaRepository<Turnos, Long> {
    @Procedure(procedureName = "inserir_turnos")
    void inserirTurno(
            @Param("v_descricao_turno") String descricaoTurno
    );
}