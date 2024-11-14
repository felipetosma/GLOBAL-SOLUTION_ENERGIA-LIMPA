/*
Esta função valida se os níveis de operação (pressão, temperatura e radiação) estão dentro dos limites aceitáveis para cada reator,
conforme especificado na tabela gs_el_reatores.
*/

CREATE OR REPLACE FUNCTION verificar_niveis_reator(p_reator_id NUMBER)
RETURN VARCHAR2 IS
    ver_pressao_max       gs_el_reatores.pressao_max%TYPE;
    ver_temperatura_max   gs_el_reatores.temperatura_max%TYPE;
    ver_radiacao_max      gs_el_reatores.radiacao_max%TYPE;
    ver_pressao           gs_el_niveis_operacionais.pressao%TYPE;
    ver_temperatura       gs_el_niveis_operacionais.temperatura%TYPE;
    ver_radiacao          gs_el_niveis_operacionais.radiacao%TYPE;
    ver_fluxo_refrigeracao gs_el_niveis_operacionais.fluxo_refrigeracao%TYPE;

    ver_status           VARCHAR2(100);
    ver_detalhes         VARCHAR2(500);
BEGIN
    BEGIN
        SELECT r.pressao_max, r.temperatura_max, r.radiacao_max,
               n.pressao, n.temperatura, n.radiacao, n.fluxo_refrigeracao
        INTO ver_pressao_max, ver_temperatura_max, ver_radiacao_max,
             ver_pressao, ver_temperatura, ver_radiacao, ver_fluxo_refrigeracao
        FROM gs_el_reatores r
        INNER JOIN gs_el_niveis_operacionais n ON r.reator_id = n.reator_id
        WHERE r.reator_id = p_reator_id
          AND n.data_hora_medicao = (
              SELECT MAX(data_hora_medicao)
              FROM gs_el_niveis_operacionais
              WHERE reator_id = p_reator_id
          );
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN 'Erro: Dados do reator não encontrados';
        WHEN OTHERS THEN
            RETURN 'Erro inesperado ao consultar os níveis operacionais: ' || SQLERRM;
    END;

    BEGIN
        ver_detalhes := '';

        IF ver_pressao > ver_pressao_max THEN
            ver_detalhes := ver_detalhes || 'Pressão excedida; ';
        END IF;
        
        IF ver_temperatura > ver_temperatura_max THEN
            ver_detalhes := ver_detalhes || 'Temperatura excedida; ';
        END IF;
        
        IF ver_radiacao > ver_radiacao_max THEN
            ver_detalhes := ver_detalhes || 'Radiação excedida; ';
        END IF;

        IF ver_detalhes IS NULL OR ver_detalhes = '' THEN
            ver_status := 'Níveis Normais';
        ELSE
            ver_status := 'ALERTA: ' || RTRIM(ver_detalhes, '; ');
        END IF;

        ver_status := ver_status || ' (Fluxo de Refrigeração: ' || 
                     ver_fluxo_refrigeracao || ' m³/h)';
                     
    EXCEPTION
        WHEN OTHERS THEN
            RETURN 'Erro inesperado ao validar os níveis do reator: ' || SQLERRM;
    END;
    
    RETURN ver_status;
END;


------------------------------------------------------------------------------------------------------------------------------------------
/*
Esta função valida se a lincença cadastrada pelo operador está de acordo com o modelo "Licença: 12345-CNEN". 
Ela primeiro valida se a licença existe no banco, e depois faz a validação do formato.
*/

CREATE OR REPLACE FUNCTION validar_licenca_operador(p_operador_id NUMBER)
RETURN VARCHAR2 
IS
    ver_licenca VARCHAR2(30);
BEGIN
    BEGIN
        SELECT lor
        INTO ver_licenca
        FROM gs_el_operadores
        WHERE operador_id = p_operador_id;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN 'Erro: Operador não encontrado';
        WHEN OTHERS THEN
            RETURN 'Erro inesperado ao consultar a licença';
    END;

    BEGIN
        IF REGEXP_LIKE(ver_licenca, '^[0-9]{5}-CNEN$') THEN
            RETURN 'Licença Válida';
        ELSE
            RETURN 'Erro: Licença inválida - formato incorreto';
        END IF;
    EXCEPTION
        WHEN OTHERS THEN
            RETURN 'Erro inesperado na validação da licença';
    END;
END;


------------------------------------------------------------------------------------------------------------------------------------------
/*
Esta função calcula a média mensal dos níveis de pressão, temperatura e radiação para um reator específico, 
permitindo analisar o comportamento operacional ao longo do tempo.
Ela também faz o tratamento de erros para verificar se os dados do respectivo reator existem.
*/

CREATE OR REPLACE FUNCTION calcular_media_mensal_niveis(p_reator_id NUMBER)
RETURN VARCHAR2 IS
    ver_media_pressao       NUMBER;
    ver_media_temperatura   NUMBER;
    ver_media_radiacao      NUMBER;
BEGIN
    BEGIN
        SELECT AVG(pressao), AVG(temperatura), AVG(radiacao)
        INTO ver_media_pressao, ver_media_temperatura, ver_media_radiacao
        FROM gs_el_niveis_operacionais
        WHERE reator_id = p_reator_id
          AND data_hora_medicao >= ADD_MONTHS(SYSDATE, -1);
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN 'Erro: Nenhum dado encontrado para o reator no último mês';
        WHEN OTHERS THEN
            RETURN 'Erro inesperado ao calcular a média mensal dos níveis operacionais';
    END;

    RETURN 'Média Mensal:' ||
           ', Pressão: ' || TO_CHAR(ver_media_pressao) || 
           ', Temperatura: ' || TO_CHAR(ver_media_temperatura) || 
           ', Radiação: ' || TO_CHAR(ver_media_radiacao);
END;

