package com.duoc.inscripcion_cursos.controller;

import com.duoc.inscripcion_cursos.model.Curso;
import org.springframework.web.bind.annotation.*;
import com.duoc.inscripcion_cursos.service.CursoService;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;
    

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public List<Curso> obtenerCursos() {
    return cursoService.obtenerCursos();
}

    @PostMapping
    public Curso agregarCurso(@RequestBody Curso curso) {
    return cursoService.agregarCurso(curso);
}

}
