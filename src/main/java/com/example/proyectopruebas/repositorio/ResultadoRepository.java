package com.example.proyectopruebas.repositorio;

import com.example.proyectopruebas.modelo.Resultado;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ResultadoRepository extends MongoRepository<Resultado, String> {
    List<Resultado> findByEstudianteId(String estudianteId);
}


