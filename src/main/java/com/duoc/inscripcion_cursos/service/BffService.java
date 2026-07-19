package com.duoc.inscripcion_cursos.service;

import com.duoc.inscripcion_cursos.dto.BffInicioResponse;
import com.duoc.inscripcion_cursos.model.Curso;
import com.duoc.inscripcion_cursos.model.Inscripcion;
import com.duoc.inscripcion_cursos.repository.CursoRepository;
import com.duoc.inscripcion_cursos.repository.InscripcionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BffService {

    private final CursoRepository cursoRepository;
    private final InscripcionRepository inscripcionRepository;

    public BffService(
            CursoRepository cursoRepository,
            InscripcionRepository inscripcionRepository
    ) {
        this.cursoRepository = cursoRepository;
        this.inscripcionRepository = inscripcionRepository;
    }

    public BffInicioResponse obtenerInformacionInicio() {

        List<Curso> cursos = cursoRepository.findAll();
        List<Inscripcion> inscripciones = inscripcionRepository.findAll();

        return new BffInicioResponse(
                cursos.size(),
                inscripciones.size(),
                cursos,
                inscripciones
        );
    }
}