package com.paulocandido.atendimento.repository;

import com.paulocandido.atendimento.model.Operador;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OperadorRepository extends JpaRepository<Operador, Long> {

    boolean existsByEmail(String email);

}