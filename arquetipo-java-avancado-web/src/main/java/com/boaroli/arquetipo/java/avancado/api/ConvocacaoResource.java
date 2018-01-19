package com.boaroli.arquetipo.java.avancado.api;

import com.boaroli.arquetipo.java.avancado.model.Convocacao;
import com.boaroli.arquetipo.java.avancado.service.AbstractCrudService;
import com.boaroli.arquetipo.java.avancado.service.ConvocacaoService;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("convocacoes")
public class ConvocacaoResource extends AbstractCrudResource<Convocacao> {

    @Inject
    private ConvocacaoService service;

    @Override
    protected AbstractCrudService<Convocacao> getService() {
        return service;
    }
}
