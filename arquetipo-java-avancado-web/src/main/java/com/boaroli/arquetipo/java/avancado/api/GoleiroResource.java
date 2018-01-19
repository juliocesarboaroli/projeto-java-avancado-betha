/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.boaroli.arquetipo.java.avancado.api;

import com.boaroli.arquetipo.java.avancado.model.Goleiro;
import com.boaroli.arquetipo.java.avancado.service.AbstractCrudService;
import com.boaroli.arquetipo.java.avancado.service.GoleiroService;
import com.boaroli.arquetipo.java.avancado.service.TestDoSuriService;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("goleiros")
public class GoleiroResource extends AbstractCrudResource<Goleiro> {

    @Inject
    private TestDoSuriService testDoSuriService;

    @Inject
    private GoleiroService service;

    @Override
    protected AbstractCrudService<Goleiro> getService() {
        return service;
    }
}