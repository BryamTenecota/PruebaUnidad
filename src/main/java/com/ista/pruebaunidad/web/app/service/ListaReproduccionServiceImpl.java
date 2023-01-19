package com.ista.pruebaunidad.web.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ista.pruebaunidad.web.app.model.ListaReproduccion;
import com.ista.pruebaunidad.web.app.repository.ListaReproduccionRepository;

@Service
public class ListaReproduccionServiceImpl extends GenericServiceImpl<ListaReproduccion, Integer> implements ListaReproduccionService {

    @Autowired
    ListaReproduccionRepository listaReproduccionRepository;

    @Override
    public CrudRepository<ListaReproduccion, Integer> getDao() {
        return listaReproduccionRepository;
    }

}
