package com.paulocandido.atendimento.service;

import java.util.List;

import com.paulocandido.atendimento.model.Cliente;

public interface ClienteService {
    
    Cliente create(Cliente cliente);

    List<Cliente> list();

    Cliente getById(long id);

    Cliente update(long id, Cliente cliente);

    void delete(long id);
    
}