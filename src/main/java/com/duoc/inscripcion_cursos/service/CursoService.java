package com.duoc.inscripcion_cursos.service;

import com.duoc.inscripcion_cursos.model.Curso;
import com.duoc.inscripcion_cursos.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> obtenerCursos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> obtenerCursoPorId(Long id) {
        return cursoRepository.findById(id);
    }

    public Curso agregarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Optional<Curso> actualizarCurso(Long id, Curso cursoActualizado) {
        return cursoRepository.findById(id)
                .map(cursoExistente -> {
                    cursoExistente.setNombre(cursoActualizado.getNombre());
                    cursoExistente.setDescripcion(cursoActualizado.getDescripcion());
                    cursoExistente.setInstructor(cursoActualizado.getInstructor());
                    cursoExistente.setDuracionHoras(cursoActualizado.getDuracionHoras());
                    cursoExistente.setCosto(cursoActualizado.getCosto());
                    cursoExistente.setEstado(cursoActualizado.getEstado());

                    return cursoRepository.save(cursoExistente);
                });
    }

    public boolean eliminarCurso(Long id) {
        if (!cursoRepository.existsById(id)) {
            return false;
        }

        cursoRepository.deleteById(id);
        return true;
    }
}