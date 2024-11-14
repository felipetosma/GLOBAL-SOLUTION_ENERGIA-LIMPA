/*
Esta fun��o valida se os n�veis de opera��o (press�o, temperatura e radia��o) est�o dentro dos limites aceit�veis para cada reator,
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
            RETURN 'Erro: Dados do reator n�o encontrados';
        WHEN OTHERS THEN
            RETURN 'Erro inesperado ao consultar os n�veis operacionais: ' || SQLERRM;
    END;

    BEGIN
        ver_detalhes := '';

        IF ver_pressao > ver_pressao_max THEN
            ver_detalhes := ver_detalhes || 'Press�o excedida; ';
        END IF;
        
        IF ver_temperatura > ver_temperatura_max THEN
            ver_detalhes := ver_detalhes || 'Temperatura excedida; ';
        END IF;
        
        IF ver_radiacao > ver_radiacao_max THEN
            ver_detalhes := ver_detalhes || 'Radia��o excedida; ';
        END IF;

        IF ver_detalhes IS NULL OR ver_detalhes = '' THEN
            ver_status := 'N�veis Normais';
        ELSE
            ver_status := 'ALERTA: ' || RTRIM(ver_detalhes, '; ');
        END IF;

        ver_status := ver_status || ' (Fluxo de Refrigera��o: ' || 
                     ver_fluxo_refrigeracao || ' m�/h)';
                     
    EXCEPTION
        WHEN OTHERS THEN
            RETURN 'Erro inesperado ao validar os n�veis do reator: ' || SQLERRM;
    END;
    
    RETURN ver_status;
END;


------------------------------------------------------------------------------------------------------------------------------------------
/*
Esta fun��o valida se a lincen�a cadastrada pelo operador est� de acordo com o modelo "Licen�a: 12345-CNEN". 
Ela primeiro valida se a licen�a existe no banco, e depois faz a valida��o do formato.
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
            RETURN 'Erro: Operador n�o encontrado';
        WHEN OTHERS THEN
            RETURN 'Erro inesperado ao consultar a licen�a';
    END;

    BEGIN
        IF REGEXP_LIKE(ver_licenca, '^[0-9]{5}-CNEN$') THEN
            RETURN 'Licen�a V�lida';
        ELSE
            RETURN 'Erro: Licen�a inv�lida - formato incorreto';
        END IF;
    EXCEPTION
        WHEN OTHERS THEN
            RETURN 'Erro inesperado na valida��o da licen�a';
    END;
END;


------------------------------------------------------------------------------------------------------------------------------------------
/*
Esta fun��o calcula a m�dia mensal dos n�veis de press�o, temperatura e radia��o para um reator espec�fico, 
permitindo analisar o comportamento operacional ao longo do tempo.
Ela tamb�m faz o tratamento de erros para verificar se os dados do respectivo reator existem.
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
            RETURN 'Erro: Nenhum dado encontrado para o reator no �ltimo m�s';
        WHEN OTHERS THEN
            RETURN 'Erro inesperado ao calcular a m�dia mensal dos n�veis operacionais';
    END;

    RETURN 'M�dia Mensal:' ||
           ', Press�o: ' || TO_CHAR(ver_media_pressao) || 
           ', Temperatura: ' || TO_CHAR(ver_media_temperatura) || 
           ', Radia��o: ' || TO_CHAR(ver_media_radiacao);
END;

