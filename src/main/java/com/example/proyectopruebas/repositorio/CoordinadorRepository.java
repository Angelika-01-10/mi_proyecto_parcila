package com.example.proyectopruebas.repositorio;

import com.example.proyectopruebas.modelo.Coordinador;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CoordinadorRepository extends MongoRepository<Coordinador, String> {
    Optional<Coordinador> findByEmail(String email);
}
