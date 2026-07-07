package com.duoc.inscripcion_cursos.controller;

import com.duoc.inscripcion_cursos.service.S3Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/s3")
public class S3Controller {

    private final S3Service s3Service;

    public S3Controller(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @PostMapping("/subir/{id}")
    public String subirResumen(@PathVariable Long id) {
        String rutaArchivo = "resumen-" + id + ".txt";
        return s3Service.subirArchivo(rutaArchivo, id);
    }
@GetMapping("/descargar/{id}")
public String descargarResumen(@PathVariable Long id) {
    return s3Service.descargarArchivo(id);
}

@DeleteMapping("/eliminar/{id}")
public String eliminarResumen(@PathVariable Long id) {
    return s3Service.eliminarArchivo(id);
}

@PutMapping("/actualizar/{id}")
public String actualizarResumen(@PathVariable Long id) {
    String rutaArchivo = "resumen-" + id + ".txt";
    return s3Service.actualizarArchivo(rutaArchivo, id);
}

}