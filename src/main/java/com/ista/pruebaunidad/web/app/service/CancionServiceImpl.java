
package com.ista.pruebaunidad.web.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ista.pruebaunidad.web.app.model.Cancion;
import com.ista.pruebaunidad.web.app.repository.CancionRepository;

@Service
public class CancionServiceImpl extends GenericServiceImpl<Cancion, Integer> implements CancionService {

    @Autowired
    CancionRepository cancionRepository;

    @Override
    public CrudRepository<Cancion, Integer> getDao() {
        return cancionRepository;
    }
}
