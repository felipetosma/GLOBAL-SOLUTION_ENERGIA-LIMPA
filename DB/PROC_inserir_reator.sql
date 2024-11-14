CREATE OR REPLACE PROCEDURE inserir_reator (
    v_nome_reator     IN gs_el_reatores.nome_reator%TYPE,
    v_pressao_max     IN gs_el_reatores.pressao_max%TYPE,
    v_temperatura_max IN gs_el_reatores.temperatura_max%TYPE,
    v_radiacao_max    IN gs_el_reatores.radiacao_max%TYPE,
    v_tipo_reator_id  IN gs_el_reatores.tipo_reator_id%TYPE,
    v_loc_reator_id   IN gs_el_reatores.loc_reator_id%TYPE
) IS
    v_reator_id NUMBER;
    v_status VARCHAR2(100);
BEGIN
    INSERT INTO gs_el_reatores (
        nome_reator,
        pressao_max,
        temperatura_max,
        radiacao_max,
        tipo_reator_id,
        loc_reator_id
    ) VALUES (
        v_nome_reator,
        v_pressao_max,
        v_temperatura_max,
        v_radiacao_max,
        v_tipo_reator_id,
        v_loc_reator_id
    ) RETURNING reator_id INTO v_reator_id;

    v_status := verificar_niveis_reator(v_reator_id);

    dbms_output.put_line('Reator inserido com sucesso. ID: ' || v_reator_id);
    dbms_output.put_line('Status da Validação: ' || v_status);
    
    COMMIT;
    
EXCEPTION
    WHEN OTHERS THEN
        dbms_output.put_line('Erro ao realizar a operação: ' || SQLERRM);
        ROLLBACK;
END;