package com.Tarea3.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "pais")
public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPais;
    String nombre;
    String capital;
    String poblacion;
    String continente;

    public Pais() {
    }

    
    public Pais(String nombre, String capital, String poblacion, String continente) {
        this.nombre = nombre;
        this.capital = capital;
        this.poblacion = poblacion;
        this.continente = continente;
    }

}
