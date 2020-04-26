package com.paulocandido.atendimento.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sumario;
    private LocalDateTime criacao;
    private String descricao;
    private TipoAtendimento tipo;
    private Cliente cliente;
    private Operador responsavel;

}