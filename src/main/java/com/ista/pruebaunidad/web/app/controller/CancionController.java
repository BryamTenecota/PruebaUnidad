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

import com.ista.pruebaunidad.web.app.model.Cancion;
import com.ista.pruebaunidad.web.app.service.CancionService;

@RestController
public class CancionController {

    @Autowired
    CancionService cancionService;

    @GetMapping("/listarcancion")
    public ResponseEntity< List<Cancion>> obtenerLista() {
        return new ResponseEntity<>(cancionService.findByAll(), HttpStatus.OK);
    }
    
    @PostMapping("/crearcancion")
    public ResponseEntity<Cancion> crear(@RequestBody Cancion c){
     return new ResponseEntity<>(cancionService.save(c), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/eliminarcancion/{id_cancion}")
    public void eliminar(@PathVariable("id_cancion") Integer id_cancion){
    	cancionService.delete(id_cancion);
    }
    
    @PutMapping("/actualizarcancion/{id_cancion}")
    public ResponseEntity<Cancion> actualizar(@RequestBody Cancion c,@PathVariable Integer id_cancion){
    	Cancion canciona = cancionService.findById(id_cancion);
    	canciona.setTitulo(c.getTitulo());
    	canciona.setArtista(c.getArtista());
        canciona.setAlbum(c.getAlbum());
        canciona.setAnio(c.getAnio());
     return new ResponseEntity<>(cancionService.save(canciona), HttpStatus.CREATED);
    }
    
    @GetMapping("/buscarcancion/{id_cancion}")
    public ResponseEntity<Cancion> buscar(@PathVariable("id_cancion") Integer id_cancion) {
        return new ResponseEntity<>(cancionService.findById(id_cancion), HttpStatus.OK);
    }
}
