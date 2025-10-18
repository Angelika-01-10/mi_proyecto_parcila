package com.example.proyectopruebas.repositorio;

import com.example.proyectopruebas.modelo.Materia;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MateriaRepository extends MongoRepository<Materia, String> {}

