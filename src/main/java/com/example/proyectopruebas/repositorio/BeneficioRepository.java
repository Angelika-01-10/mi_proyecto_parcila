package com.example.proyectopruebas.repositorio;

import com.example.proyectopruebas.modelo.Beneficio;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BeneficioRepository extends MongoRepository<Beneficio, String> {}

