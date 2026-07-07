package com.duoc.inscripcion_cursos.service;

import com.duoc.inscripcion_cursos.config.RabbitMQConfig;
import com.duoc.inscripcion_cursos.model.ResumenInscripcion;
import com.duoc.inscripcion_cursos.repository.ResumenInscripcionRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class InscripcionConsumer {

    private final ResumenInscripcionRepository repository;

    public InscripcionConsumer(ResumenInscripcionRepository repository) {
        this.repository = repository;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void recibirResumen(String resumen) {
        System.out.println("Mensaje recibido desde RabbitMQ: " + resumen);

        ResumenInscripcion resumenInscripcion = new ResumenInscripcion(resumen);

        repository.save(resumenInscripcion);
    }
}