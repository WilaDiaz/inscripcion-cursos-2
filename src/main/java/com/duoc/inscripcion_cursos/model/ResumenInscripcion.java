package com.duoc.inscripcion_cursos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "RESUMEN_INSCRIPCION")
public class ResumenInscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2000)
    private String resumen;

    public ResumenInscripcion() {
    }

    public ResumenInscripcion(String resumen) {
        this.resumen = resumen;
    }

    public Long getId() {
        return id;
    }

    public String getResumen() {
        return resumen;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }
}