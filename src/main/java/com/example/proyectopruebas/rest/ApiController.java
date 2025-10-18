package com.example.proyectopruebas.rest;

import com.example.proyectopruebas.modelo.*;
import com.example.proyectopruebas.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private EstudianteRepository estudianteRepo;

    @Autowired
    private CoordinadorRepository coordinadorRepo;

    @Autowired
    private ResultadoRepository resultadoRepo;

    @Autowired
    private BeneficioRepository beneficioRepo;

    // ------------------- ESTUDIANTES -------------------

    @GetMapping("/estudiantes")
    public List<Estudiante> getAllEstudiantes() {
        return estudianteRepo.findAll();
    }

    @GetMapping("/estudiantes/{id}")
    public Estudiante getEstudiante(@PathVariable String id) {
        return estudianteRepo.findById(id).orElse(null);
    }

    @PostMapping("/estudiantes")
    public Estudiante crearEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteRepo.save(estudiante);
    }

    @DeleteMapping("/estudiantes/{id}")
    public void eliminarEstudiante(@PathVariable String id) {
        estudianteRepo.deleteById(id);
    }

    // ------------------- COORDINADORES -------------------

    @GetMapping("/coordinadores")
    public List<Coordinador> getAllCoordinadores() {
        return coordinadorRepo.findAll();
    }

    @GetMapping("/coordinadores/{id}")
    public Coordinador getCoordinador(@PathVariable String id) {
        return coordinadorRepo.findById(id).orElse(null);
    }

    @PostMapping("/coordinadores")
    public Coordinador crearCoordinador(@RequestBody Coordinador coordinador) {
        return coordinadorRepo.save(coordinador);
    }

    @DeleteMapping("/coordinadores/{id}")
    public void eliminarCoordinador(@PathVariable String id) {
        coordinadorRepo.deleteById(id);
    }

    // ------------------- RESULTADOS -------------------

    @GetMapping("/resultados")
    public List<Resultado> getAllResultados() {
        return resultadoRepo.findAll();
    }

    @GetMapping("/resultados/{estudianteId}")
    public List<Resultado> getResultadosPorEstudiante(@PathVariable String estudianteId) {
        return resultadoRepo.findByEstudianteId(estudianteId);
    }

    @PostMapping("/resultados")
    public Resultado agregarResultado(@RequestBody Resultado resultado) {
        return resultadoRepo.save(resultado);
    }

    @DeleteMapping("/resultados/{id}")
    public void eliminarResultado(@PathVariable String id) {
        resultadoRepo.deleteById(id);
    }

    // ------------------- BENEFICIOS -------------------

    @GetMapping("/beneficios")
    public List<Beneficio> getAllBeneficios() {
        return beneficioRepo.findAll();
    }

    @PostMapping("/beneficios")
    public Beneficio crearBeneficio(@RequestBody Beneficio beneficio) {
        return beneficioRepo.save(beneficio);
    }

    @DeleteMapping("/beneficios/{id}")
    public void eliminarBeneficio(@PathVariable String id) {
        beneficioRepo.deleteById(id);
    }

@Autowired
private MateriaRepository materiaRepo;

// ------------------- MATERIAS -------------------

@GetMapping("/materias")
public List<Materia> getAllMaterias() {
    return materiaRepo.findAll();
}

@PostMapping("/materias")
public Materia crearMateria(@RequestBody Materia materia) {
    return materiaRepo.save(materia);
}

@DeleteMapping("/materias/{id}")
public void eliminarMateria(@PathVariable String id) {
    materiaRepo.deleteById(id);
}

}
