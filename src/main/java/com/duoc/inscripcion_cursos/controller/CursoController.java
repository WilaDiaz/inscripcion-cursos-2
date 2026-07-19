package com.duoc.inscripcion_cursos.controller;

import com.duoc.inscripcion_cursos.model.Curso;
import com.duoc.inscripcion_cursos.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public ResponseEntity<List<Curso>> obtenerCursos() {
        return ResponseEntity.ok(cursoService.obtenerCursos());
    }

    @PostMapping
    public ResponseEntity<Curso> agregarCurso(@RequestBody Curso curso) {
        Curso cursoGuardado = cursoService.agregarCurso(curso);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(cursoGuardado);
    }
}