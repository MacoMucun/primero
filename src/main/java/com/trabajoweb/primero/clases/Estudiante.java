package com.trabajoweb.primero.clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Maco on 20/07/2017.
 */
@Entity
public class Estudiante {

  private String nombre;
  private int edad;

@Id@GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    public Estudiante() {

    }

    public Estudiante(String nombre, int edad, Long id) {
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
