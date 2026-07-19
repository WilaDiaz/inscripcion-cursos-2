package com.duoc.inscripcion_cursos.service;

import com.duoc.inscripcion_cursos.model.Curso;
import com.duoc.inscripcion_cursos.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> obtenerCursos() {
        return cursoRepository.findAll();
    }

    public Curso agregarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }
}