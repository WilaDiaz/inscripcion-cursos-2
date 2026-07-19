package com.duoc.inscripcion_cursos.dto;

import com.duoc.inscripcion_cursos.model.Curso;
import com.duoc.inscripcion_cursos.model.Inscripcion;

import java.util.List;

public class BffInicioResponse {

    private long totalCursos;
    private long totalInscripciones;
    private List<Curso> cursos;
    private List<Inscripcion> inscripciones;

    public BffInicioResponse(
            long totalCursos,
            long totalInscripciones,
            List<Curso> cursos,
            List<Inscripcion> inscripciones
    ) {
        this.totalCursos = totalCursos;
        this.totalInscripciones = totalInscripciones;
        this.cursos = cursos;
        this.inscripciones = inscripciones;
    }

    public long getTotalCursos() {
        return totalCursos;
    }

    public void setTotalCursos(long totalCursos) {
        this.totalCursos = totalCursos;
    }

    public long getTotalInscripciones() {
        return totalInscripciones;
    }

    public void setTotalInscripciones(long totalInscripciones) {
        this.totalInscripciones = totalInscripciones;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }
}