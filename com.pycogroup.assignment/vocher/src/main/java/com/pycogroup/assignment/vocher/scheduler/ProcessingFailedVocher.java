package com.pycogroup.assignment.vocher.scheduler;

import com.pycogroup.assignment.vocher.entity.Vocher;
import com.pycogroup.assignment.vocher.event.RabbitMQSender;
import com.pycogroup.assignment.vocher.repository.VocherRepository;
import com.pycogroup.assignment.vocher.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Component
public class ProcessingFailedVocher {

    @Autowired
    VocherRepository vocherRepository;

    @Autowired
    HistoryService historyService;

    @Autowired
    RabbitMQSender rabbitMQSender;

    @Scheduled(cron = "10 * * * * *")
    public void resubmitFailedVocher() {
        System.out.println("Scheduler CRONJOB 10s -----");
        List<Vocher> vocherLs = vocherRepository.findFailedVocher();
        for (Vocher vocher : vocherLs) {
            vocher.setStatus("Send");
            vocher.setActionDate(Timestamp.from(Instant.now()));
            rabbitMQSender.send(vocher);
            historyService.createHistory(vocher);
        }
    }
}
