package com.paulocandido.atendimento.service.implementations;

import java.time.LocalDateTime;

import com.paulocandido.atendimento.model.Atendimento;
import com.paulocandido.atendimento.repository.AtendimentoRepository;
import com.paulocandido.atendimento.service.AtendimentoService;

public class AtendimentoServiceImpl extends AbstractServiceImpl<Atendimento> implements AtendimentoService {

    private AtendimentoRepository repository;

    public AtendimentoServiceImpl(AtendimentoRepository repository) {
        this.repository = repository;
    }

    @Override
    protected AtendimentoRepository getRepository() {
        return repository;
    }

    @Override
    protected void onBeforeCreate(Atendimento obj) {
        super.onBeforeCreate(obj);
        obj.setCriacao(LocalDateTime.now());
    }

}