package com.duoc.inscripcion_cursos.repository;

import com.duoc.inscripcion_cursos.model.ResumenInscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumenInscripcionRepository extends JpaRepository<ResumenInscripcion, Long> {
}