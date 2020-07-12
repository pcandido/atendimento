package com.paulocandido.atendimento.service;

import com.paulocandido.atendimento.model.Cliente;
import com.paulocandido.atendimento.repository.ClienteRepository;

import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends AbstractServiceImpl<Cliente> implements ClienteService {

    private ClienteRepository repository;

    public ClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    protected ClienteRepository getRepository() {
        return repository;
    }

    @Override
    protected void onBeforeCreate(Cliente obj) {
        super.onBeforeCreate(obj);
        if (repository.existsByEmail(obj.getEmail()))
            throw new RuntimeException();
    }

}