package com.example.energyx.repository;

import com.example.energyx.entity.LocalizacaoReator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizacaoReatorRepository extends JpaRepository<LocalizacaoReator, Long> {
    @Procedure(name = "inserir_localizacao_reator")
    void inserir_localizacao_reator(
            @Param("v_setor") String setor,
            @Param("v_unidade") String unidade,
            @Param("v_descricao") String descricao
    );
}