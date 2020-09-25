package com.pycogroup.assignment.integration.event;

import com.pycogroup.assignment.integration.service.ProcessingEvocherService;
import com.pycogroup.assignment.vocher.entity.Vocher;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQReceiver {

    @Autowired
    ProcessingEvocherService processingEvocherService;

    @RabbitListener(queues = "vocher.queue")
    public void listen(Vocher vocher) {
        System.out.println("Receive message from vocher.queue " + vocher.toString());
        processingEvocherService.getEvocherFromExternalSystem(vocher);
    }
}
