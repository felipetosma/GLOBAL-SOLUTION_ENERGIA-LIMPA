WITH operadores_json AS (
  SELECT JSON_OBJECT(
    'operador_id' VALUE o.operador_id,
    'nome_operador' VALUE o.nome_operador,
    'cargo' VALUE o.cargo,
    'lor' VALUE o.lor,
    'turno' VALUE JSON_OBJECT(
      'turno_id' VALUE t.turno_id,
      'data_inicio' VALUE t.data_inicio,
      'data_fim' VALUE t.data_fim
    ),
    'relatorios' VALUE (
      SELECT JSON_ARRAYAGG(
        JSON_OBJECT(
          'relatorio_turno_id' VALUE rt.relatorio_turno_id,
          'data_hora_relatorio' VALUE rt.data_hora_relatorio,
          'resumo_atividades' VALUE rt.resumo_atividades,
          'observacoes' VALUE rt.observacoes,
          'historico' VALUE (
            SELECT JSON_ARRAYAGG(
              JSON_OBJECT(
                'hist_relatorio_id' VALUE hr.hist_relatorio_id,
                'data_hora_atualizacao' VALUE hr.data_hora_atualizacao,
                'observacoes' VALUE hr.observacoes
              )
            )
            FROM gs_el_historico_relatorio hr
            WHERE hr.relatorio_turno_id = rt.relatorio_turno_id
          )
        )
      )
      FROM gs_el_relatorios_turno rt
      WHERE rt.operador_id = o.operador_id
    ),
    'notificacoes' VALUE (
      SELECT JSON_ARRAYAGG(
        JSON_OBJECT(
          'notificacao_id' VALUE n.notificacao_id,
          'data_hora_notificacao' VALUE n.data_hora_notificacao,
          'status' VALUE JSON_OBJECT(
            'status_notificacao_id' VALUE sn.status_notificacao_id,
            'descr_status' VALUE sn.descr_status
          ),
          'historico' VALUE (
            SELECT JSON_ARRAYAGG(
              JSON_OBJECT(
                'hist_notificacao_id' VALUE hn.hist_notificacao_id,
                'data_hora_atualizacao_notif' VALUE hn.data_hora_atualizacao_notif,
                'observacao_notificacao' VALUE hn.observacao_notificacao
              )
            )
            FROM gs_el_historico_notificacoes hn
            WHERE hn.notificacao_id = n.notificacao_id
          )
        )
      )
      FROM gs_el_notificacoes n
      LEFT JOIN gs_el_status_notificacao sn ON n.status_notificacao_id = sn.status_notificacao_id
      WHERE n.operador_id = o.operador_id
    )
  ) AS operador_json
  FROM gs_el_operadores o
  JOIN gs_el_turnos t ON o.turno_id = t.turno_id
),

