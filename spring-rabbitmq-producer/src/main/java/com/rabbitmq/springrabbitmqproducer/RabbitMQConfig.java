package com.rabbitmq.springrabbitmqproducer;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.directExchange}")
    String directExchange;

    @Value("${spring.rabbitmq.topicExchange}")
    String topicExchange;

    @Value("${spring.rabbitmq.directKey}")
    String directKey;

    @Value("${spring.rabbitmq.topicKey}")
    String topicKey;

//    @Bean
//    Queue queue1() {
//        return new  Queue("employeeAdd", true);
//    }
//
//    @Bean
//    Queue queue2() {
//        return new  Queue("employeeDelete", true);
//    }
//
//
//    @Bean
//    DirectExchange exchange1() {
//        return new DirectExchange(directExchange);
//    }
//
//
//    @Bean
//    TopicExchange exchange2() {
//        return new TopicExchange(topicExchange);
//    }
//
//    @Bean
//    Binding binding1(Queue queue1, DirectExchange exchange1) {
//        return BindingBuilder.bind(queue1).to(exchange1).with(directKey);
//    }
//
//    @Bean
//    Binding binding2(Queue queue2, TopicExchange exchange2) {
//        return BindingBuilder.bind(queue2).to(exchange2).with(topicKey);
//    }

    @Bean
    public Declarables directBindings() {
        Queue directQueue1 = new Queue("employeeAdd", true);

        DirectExchange directExchange1 = new DirectExchange(directExchange);

        return new Declarables(
                directQueue1,
                directExchange1,
                BindingBuilder
                        .bind(directQueue1)
                        .to(directExchange1).with(directKey));
    }

    @Bean
    public Declarables topicBindings() {
        Queue topicQueue1 = new Queue("employeeDelete", true);

        TopicExchange topicExchange1 = new TopicExchange(topicExchange);

        return new Declarables(
                topicQueue1,
                topicExchange1,
                BindingBuilder
                        .bind(topicQueue1)
                        .to(topicExchange1).with(topicKey));
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
