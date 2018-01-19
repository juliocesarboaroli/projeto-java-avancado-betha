package com.boaroli.arquetipo.java.avancado.service;

import com.boaroli.arquetipo.java.avancado.model.MyEntity;
import com.boaroli.arquetipo.java.avancado.util.Repository;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.util.List;

public abstract class AbstractCrudService<T extends MyEntity> {

    //TODO: Implentar método findAll mais robusto
    public List<T> findAll() {
        return getRepository().findAll();
    }

    public T findById(Long id) {
        return getRepository().findOne(id);
    }

    //TODO: Implementar BeansValidation
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public T save(T entity) {
        return getRepository().persist(entity);
    }

    //TODO: Implementar BeansValidation
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public T update(T entity) {
        return getRepository().merge(entity);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remove(Long id) {
        getRepository().remove(id);
    }

    protected abstract Repository<T> getRepository();
}
