# rabbitmq-springboot

This is a sample application which demostrates use of RabbitMQ with SpringBoot.
Two exchange types of RabbitMQ have been implemented :
1. Direct Exchange
2. Topic Exchange

The producer sends message to queues based on API call. 
1. When a Employee is added the producer puts the message in a Direct Queue with key "employee". 
2. When an Employee is removed the producer puts the message in Topic Queue with key "employee.removed". 

The consumer is able to both queues and receives messages respectively.