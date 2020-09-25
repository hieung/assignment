package com.pycogroup.assignment.vocher.event;

import com.pycogroup.assignment.integration.json.EvocherJSON;
import com.pycogroup.assignment.vocher.service.VocherService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQReceiver {

    @Autowired
    VocherService vocherService;

    @RabbitListener(queues = "evocher.queue")
    public void listen(EvocherJSON evocherJSON) {
        System.out.println("Evocher received from evocher.queue : " + evocherJSON.toString());
        vocherService.updateVocher(evocherJSON);
    }
}
