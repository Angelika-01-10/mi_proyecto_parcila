package com.example.proyectopruebas.repositorio;

import com.example.proyectopruebas.modelo.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface EstudianteRepository extends MongoRepository<Estudiante, String> {
    Optional<Estudiante> findByEmail(String email);
}



