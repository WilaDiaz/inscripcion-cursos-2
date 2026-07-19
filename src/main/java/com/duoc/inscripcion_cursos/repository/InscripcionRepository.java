package com.duoc.inscripcion_cursos.repository;

import com.duoc.inscripcion_cursos.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    List<Inscripcion> findByEstudianteId(String estudianteId);

    List<Inscripcion> findByCursoId(Long cursoId);

    boolean existsByCursoIdAndEstudianteId(Long cursoId, String estudianteId);
}