CREATE OR REPLACE PROCEDURE inserir_turnos (
    v_descricao_turno IN gs_el_turnos.descricao_turno%TYPE
) IS
BEGIN
    INSERT INTO gs_el_turnos ( descricao_turno ) VALUES ( v_descricao_turno );

EXCEPTION
    WHEN OTHERS THEN
        dbms_output.put_line('Erro ao realizar a operação: ' || sqlerrm);
        RAISE;
END;