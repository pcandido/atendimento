package com.paulocandido.atendimento.service;

import java.util.List;

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

        if (repository.existsByEmail(cliente.getEmail()))
            throw new RuntimeException();

        return repository.save(cliente);
    }

    @Override
    public List<Cliente> list() {
        return repository.findAll();
    }

    @Override
    public Cliente getById(long id) {
        return repository.getOne(id);
    }

    @Override
    public Cliente update(long id, Cliente cliente) {
        cliente.setId(id);
        return repository.save(cliente);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

}