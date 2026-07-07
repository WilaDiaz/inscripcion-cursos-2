package com.duoc.inscripcion_cursos.service;

import com.duoc.inscripcion_cursos.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class InscripcionProducer {

    private final RabbitTemplate rabbitTemplate;

    public InscripcionProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarResumen(String resumen) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, resumen);
    }
}