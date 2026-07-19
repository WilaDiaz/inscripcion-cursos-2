package com.duoc.inscripcion_cursos.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "INSCRIPCIONES",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "UK_INSCRIPCION_CURSO_ESTUDIANTE",
            columnNames = {"curso_id", "estudiante_id"}
        )
    }
)
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @Column(name = "estudiante_id", nullable = false, length = 150)
    private String estudianteId;

    @Column(name = "estudiante_nombre", nullable = false, length = 150)
    private String estudianteNombre;

    @Column(name = "estudiante_email", nullable = false, length = 200)
    private String estudianteEmail;

    @Column(name = "fecha_inscripcion", nullable = false)
    private LocalDateTime fechaInscripcion;

    @Column(nullable = false, length = 30)
    private String estado = "INSCRITO";

    public Inscripcion() {
    }

    @PrePersist
    public void asignarFechaInscripcion() {
        if (fechaInscripcion == null) {
            fechaInscripcion = LocalDateTime.now();
        }

        if (estado == null || estado.isBlank()) {
            estado = "INSCRITO";
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(String estudianteId) {
        this.estudianteId = estudianteId;
    }

    public String getEstudianteNombre() {
        return estudianteNombre;
    }

    public void setEstudianteNombre(String estudianteNombre) {
        this.estudianteNombre = estudianteNombre;
    }

    public String getEstudianteEmail() {
        return estudianteEmail;
    }

    public void setEstudianteEmail(String estudianteEmail) {
        this.estudianteEmail = estudianteEmail;
    }

    public LocalDateTime getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDateTime fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}