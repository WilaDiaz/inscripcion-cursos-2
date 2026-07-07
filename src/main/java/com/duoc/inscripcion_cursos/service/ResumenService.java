package com.duoc.inscripcion_cursos.service;

import com.duoc.inscripcion_cursos.model.Curso;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class ResumenService {

    private final InscripcionProducer inscripcionProducer;

    public ResumenService(InscripcionProducer inscripcionProducer) {
        this.inscripcionProducer = inscripcionProducer;
    }

    public String generarResumen(Curso curso) throws IOException {

        String resumen = "RESUMEN DEL CURSO\n" +
                "-----------------\n" +
                "ID: " + curso.getId() + "\n" +
                "Nombre: " + curso.getNombre() + "\n" +
                "Instructor: " + curso.getInstructor() + "\n" +
                "Duración: " + curso.getDuracion() + " horas\n" +
                "Costo: $" + curso.getCosto() + "\n";

        String nombreArchivo = "resumen-" + curso.getId() + ".txt";

        File archivo = new File(nombreArchivo);

        FileWriter writer = new FileWriter(archivo);
        writer.write(resumen);
        writer.close();

        inscripcionProducer.enviarResumen(resumen);

        return "Resumen generado y enviado a RabbitMQ: " + archivo.getAbsolutePath();
    }
}