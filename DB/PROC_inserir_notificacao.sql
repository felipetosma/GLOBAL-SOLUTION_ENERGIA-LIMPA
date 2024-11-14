CREATE OR REPLACE PROCEDURE inserir_notificacao (
    v_data_hora_notificacao IN gs_el_notificacoes.data_hora_notificacao%TYPE,
    v_status_notificacao_id IN gs_el_notificacoes.status_notificacao_id%TYPE,
    v_operador_id           IN gs_el_notificacoes.operador_id%TYPE,
    v_reator_id             IN gs_el_notificacoes.reator_id%TYPE
) IS
    v_notificacao_id NUMBER;
BEGIN
    INSERT INTO gs_el_notificacoes (
        data_hora_notificacao,
        status_notificacao_id,
        operador_id,
        reator_id
    ) VALUES (
        v_data_hora_notificacao,
        v_status_notificacao_id,
        v_operador_id,
        v_reator_id
    ) RETURNING notificacao_id INTO v_notificacao_id;

    dbms_output.put_line('Notificação inserida com sucesso. ID: ' || v_notificacao_id);
    dbms_output.put_line('Status ID: ' || v_status_notificacao_id);
    dbms_output.put_line('Operador ID: ' || v_operador_id);
    dbms_output.put_line('Reator ID: ' || v_reator_id);
    
    COMMIT;
    
EXCEPTION
    WHEN OTHERS THEN
        dbms_output.put_line('Erro ao inserir notificação: ' || SQLERRM);
        ROLLBACK;
END;