package com.example.proyectopruebas.modelo;

public class Materia {
    private String nombre;
    private double puntaje;

    public Materia() {}

    public Materia(String nombre, double puntaje) {
        this.nombre = nombre;
        this.puntaje = puntaje;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPuntaje() { return puntaje; }
    public void setPuntaje(double puntaje) { this.puntaje = puntaje; }
}
