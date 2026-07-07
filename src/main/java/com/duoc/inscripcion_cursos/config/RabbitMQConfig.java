package com.duoc.inscripcion_cursos.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "cola.inscripciones";

    @Bean
    public Queue inscripcionesQueue() {
        return new Queue(QUEUE_NAME, true);
    }
}