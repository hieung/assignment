package com.pycogroup.assignment.integration.event;

import com.pycogroup.assignment.integration.json.EvocherJSON;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${evocher.rabbitmq.queue}")
    String queueName;

    @Value("${evocher.rabbitmq.exchange}")
    String exchange;

    @Value("${evocher.rabbitmq.routingkey}")
    String routingkey;

    public void send(EvocherJSON evocherJSON) {
        System.out.println("Send message from evocher.queue " + evocherJSON.toString());
        rabbitTemplate.convertAndSend(exchange, routingkey, evocherJSON);
    }
}
