package com.example.proyectopruebas;

import com.example.proyectopruebas.modelo.Rol;
import com.example.proyectopruebas.modelo.Usuario;
import com.example.proyectopruebas.repositorio.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ProyectopruebasApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProyectopruebasApplication.class, args);
    }

    // Aquí pones tu CommandLineRunner
    @Bean
    public CommandLineRunner init(UsuarioRepository repo, PasswordEncoder encoder) {
        return args -> {
            if (repo.findByEmail("coordinador@ejemplo.com").isEmpty()) {
                Usuario c = new Usuario(
                        "Coordinador",
                        "coordinador@ejemplo.com",
                        encoder.encode("12345"),
                        Rol.COORDINADOR
                );
                repo.save(c);
                System.out.println("Coordinador de prueba creado: coordinador@ejemplo.com / 12345");
            }
        };
    }
	
}
