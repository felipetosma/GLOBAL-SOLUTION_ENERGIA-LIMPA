package com.example.energyx.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "gs_el_status_notificacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatusNotificacaoRepository {

    @Id
    @Column(name = "status_notificacao_id")
    private Long statusNotificacaoId;

    @Column(name = "descr_status", length = 200)
    private String descrStatus;
}