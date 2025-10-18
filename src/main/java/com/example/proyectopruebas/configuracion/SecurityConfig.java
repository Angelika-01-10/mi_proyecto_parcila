package com.example.proyectopruebas.configuracion;

import com.example.proyectopruebas.modelo.Coordinador;
import com.example.proyectopruebas.modelo.Estudiante;
import com.example.proyectopruebas.repositorio.CoordinadorRepository;
import com.example.proyectopruebas.repositorio.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import java.util.Collections;

@Configuration
public class SecurityConfig {

    @Autowired
    private CoordinadorRepository coordinadorRepo;

    @Autowired
    private EstudianteRepository estudianteRepo;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authProvider() {
        return new AuthenticationProvider() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                String email = authentication.getName();
                String password = authentication.getCredentials().toString();

                // Buscar en coordinadores
                Coordinador coordinador = coordinadorRepo.findByEmail(email).orElse(null);
                if (coordinador != null && passwordEncoder().matches(password, coordinador.getPassword())) {
                    return new UsernamePasswordAuthenticationToken(
                            email,
                            password,
                            Collections.singleton(new SimpleGrantedAuthority("ROLE_COORDINADOR"))
                    );
                }

                // Buscar en estudiantes
                Estudiante estudiante = estudianteRepo.findByEmail(email).orElse(null);
                if (estudiante != null && passwordEncoder().matches(password, estudiante.getPassword())) {
                    return new UsernamePasswordAuthenticationToken(
                            email,
                            password,
                            Collections.singleton(new SimpleGrantedAuthority("ROLE_ESTUDIANTE"))
                    );
                }

                return null; // Si no existe el usuario
            }

            @Override
            public boolean supports(Class<?> authentication) {
                return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
            }
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests()
                .requestMatchers("/", "/index", "/login", "/css/**", "/js/**").permitAll()
                .requestMatchers("/coordinador/**").hasRole("COORDINADOR")
                .requestMatchers("/estudiante/**").hasRole("ESTUDIANTE")
                .anyRequest().authenticated()
            .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/default", true)
            .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout").permitAll()
            .and()
                .csrf().disable()
            .authenticationProvider(authProvider());

        return http.build();
    }
}


