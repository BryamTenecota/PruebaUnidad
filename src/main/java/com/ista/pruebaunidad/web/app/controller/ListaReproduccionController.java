package com.ista.pruebaunidad.web.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ista.pruebaunidad.web.app.model.ListaReproduccion;
import com.ista.pruebaunidad.web.app.service.ListaReproduccionService;

@RestController
public class ListaReproduccionController {

    @Autowired
    ListaReproduccionService listaReproduccionService;

    @GetMapping("/listarlista")
    public ResponseEntity< List<ListaReproduccion>> obtenerLista() {
        return new ResponseEntity<>(listaReproduccionService.findByAll(), HttpStatus.OK);
    }
    
    @PostMapping("/crearlista")
    public ResponseEntity<ListaReproduccion> crear(@RequestBody ListaReproduccion l){
     return new ResponseEntity<>(listaReproduccionService.save(l), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/eliminarlista/{id_lista}")
    public void eliminar(@PathVariable("id_lista") Integer id_lista){
    	listaReproduccionService.delete(id_lista);
    }
    
    @PutMapping("/actualizarlista/{id_lista}")
    public ResponseEntity<ListaReproduccion> actualizar(@RequestBody ListaReproduccion l,@PathVariable Integer id_lista){
    	ListaReproduccion listaa = listaReproduccionService.findById(id_lista);
    	listaa.setNombre(l.getNombre());
    	listaa.setDescripcion(l.getDescripcion());
     return new ResponseEntity<>(listaReproduccionService.save(listaa), HttpStatus.CREATED);
    }
    
    @GetMapping("/buscarlista/{id_lista}")
    public ResponseEntity<ListaReproduccion> buscar(@PathVariable("id_lista") Integer id_lista) {
        return new ResponseEntity<>(listaReproduccionService.findById(id_lista), HttpStatus.OK);
    }
}

