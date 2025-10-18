package com.example.proyectopruebas.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "resultados")
public class Resultado {

    @Id
    private String id;
    private String estudianteId; // referencia al estudiante
    private String materia;      // Ejemplo: "Lectura Crítica", "Matemáticas", etc.
    private Double puntaje;      // Puntuación de la materia
    private String beneficio;    // Beneficio si aplica

    public Resultado() {}

    public Resultado(String estudianteId, String materia, Double puntaje, String beneficio) {
        this.estudianteId = estudianteId;
        this.materia = materia;
        this.puntaje = puntaje;
        this.beneficio = beneficio;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getEstudianteId() { return estudianteId; }
    public void setEstudianteId(String estudianteId) { this.estudianteId = estudianteId; }

    public String getMateria() { return materia; }
    public void setMateria(String materia) { this.materia = materia; }

    public Double getPuntaje() { return puntaje; }
    public void setPuntaje(Double puntaje) { this.puntaje = puntaje; }

    public String getBeneficio() { return beneficio; }
    public void setBeneficio(String beneficio) { this.beneficio = beneficio; }
}
