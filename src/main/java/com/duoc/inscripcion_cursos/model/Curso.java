package com.duoc.inscripcion_cursos.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "CURSOS")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(length = 500)
    private String descripcion;

    @Column(nullable = false, length = 150)
    private String instructor;

    @Column(name = "duracion_horas", nullable = false)
    private Integer duracionHoras;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal costo;

    @Column(nullable = false, length = 20)
    private String estado = "ACTIVO";

    public Curso() {
    }

    public Curso(
            String nombre,
            String descripcion,
            String instructor,
            Integer duracionHoras,
            BigDecimal costo,
            String estado
    ) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.instructor = instructor;
        this.duracionHoras = duracionHoras;
        this.costo = costo;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public Integer getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(Integer duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
