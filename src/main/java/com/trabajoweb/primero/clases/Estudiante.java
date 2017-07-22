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
  private String puesto;
  private int dpi;
  private int edad;

@Id@GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    public Estudiante() {

    }

    public Estudiante(String nombre, int edad,int dpi, String puesto, Long id) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.dpi = dpi;
        this.edad = edad;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {return puesto;}

    public void setPuesto(String puesto) {this.puesto = puesto;}

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDpi() {return dpi;}

    public void setDpi(int dpi) {this.dpi = dpi;}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
