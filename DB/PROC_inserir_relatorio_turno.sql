CREATE OR REPLACE PROCEDURE inserir_relatorio_turno (
    v_data_hora_relatorio IN gs_el_relatorios_turno.data_hora_relatorio%TYPE,
    v_resumo_atividades   IN gs_el_relatorios_turno.resumo_atividades%TYPE,
    v_observacoes         IN gs_el_relatorios_turno.observacoes%TYPE,
    v_operador_id         IN gs_el_relatorios_turno.operador_id%TYPE,
    v_reator_id           IN gs_el_relatorios_turno.reator_id%TYPE
) IS
BEGIN
    INSERT INTO gs_el_relatorios_turno (
        data_hora_relatorio,
        resumo_atividades,
        observacoes,
        operador_id,
        reator_id
    ) VALUES (
        v_data_hora_relatorio,
        v_resumo_atividades,
        v_observacoes,
        v_operador_id,
        v_reator_id
    );

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        dbms_output.put_line('Erro ao realizar a operação: ' || sqlerrm);
        ROLLBACK;
END;