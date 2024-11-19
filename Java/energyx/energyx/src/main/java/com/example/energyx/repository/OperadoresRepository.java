package com.example.energyx.repository;

import com.example.energyx.entity.Operadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OperadoresRepository extends JpaRepository<Operadores, Long> {
    @Procedure(procedureName = "inserir_operador")
    void inserirOperador(
            @Param("v_nome_operador") String nomeOperador,
            @Param("v_senha_operador") String senhaOperador,
            @Param("v_cargo") String cargo,
            @Param("v_turno_id") Long turnoId,
            @Param("v_lor") String lor
    );
}
