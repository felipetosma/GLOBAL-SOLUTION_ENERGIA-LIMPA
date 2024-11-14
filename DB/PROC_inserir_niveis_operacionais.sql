CREATE OR REPLACE PROCEDURE inserir_niveis_operacionais (
    v_data_hora_medicao    IN gs_el_niveis_operacionais.data_hora_medicao%TYPE,
    v_pressao              IN gs_el_niveis_operacionais.pressao%TYPE,
    v_temperatura          IN gs_el_niveis_operacionais.temperatura%TYPE,
    v_radiacao             IN gs_el_niveis_operacionais.radiacao%TYPE,
    v_fluxo_refrigeracao   IN gs_el_niveis_operacionais.fluxo_refrigeracao%TYPE,
    v_reator_id            IN gs_el_niveis_operacionais.reator_id%TYPE
) IS
    v_status VARCHAR2(100);
BEGIN
    INSERT INTO gs_el_niveis_operacionais (
        data_hora_medicao,
        pressao,
        temperatura,
        radiacao,
        fluxo_refrigeracao,
        reator_id
    ) VALUES (
        v_data_hora_medicao,
        v_pressao,
        v_temperatura,
        v_radiacao,
        v_fluxo_refrigeracao,
        v_reator_id
    );

    v_status := verificar_niveis_reator(v_reator_id);

    dbms_output.put_line('Níveis operacionais inseridos com sucesso.');
    dbms_output.put_line('Status dos Níveis: ' || v_status);
    
    COMMIT;
    
EXCEPTION
    WHEN OTHERS THEN
        dbms_output.put_line('Erro ao realizar a operação: ' || SQLERRM);
        ROLLBACK;
END;