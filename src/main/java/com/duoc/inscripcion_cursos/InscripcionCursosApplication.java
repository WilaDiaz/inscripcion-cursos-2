package com.duoc.inscripcion_cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.duoc.inscripcion_cursos.repository")
public class InscripcionCursosApplication {

    public static void main(String[] args) {
        SpringApplication.run(InscripcionCursosApplication.class, args);
    }
}
