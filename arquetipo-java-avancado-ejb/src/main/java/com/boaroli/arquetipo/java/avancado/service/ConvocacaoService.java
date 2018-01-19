package com.boaroli.arquetipo.java.avancado.service;

import com.boaroli.arquetipo.java.avancado.model.Convocacao;
import com.boaroli.arquetipo.java.avancado.util.Repository;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ConvocacaoService extends AbstractCrudService<Convocacao> {

    @Inject
    private Repository<Convocacao> repository;

    @Override
    protected Repository<Convocacao> getRepository() {
        return repository;
    }
}
