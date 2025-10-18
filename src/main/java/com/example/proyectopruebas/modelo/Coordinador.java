package com.example.proyectopruebas.modelo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "coordinadores")
public class Coordinador extends Usuario {

    private String facultad;

    public Coordinador() {
        super();
    }

    public Coordinador(String nombre, String email, String password, String facultad) {
        super(nombre, email, password, Rol.COORDINADOR);
        this.facultad = facultad;
    }

    public String getFacultad() { return facultad; }
    public void setFacultad(String facultad) { this.facultad = facultad; }
}
