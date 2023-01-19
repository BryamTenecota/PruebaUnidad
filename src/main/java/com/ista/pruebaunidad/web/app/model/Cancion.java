package com.ista.pruebaunidad.web.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity

@Getter
@Setter
public class Cancion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cancion")
    private Integer id_cancion;
    @Column(name="titulo")
    private String titulo;
    @Column(name = "artista")
    private String artista;
    @Column(name = "album")
    private String album;
    @Column(name = "anio")
    private String anio;

    @ManyToOne
    @JoinColumn(name="id_lista",referencedColumnName ="id_lista")
    private ListaReproduccion listareproduccion;
    
}
