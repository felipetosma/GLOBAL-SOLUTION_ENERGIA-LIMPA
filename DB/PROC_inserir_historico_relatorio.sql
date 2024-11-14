CREATE OR REPLACE PROCEDURE inserir_historico_relatorio (
    v_data_hora_atualizacao IN gs_el_historico_relatorio.data_hora_atualizacao%TYPE,
    v_observacoes           IN gs_el_historico_relatorio.observacoes%TYPE,
    v_relatorio_turno_id    IN gs_el_historico_relatorio.relatorio_turno_id%TYPE
) IS
BEGIN
    INSERT INTO gs_el_historico_relatorio (
        data_hora_atualizacao,
        observacoes,
        relatorio_turno_id
    ) VALUES (
        v_data_hora_atualizacao,
        v_observacoes,
        v_relatorio_turno_id
    );

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        dbms_output.put_line('Erro ao realizar a operação: ' || sqlerrm);
        ROLLBACK;
END;