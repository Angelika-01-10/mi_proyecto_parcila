package com.example.proyectopruebas.modelo;

import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "estudiantes")
public class Estudiante extends Usuario {

    private String programa;
    private double notaGeneral;
    private List<Materia> materias;
    private List<Beneficio> beneficios;

    public Estudiante() {}

    public String getPrograma() { return programa; }
    public void setPrograma(String programa) { this.programa = programa; }

    public double getNotaGeneral() { return notaGeneral; }
    public void setNotaGeneral(double notaGeneral) { this.notaGeneral = notaGeneral; }

    public List<Materia> getMaterias() { return materias; }
    public void setMaterias(List<Materia> materias) { this.materias = materias; }

    public List<Beneficio> getBeneficios() { return beneficios; }
    public void setBeneficios(List<Beneficio> beneficios) { this.beneficios = beneficios; }
}
