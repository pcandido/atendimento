package com.paulocandido.atendimento.repository;

import com.paulocandido.atendimento.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    boolean existsByEmail(String email);

}