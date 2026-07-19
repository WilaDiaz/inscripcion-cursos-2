package com.duoc.inscripcion_cursos.service;

import com.duoc.inscripcion_cursos.model.Curso;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class ResumenService {

    private final InscripcionProducer inscripcionProducer;
    private final S3Service s3Service;

    public ResumenService(
            InscripcionProducer inscripcionProducer,
            S3Service s3Service
    ) {
        this.inscripcionProducer = inscripcionProducer;
        this.s3Service = s3Service;
    }

    public String generarResumen(Curso curso) throws IOException {

        String resumen = "RESUMEN DEL CURSO\n" +
                "-----------------\n" +
                "ID: " + curso.getId() + "\n" +
                "Nombre: " + curso.getNombre() + "\n" +
                "Instructor: " + curso.getInstructor() + "\n" +
                "Duración: " + curso.getDuracionHoras() + " horas\n" +
                "Costo: $" + curso.getCosto() + "\n";

        String nombreArchivo = "resumen-" + curso.getId() + ".txt";

        File archivo = new File(nombreArchivo);

        try (FileWriter writer = new FileWriter(archivo)) {
            writer.write(resumen);
        }

        inscripcionProducer.enviarResumen(resumen);

        String resultadoS3 = s3Service.subirArchivo(
                archivo.getAbsolutePath(),
                curso.getId()
        );

        return "Resumen generado, enviado a RabbitMQ y almacenado en S3. "
                + resultadoS3;
    }
}