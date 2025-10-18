package com.example.proyectopruebas.controlador;

import com.example.proyectopruebas.modelo.Resultado;
import com.example.proyectopruebas.repositorio.ResultadoRepository;
import com.example.proyectopruebas.repositorio.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteRepository estudianteRepo;

    @Autowired
    private ResultadoRepository resultadoRepo;

    @GetMapping("/mis-resultados")
    public String misResultados(Authentication auth, Model model) {
        // Obtener el email del usuario autenticado
        String email = auth.getName();

        // Buscar el estudiante por su correo en la base de datos
        var estudianteOpt = estudianteRepo.findByEmail(email);
        if (estudianteOpt.isEmpty()) {
            return "redirect:/login?error";
        }

        var estudiante = estudianteOpt.get();

        // Buscar resultados del estudiante
        List<Resultado> resultados = resultadoRepo.findByEstudianteId(estudiante.getId());

        // Pasar datos al modelo para mostrarlos en la vista
        model.addAttribute("estudiante", estudiante);
        model.addAttribute("resultados", resultados);

        return "estudiante/mis-resultados";
    }
}

