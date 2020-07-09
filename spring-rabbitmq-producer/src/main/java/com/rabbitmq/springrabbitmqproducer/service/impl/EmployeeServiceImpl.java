package com.rabbitmq.springrabbitmqproducer.service.impl;

import com.rabbitmq.springrabbitmqproducer.entity.Employee;
import com.rabbitmq.springrabbitmqproducer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    RabbitMQSenderImpl rabbitMQSender;

    @Value("${spring.rabbitmq.directExchange}")
    String directExchange;

    @Value("${spring.rabbitmq.topicExchange}")
    String topicExchange;

    @Value("${spring.rabbitmq.directKey}")
    String directKey;

    @Value("${spring.rabbitmq.topicKey}")
    String topicKey;

    public void saveEmployee(Employee employee){
        System.out.println("Received employee information : " + employee);

        //Send data to queue
        rabbitMQSender.send("New Employee Added",directKey,directExchange );

    }

    public void removeEmployee(){
        System.out.println("Received employee information : ");

        //Send data to queue
        String keyToSend = topicKey.replace("#", "removed");
        rabbitMQSender.send("Employee Removed",keyToSend,topicExchange );

    }


}
