package com.paulocandido.atendimento.repository;

import com.paulocandido.atendimento.model.Atendimento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {

}