package com.duoc.inscripcion_cursos.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;

import java.nio.file.Path;

@Service
public class S3Service {

    private final S3Client s3Client;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    public S3Service(@Value("${aws.region}") String region) {
        this.s3Client = S3Client.builder()
                .region(Region.of(region))
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();
    }

    public String subirArchivo(String rutaArchivo, Long resumenId) {
        String nombreArchivo = "resumen-" + resumenId + ".txt";
        String key = "resumenes/" + resumenId + "/" + nombreArchivo;

        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();

        s3Client.putObject(request, RequestBody.fromFile(Path.of(rutaArchivo)));

        return "Archivo subido correctamente a S3: " + key;
    }

public String descargarArchivo(Long resumenId) {
    String nombreArchivo = "resumen-" + resumenId + ".txt";
    String key = "resumenes/" + resumenId + "/" + nombreArchivo;
    String rutaDescarga = "descargado-" + nombreArchivo;

    GetObjectRequest request = GetObjectRequest.builder()
            .bucket(bucketName)
            .key(key)
            .build();

    s3Client.getObject(request, Path.of(rutaDescarga));

    return "Archivo descargado correctamente desde S3: " + rutaDescarga;
}

public String eliminarArchivo(Long resumenId) {
    String nombreArchivo = "resumen-" + resumenId + ".txt";
    String key = "resumenes/" + resumenId + "/" + nombreArchivo;

    DeleteObjectRequest request = DeleteObjectRequest.builder()
            .bucket(bucketName)
            .key(key)
            .build();

    s3Client.deleteObject(request);

    return "Archivo eliminado correctamente de S3: " + key;
}

public String actualizarArchivo(String rutaArchivo, Long resumenId) {
    return subirArchivo(rutaArchivo, resumenId);
}
}