reatores_json AS (
  SELECT JSON_OBJECT(
    'reator_id' VALUE r.reator_id,
    'nome_reator' VALUE r.nome_reator,
    'pressao_max' VALUE r.pressao_max,
    'temperatura_max' VALUE r.temperatura_max,
    'radiacao_max' VALUE r.radiacao_max,
    'fluxo_refrigeracao_max' VALUE r.fluxo_refrigeracao_max,
    
    'tipo_reator' VALUE JSON_OBJECT(
      'tipo_reator_id' VALUE tr.tipo_reator_id,
      'descricao_reator' VALUE tr.descricao_reator,
      'capacidade_energia' VALUE tr.capacidade_energia,
      'tecnologia' VALUE tr.tecnologia,
      'fabricante' VALUE tr.fabricante
    ),
    
    'localizacao' VALUE JSON_OBJECT(
      'loc_reator_id' VALUE lr.loc_reator_id,
      'setor' VALUE lr.setor,
      'unidade' VALUE lr.unidade,
      'descricao' VALUE lr.descricao
    ),
    
    'niveis_operacionais' VALUE (
      SELECT JSON_ARRAYAGG(
        JSON_OBJECT(
          'nivel_operacional_id' VALUE no.nivel_operacional_id,
          'data_hora_medicao' VALUE no.data_hora_medicao,
          'pressao' VALUE no.pressao,
          'temperatura' VALUE no.temperatura,
          'radiacao' VALUE no.radiacao,
          'fluxo_refrigeracao' VALUE no.fluxo_refrigeracao
        )
      )
      FROM gs_el_niveis_operacionais no
      WHERE no.reator_id = r.reator_id
    ),
    
    'notificacoes' VALUE (
      SELECT JSON_ARRAYAGG(
        JSON_OBJECT(
          'notificacao_id' VALUE n.notificacao_id,
          'data_hora_notificacao' VALUE n.data_hora_notificacao,
          'status' VALUE JSON_OBJECT(
            'status_notificacao_id' VALUE sn.status_notificacao_id,
            'descr_status' VALUE sn.descr_status
          ),
          'operador' VALUE JSON_OBJECT(
            'operador_id' VALUE o.operador_id,
            'nome_operador' VALUE o.nome_operador,
            'cargo' VALUE o.cargo
          ),
          'historico' VALUE (
            SELECT JSON_ARRAYAGG(
              JSON_OBJECT(
                'hist_notificacao_id' VALUE hn.hist_notificacao_id,
                'data_hora_atualizacao_notif' VALUE hn.data_hora_atualizacao_notif,
                'observacao_notificacao' VALUE hn.observacao_notificacao
              )
            )
            FROM gs_el_historico_notificacoes hn
            WHERE hn.notificacao_id = n.notificacao_id
          )
        )
      )
      FROM gs_el_notificacoes n
      LEFT JOIN gs_el_status_notificacao sn ON n.status_notificacao_id = sn.status_notificacao_id
      LEFT JOIN gs_el_operadores o ON n.operador_id = o.operador_id
      WHERE n.reator_id = r.reator_id
    ),
    
    'relatorios' VALUE (
      SELECT JSON_ARRAYAGG(
        JSON_OBJECT(
          'relatorio_turno_id' VALUE rt.relatorio_turno_id,
          'data_hora_relatorio' VALUE rt.data_hora_relatorio,
          'resumo_atividades' VALUE rt.resumo_atividades,
          'observacoes' VALUE rt.observacoes,
          'operador' VALUE JSON_OBJECT(
            'operador_id' VALUE o.operador_id,
            'nome_operador' VALUE o.nome_operador,
            'cargo' VALUE o.cargo
          ),
          'historico' VALUE (
            SELECT JSON_ARRAYAGG(
              JSON_OBJECT(
                'hist_relatorio_id' VALUE hr.hist_relatorio_id,
                'data_hora_atualizacao' VALUE hr.data_hora_atualizacao,
                'observacoes' VALUE hr.observacoes
              )
            )
            FROM gs_el_historico_relatorio hr
            WHERE hr.relatorio_turno_id = rt.relatorio_turno_id
          )
        )
      )
      FROM gs_el_relatorios_turno rt
      LEFT JOIN gs_el_operadores o ON rt.operador_id = o.operador_id
      WHERE rt.reator_id = r.reator_id
    )
  ) AS reator_json
  FROM gs_el_reatores r
  JOIN gs_el_tipo_reator tr ON r.tipo_reator_id = tr.tipo_reator_id
  JOIN gs_el_localizacao_reator lr ON r.loc_reator_id = lr.loc_reator_id
),

status_notificacoes_json AS (
  SELECT JSON_ARRAYAGG(
    JSON_OBJECT(
      'status_notificacao_id' VALUE sn.status_notificacao_id,
      'descr_status' VALUE sn.descr_status
    )
  ) AS status_json
  FROM gs_el_status_notificacao sn
),

tipos_reator_json AS (
  SELECT JSON_ARRAYAGG(
    JSON_OBJECT(
      'tipo_reator_id' VALUE tr.tipo_reator_id,
      'descricao_reator' VALUE tr.descricao_reator,
      'capacidade_energia' VALUE tr.capacidade_energia,
      'tecnologia' VALUE tr.tecnologia,
      'fabricante' VALUE tr.fabricante
    )
  ) AS tipos_json
  FROM gs_el_tipo_reator tr
),

localizacoes_json AS (
  SELECT JSON_ARRAYAGG(
    JSON_OBJECT(
      'loc_reator_id' VALUE lr.loc_reator_id,
      'setor' VALUE lr.setor,
      'unidade' VALUE lr.unidade,
      'descricao' VALUE lr.descricao
    )
  ) AS localizacoes_json
  FROM gs_el_localizacao_reator lr
)

SELECT JSON_OBJECT(
  'data_exportacao' VALUE SYSTIMESTAMP,
  'metadados' VALUE JSON_OBJECT(
    'status_notificacoes' VALUE (SELECT status_json FROM status_notificacoes_json),
    'tipos_reator' VALUE (SELECT tipos_json FROM tipos_reator_json),
    'localizacoes' VALUE (SELECT localizacoes_json FROM localizacoes_json)
  ),
  'operadores' VALUE (
    SELECT JSON_ARRAYAGG(operador_json)
    FROM operadores_json
  ),
  'reatores' VALUE (
    SELECT JSON_ARRAYAGG(reator_json)
    FROM reatores_json
  )
) AS resultado
FROM dual;