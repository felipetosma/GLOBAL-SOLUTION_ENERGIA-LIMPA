CREATE OR REPLACE PROCEDURE inserir_status_notificacao(
    v_descr_status IN gs_el_status_notificacao.descr_status%TYPE
) IS
BEGIN
    INSERT INTO gs_el_status_notificacao (
        descr_status
    ) VALUES (
        v_descr_status
    );
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Erro ao realizar a operação: ' || SQLERRM);
        ROLLBACK;
END;