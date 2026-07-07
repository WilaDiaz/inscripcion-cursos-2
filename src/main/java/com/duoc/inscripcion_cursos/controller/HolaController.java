package com.duoc.inscripcion_cursos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {

    @GetMapping("/")
    public String inicio() {
        return "Bienvenido al sistema de inscripcion de cursos";
    }
}