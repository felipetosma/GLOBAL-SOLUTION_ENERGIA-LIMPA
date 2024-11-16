package com.example.energyx.repository;

import com.example.energyx.entity.TipoReator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoReatorRepository extends JpaRepository<TipoReator, Long> {
    @Procedure(name = "inserir_tipo_reator")
    void inserir_tipo_reator(
            @Param("v_descricao_reator") String descricaoReator,
            @Param("v_capacidade_energia") Long capacidadeEnergia,
            @Param("v_tecnologia") String tecnologia,
            @Param("v_fabricante") String fabricante
    );
}