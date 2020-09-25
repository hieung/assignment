package com.pycogroup.assignment.vocher.event;

import com.pycogroup.assignment.vocher.entity.Vocher;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${vocher.rabbitmq.queue}")
    String queueName;

    @Value("${vocher.rabbitmq.exchange}")
    String exchange;

    @Value("${vocher.rabbitmq.routingkey}")
    String routingkey;

    public void send(Vocher vocher) {
        System.out.println("Vocher received from vocher.queue : " + vocher.toString());
        rabbitTemplate.convertAndSend(exchange, routingkey, vocher);
    }
}
