package com.paulocandido.atendimento.service.implementations;

import com.paulocandido.atendimento.model.Operador;
import com.paulocandido.atendimento.repository.OperadorRepository;
import com.paulocandido.atendimento.service.OperadorService;

import org.springframework.stereotype.Service;

@Service
public class OperadorServiceImpl extends AbstractServiceImpl<Operador> implements OperadorService {

    private OperadorRepository repository;

    public OperadorServiceImpl(OperadorRepository repository) {
        this.repository = repository;
    }

    @Override
    protected OperadorRepository getRepository() {
        return repository;
    }

    @Override
    protected void onBeforeCreate(Operador obj) {
        super.onBeforeCreate(obj);
        if (repository.existsByEmail(obj.getEmail()))
            throw new RuntimeException();
    }

}