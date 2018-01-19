package com.boaroli.arquetipo.java.avancado.api;

import com.boaroli.arquetipo.java.avancado.model.MyEntity;
import com.boaroli.arquetipo.java.avancado.service.AbstractCrudService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

//@Stateless
public abstract class AbstractCrudResource<T extends MyEntity> {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<T> findAll() {
        return getService().findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public T findById(@PathParam("id") Long id) {
        return getService().findById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(T entity) {
        return Response.status(Response.Status.CREATED)
                .entity(getService().save(entity))
                .build();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, T entity) {
        if (!Objects.equals(id, entity.getId())) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("O id do objeto é diferente do id da url")
                    .build();
        }
        return Response.status(Response.Status.OK)
                .entity(getService().update(entity))
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Long id) {
        getService().remove(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    protected abstract AbstractCrudService<T> getService();
}
