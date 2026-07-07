package com.duoc.inscripcion_cursos.service;

import com.duoc.inscripcion_cursos.model.Curso;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoService {

    private List<Curso> cursos = new ArrayList<>();

    public List<Curso> obtenerCursos() {
        return cursos;
    }

    public Curso agregarCurso(Curso curso) {
        cursos.add(curso);
        return curso;
    }
}