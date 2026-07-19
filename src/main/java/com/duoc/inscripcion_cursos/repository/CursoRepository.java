package com.duoc.inscripcion_cursos.repository;

import com.duoc.inscripcion_cursos.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}