CREATE OR REPLACE PROCEDURE inserir_operador (
    v_nome_operador  IN gs_el_operadores.nome_operador%TYPE,
    v_senha_operador IN gs_el_operadores.senha_operador%TYPE,
    v_cargo          IN gs_el_operadores.cargo%TYPE,
    v_turno_id       IN gs_el_operadores.turno_id%TYPE,
    v_lor            IN gs_el_operadores.lor%TYPE
) IS
    v_licenca_status VARCHAR2(50);
BEGIN
    INSERT INTO gs_el_operadores (
        nome_operador,
        senha_operador,
        cargo,
        turno_id,
        lor
    ) VALUES (
        v_nome_operador,
        v_senha_operador,
        v_cargo,
        v_turno_id,
        v_lor
    );

    v_licenca_status := validar_licenca_operador(v_lor);
    IF v_licenca_status != 'Licença Válida' THEN
        dbms_output.put_line('Erro: ' || v_licenca_status);
        RETURN;
    END IF;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        dbms_output.put_line('Erro ao realizar a operação: ' || sqlerrm);
        ROLLBACK;
END;
