package com.example.energyx.controller;

import com.example.energyx.dto.HistoricoNotificacoesDTO;
import com.example.energyx.service.HistoricoNotificacoesService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
@RequestMapping("/historicoNotificacoes")
public class HistoricoNotificacoesController {

    @Autowired
    private HistoricoNotificacoesService historicoNotificacoesService;

    @PostMapping("/inserir")
    public ResponseEntity<String> inserirHistoricoNotificacao(@RequestBody @Valid HistoricoNotificacoesDTO historicoDTO) {
        historicoNotificacoesService.inserirHistoricoNotificacao(HistoricoNotificacoesDTO);
        return ResponseEntity.ok("Histórico de notificação inserido com sucesso.");
    }
}