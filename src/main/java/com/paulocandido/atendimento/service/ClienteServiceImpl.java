package com.paulocandido.atendimento.service;

import com.paulocandido.atendimento.model.Cliente;
import com.paulocandido.atendimento.repository.ClienteRepository;

import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository repository;

    public ClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cliente create(Cliente cliente) {
        
        if(repository.existsByEmail(cliente.getEmail()))
            throw new RuntimeException();

        return repository.save(cliente);
    }

}