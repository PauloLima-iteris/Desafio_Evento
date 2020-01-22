package com.example.project_banco.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Participacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdParticipacao;

    @Column(nullable = false)
    private Integer IdEvento;

    @Column(nullable = false, length = 250)
    private String LoginParticipante;

    @Column(nullable = false)
    private Boolean FlagPresente;

    @Column(nullable = true)
    private Integer Nota;

    @Column(nullable = true, length = 1000)
    private String Comentario;
}