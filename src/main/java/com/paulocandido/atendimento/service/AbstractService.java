package com.paulocandido.atendimento.service;

import java.util.List;

import com.paulocandido.atendimento.model.Identifiable;

public interface AbstractService<T extends Identifiable> {

    T create(T obj);

    List<T> list();

    T getById(long id);

    T update(long id, T obj);

    void delete(long id);
    
}