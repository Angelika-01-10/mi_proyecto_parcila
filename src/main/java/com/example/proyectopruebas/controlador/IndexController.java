package com.example.proyectopruebas.controlador;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;

@Controller
public class IndexController {

    @GetMapping({"/", "/index"})
    public String index() {
        return "index"; // Página para elegir rol
    }

@GetMapping("/default")
public String redirigirSegunRol(Authentication auth) {
    if (auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_COORDINADOR"))) {
        return "redirect:/coordinador/lista";
    } else if (auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ESTUDIANTE"))) {
        return "redirect:/estudiante/mis-resultados";
    }
    return "redirect:/login?error";
}

}

