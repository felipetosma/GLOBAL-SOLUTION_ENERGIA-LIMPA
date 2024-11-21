sel


DROP TABLE temp_json_export CASCADE CONSTRAINTS;

-- Configuração inicial para lidar com CLOBs
SET LINESIZE 1000
SET LONG 1000000000
SET LONGCHUNKSIZE 1000000
SET PAGESIZE 0
SET TRIM ON
SET TRIMSPOOL ON
SET FEEDBACK OFF
SET VERIFY OFF

-- Criar uma tabela temporária para armazenar o JSON
CREATE GLOBAL TEMPORARY TABLE temp_json_export (
    json_data CLOB
) ON COMMIT PRESERVE ROWS;

-- Inserir os dados na tabela temporária
INSERT INTO temp_json_export (json_data)
SELECT JSON_OBJECT(
    'historico_notificacoes' VALUE (
        SELECT JSON_ARRAYAGG(
            JSON_OBJECT(
                'hist_notificacao_id' VALUE hist_notificacao_id,
                'data_hora_atualizacao_notif' VALUE data_hora_atualizacao_notif,
                'observacao_notificacao' VALUE observacao_notificacao,
                'notificacao_id' VALUE notificacao_id
            RETURNING CLOB)
        RETURNING CLOB) FROM gs_el_historico_notificacoes
    ),
    'historico_relatorio' VALUE (
        SELECT JSON_ARRAYAGG(
            JSON_OBJECT(
                'hist_relatorio_id' VALUE hist_relatorio_id,
                'data_hora_atualizacao' VALUE data_hora_atualizacao,
                'observacoes' VALUE observacoes,
                'relatorio_turno_id' VALUE relatorio_turno_id
            RETURNING CLOB)
        RETURNING CLOB) FROM gs_el_historico_relatorio
    ),
    'localizacao_reator' VALUE (
        SELECT JSON_ARRAYAGG(
            JSON_OBJECT(
                'loc_reator_id' VALUE loc_reator_id,
                'setor' VALUE setor,
                'unidade' VALUE unidade,
                'descricao' VALUE descricao
            RETURNING CLOB)
        RETURNING CLOB) FROM gs_el_localizacao_reator
    ),
    'niveis_operacionais' VALUE (
        SELECT JSON_ARRAYAGG(
            JSON_OBJECT(
                'nivel_operacional_id' VALUE nivel_operacional_id,
                'data_hora_medicao' VALUE data_hora_medicao,
                'pressao' VALUE pressao,
                'temperatura' VALUE temperatura,
                'radiacao' VALUE radiacao,
                'fluxo_refrigeracao' VALUE fluxo_refrigeracao,
                'reator_id' VALUE reator_id
            RETURNING CLOB)
        RETURNING CLOB) FROM gs_el_niveis_operacionais
    ),
    'notificacoes' VALUE (
        SELECT JSON_ARRAYAGG(
            JSON_OBJECT(
                'notificacao_id' VALUE notificacao_id,
                'data_hora_notificacao' VALUE data_hora_notificacao,
                'status_notificacao_id' VALUE status_notificacao_id,
                'operador_id' VALUE operador_id,
                'reator_id' VALUE reator_id
            RETURNING CLOB)
        RETURNING CLOB) FROM gs_el_notificacoes
    ),
    'operadores' VALUE (
        SELECT JSON_ARRAYAGG(
            JSON_OBJECT(
                'operador_id' VALUE operador_id,
                'nome_operador' VALUE nome_operador,
                'senha_operador' VALUE senha_operador,
                'cargo' VALUE cargo,
                'turno_id' VALUE turno_id,
                'lor' VALUE lor
            RETURNING CLOB)
        RETURNING CLOB) FROM gs_el_operadores
    ),
    'reatores' VALUE (
        SELECT JSON_ARRAYAGG(
            JSON_OBJECT(
                'reator_id' VALUE reator_id,
                'nome_reator' VALUE nome_reator,
                'pressao_max' VALUE pressao_max,
                'temperatura_max' VALUE temperatura_max,
                'radiacao_max' VALUE radiacao_max,
                'fluxo_refrigeracao_max' VALUE fluxo_refrigeracao_max,
                'tipo_reator_id' VALUE tipo_reator_id,
                'loc_reator_id' VALUE loc_reator_id
            RETURNING CLOB)
        RETURNING CLOB) FROM gs_el_reatores
    ),
    'relatorios_turno' VALUE (
        SELECT JSON_ARRAYAGG(
            JSON_OBJECT(
                'relatorio_turno_id' VALUE relatorio_turno_id,
                'data_hora_relatorio' VALUE data_hora_relatorio,
                'resumo_atividades' VALUE resumo_atividades,
                'observacoes' VALUE observacoes,
                'operador_id' VALUE operador_id,
                'reator_id' VALUE reator_id
            RETURNING CLOB)
        RETURNING CLOB) FROM gs_el_relatorios_turno
    ),
    'status_notificacao' VALUE (
        SELECT JSON_ARRAYAGG(
            JSON_OBJECT(
                'status_notificacao_id' VALUE status_notificacao_id,
                'descr_status' VALUE descr_status
            RETURNING CLOB)
        RETURNING CLOB) FROM gs_el_status_notificacao
    ),
    'tipo_reator' VALUE (
        SELECT JSON_ARRAYAGG(
            JSON_OBJECT(
                'tipo_reator_id' VALUE tipo_reator_id,
                'descricao_reator' VALUE descricao_reator,
                'capacidade_energia' VALUE capacidade_energia,
                'tecnologia' VALUE tecnologia,
                'fabricante' VALUE fabricante
            RETURNING CLOB)
        RETURNING CLOB) FROM gs_el_tipo_reator
    ),
    'turnos' VALUE (
        SELECT JSON_ARRAYAGG(
            JSON_OBJECT(
                'turno_id' VALUE turno_id,
                'descricao_turno' VALUE descricao_turno
            RETURNING CLOB)
        RETURNING CLOB) FROM gs_el_turnos
    )
RETURNING CLOB) FROM DUAL;

-- Exportar para arquivo (substitua o caminho conforme necessário)
SPOOL C:\exportacao\database_export.json

-- Selecionar e exportar o JSON da tabela temporária
SELECT json_data FROM temp_json_export;

SPOOL OFF

-- Limpar a tabela temporária
DROP TABLE temp_json_export;