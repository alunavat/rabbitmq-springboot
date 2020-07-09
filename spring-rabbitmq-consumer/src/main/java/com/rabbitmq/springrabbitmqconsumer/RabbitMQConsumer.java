package com.rabbitmq.springrabbitmqconsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class RabbitMQConsumer {

    @RabbitListener(queues = "employeeAdd")
    public void recievedMessage(String employee) {
        System.out.println("Recieved Message From RabbitMQ: " + employee);
    }


    @RabbitListener(queues = "employeeDelete")
    public void recievedDeleteMessage(String employee) {
        System.out.println("Recieved Message From RabbitMQ: " + employee);
    }
}
