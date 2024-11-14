CREATE OR REPLACE PROCEDURE inserir_tipo_reator (
    v_descricao_reator   IN gs_el_tipo_reator.descricao_reator%TYPE,
    v_capacidade_energia IN gs_el_tipo_reator.capacidade_energia%TYPE,
    v_tecnologia         IN gs_el_tipo_reator.tecnologia%TYPE,
    v_fabricante         IN gs_el_tipo_reator.fabricante%TYPE
) IS
BEGIN
    INSERT INTO gs_el_tipo_reator (
        descricao_reator,
        capacidade_energia,
        tecnologia,
        fabricante
    ) VALUES (
        v_descricao_reator,
        v_capacidade_energia,
        v_tecnologia,
        v_fabricante
    );

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        dbms_output.put_line('Erro ao realizar a operação: ' || sqlerrm);
        ROLLBACK;
END;