package com.example.project_banco.domain.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@AllArgsConstructor
public class Evento {

    public Evento() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdEvento;

    @ManyToOne
    @JoinColumn(name = "IdEventoStatus",nullable = false)
    private StatusEvento eventoStatus;

    @ManyToOne
    @JoinColumn(name = "IdCategoriaEvento", nullable = false)
    private CategoriaEvento categoriaEvento;

    @Column(nullable = false, length = 250)
    private String Nome;

    @Column(nullable = false)
    private Date DataHoraInicio;

    @Column(nullable = false)
    private Date DataHoraFim;

    @Column(nullable = false, length = 250)
    private String Local;

    @Column(nullable = false, length = 1000)
    private String Descricao;

    @Column(name = "LimiteVagas", nullable = false)
    private Integer LimiteVagas;
} 

