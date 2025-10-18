package com.example.proyectopruebas.controlador;

import com.example.proyectopruebas.modelo.*;
import com.example.proyectopruebas.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/coordinador")
public class CoordinadorController {

    @Autowired
    private EstudianteRepository estudianteRepo;

    @Autowired
    private BeneficioRepository beneficioRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 🟢 Mostrar formulario de creación
    @GetMapping("/crear-estudiante")
    public String mostrarFormularioEstudiante(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        model.addAttribute("beneficios", beneficioRepo.findAll()); // mostrar beneficios
        return "coordinador/crear-estudiante";
    }

    // 🟢 Guardar estudiante en la base de datos
    @PostMapping("/crear-estudiante")
    public String crearEstudiante(@ModelAttribute Estudiante estudiante,
                                  @RequestParam(required = false) List<String> beneficios) {
        estudiante.setPassword(passwordEncoder.encode(estudiante.getPassword()));
        estudiante.setRol(Rol.ESTUDIANTE);

        // Asignar beneficios seleccionados
        if (beneficios != null) {
            List<Beneficio> listaBeneficios = beneficioRepo.findAllById(beneficios);
            estudiante.setBeneficios(listaBeneficios);
        }

        // Asegurarse de inicializar materias
        if (estudiante.getMaterias() == null) {
            estudiante.setMaterias(new ArrayList<>());
        }

        estudianteRepo.save(estudiante);
        return "redirect:/coordinador/lista";
    }

    // 🟢 Listar todos los estudiantes
    @GetMapping("/lista")
    public String listarEstudiantes(Model model) {
        model.addAttribute("estudiantes", estudianteRepo.findAll());
        return "coordinador/lista";
    }
}

