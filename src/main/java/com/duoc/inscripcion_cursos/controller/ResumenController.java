package com.duoc.inscripcion_cursos.controller;

import com.duoc.inscripcion_cursos.model.Curso;
import com.duoc.inscripcion_cursos.service.ResumenService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/resumenes")
public class ResumenController {

    private final ResumenService resumenService;

    public ResumenController(ResumenService resumenService) {
        this.resumenService = resumenService;
    }

    @PostMapping("/generar")
    public String generarResumen(@RequestBody Curso curso) throws IOException {
        return resumenService.generarResumen(curso);
    }
}
