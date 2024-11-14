CREATE OR REPLACE PROCEDURE inserir_turnos (
    v_data_inicio IN gs_el_turnos.data_inicio%TYPE,
    v_data_fim    IN gs_el_turnos.data_fim%TYPE
) IS
BEGIN
    INSERT INTO gs_el_turnos (
        data_inicio,
        data_fim
    ) VALUES (
        v_data_inicio,
        v_data_fim
    );

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        dbms_output.put_line('Erro ao realizar a operação: ' || sqlerrm);
        ROLLBACK;
END;