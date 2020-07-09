package com.rabbitmq.springrabbitmqproducer.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSenderImpl {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String message, String key, String exchange) {
        rabbitTemplate.convertAndSend(exchange, key, message);
        System.out.println("Details sent to queue");
    }
}
