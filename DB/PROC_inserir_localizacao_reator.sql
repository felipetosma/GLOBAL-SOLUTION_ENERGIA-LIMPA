CREATE OR REPLACE PROCEDURE inserir_localizacao_reator (
    v_setor     IN gs_el_localizacao_reator.setor%TYPE,
    v_unidade   IN gs_el_localizacao_reator.unidade%TYPE,
    v_descricao IN gs_el_localizacao_reator.descricao%TYPE
) IS
    v_loc_reator_id NUMBER;
BEGIN
    INSERT INTO gs_el_localizacao_reator (
        setor,
        unidade,
        descricao
    ) VALUES (
        v_setor,
        v_unidade,
        v_descricao
    ) RETURNING loc_reator_id INTO v_loc_reator_id;

    dbms_output.put_line('Localização do reator inserida com sucesso.');
    dbms_output.put_line('ID da Localização: ' || v_loc_reator_id);
    dbms_output.put_line('Setor: ' || v_setor);
    dbms_output.put_line('Unidade: ' || v_unidade);
    
    COMMIT;
    
EXCEPTION
    WHEN OTHERS THEN
        dbms_output.put_line('Erro ao inserir localização do reator: ' || SQLERRM);
        ROLLBACK;
END;

