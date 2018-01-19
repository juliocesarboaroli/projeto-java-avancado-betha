package com.boaroli.arquetipo.java.avancado.util;

import com.boaroli.arquetipo.java.avancado.model.MyEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class Repository<T extends MyEntity> {

    private final Class<T> clazz;
    private final EntityManager em;

    public Repository(Class<T> clazz, EntityManager em) {
        this.clazz = clazz;
        this.em = em;
    }

    public T persist(T bean) {
        em.persist(bean);
        return bean;
    }

    public T merge(T bean) {
        return em.merge(bean);
    }

    public void remove(long id) {
        T object = em.getReference(clazz, id);
        em.remove(object);
    }

    public T findOne(long id) {
        return em.find(clazz, id);
    }

    public List<T> findAll() {
        return em.createQuery("SELECT t FROM " + clazz.getSimpleName() + " t").getResultList();
    }
}