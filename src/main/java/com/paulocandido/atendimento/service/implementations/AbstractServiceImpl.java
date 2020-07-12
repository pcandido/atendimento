package com.paulocandido.atendimento.service.implementations;

import java.util.List;

import com.paulocandido.atendimento.model.Identifiable;
import com.paulocandido.atendimento.service.AbstractService;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractServiceImpl<T extends Identifiable> implements AbstractService<T> {

    protected abstract JpaRepository<T, Long> getRepository();

    protected void onBeforeCreate(T obj) {
    }

    protected void onAfterCreate(T obj) {
    }

    @Override
    public T create(T obj) {
        onBeforeCreate(obj);
        T saved = getRepository().save(obj);
        onAfterCreate(saved);
        return saved;
    }

    @Override
    public List<T> list() {
        return getRepository().findAll();
    }

    @Override
    public T getById(long id) {
        return getRepository().getOne(id);
    }

    protected void onBeforeUpdate(long id, T obj) {
    }

    protected void onAfterUpdate(long id, T obj) {
    }

    @Override
    public T update(long id, T obj) {
        obj.setId(id);

        onBeforeUpdate(id, obj);
        T saved = getRepository().save(obj);
        onAfterUpdate(id, saved);
        return saved;
    }

    protected void onBeforeDelete(long id) {
    }

    protected void onAfterDelete(long id) {
    }

    @Override
    public void delete(long id) {
        onBeforeDelete(id);
        getRepository().deleteById(id);
        onAfterDelete(id);
    }

}