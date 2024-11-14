CREATE OR REPLACE PROCEDURE inserir_historico_notificacao (
    v_data_hora_atualizacao_notif IN gs_el_historico_notificacoes.data_hora_atualizacao_notif%TYPE,
    v_observacao_notificacao      IN gs_el_historico_notificacoes.observacao_notificacao%TYPE,
    v_notificacao_id              IN gs_el_historico_notificacoes.notificacao_id%TYPE
) IS
BEGIN
    INSERT INTO gs_el_historico_notificacoes (
        data_hora_atualizacao_notif,
        observacao_notificacao,
        notificacao_id
    ) VALUES (
        v_data_hora_atualizacao_notif,
        v_observacao_notificacao,
        v_notificacao_id
    );

COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        dbms_output.put_line('Erro ao realizar a operação: ' || sqlerrm);
        ROLLBACK;
END;