package com.pycogroup.assignment.vocher.service.impl;

import com.pycogroup.assignment.integration.json.EvocherJSON;
import com.pycogroup.assignment.vocher.entity.Vocher;
import com.pycogroup.assignment.vocher.entity.VocherPk;
import com.pycogroup.assignment.vocher.event.RabbitMQSender;
import com.pycogroup.assignment.vocher.repository.VocherRepository;
import com.pycogroup.assignment.vocher.service.HistoryService;
import com.pycogroup.assignment.vocher.service.SimcardService;
import com.pycogroup.assignment.vocher.service.VocherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class VocherServiceImpl implements VocherService {

    @Autowired
    VocherRepository vocherRepository;

    @Autowired
    SimcardService simcardService;

    @Autowired
    HistoryService historyService;

    @Autowired
    RabbitMQSender rabbitMQSender;

    @Override
    public Vocher createNewVocherBySimcard(String simcard) {
        //simcard handling
        if (simcardService.findBySimcard(simcard) == null) {
            simcardService.create(simcard);
        }

        Vocher vocher = createVocher(simcard);
        historyService.createHistory(vocher);
        rabbitMQSender.send(vocher);
        return vocher;
    }

    @Override
    public Vocher createVocher(String simcard) {
        Vocher vocher = new Vocher();
        VocherPk vocherPk = new VocherPk();
        vocherPk.setSimcard(simcard);
        Timestamp currentTimestamp = Timestamp.from(Instant.now().truncatedTo(ChronoUnit.SECONDS));
        vocherPk.setCreatedDate(currentTimestamp);
        vocher.setVocherPk(vocherPk);
        vocher.setActionDate(currentTimestamp);
        vocher.setStatus("Send");
        vocherRepository.save(vocher);
        return vocher;
    }

    @Override
    public void updateVocher(EvocherJSON evocherJSON) {
        System.out.println("evocherJSON --------" + evocherJSON.toString());
        Optional<Vocher> vocherOptional = vocherRepository.findById(new VocherPk(evocherJSON.getSimcard(), evocherJSON.getDateCreated()));
        if (vocherOptional.isPresent()) {
            Vocher vocher = vocherOptional.get();
            System.out.println("---------" + vocher.toString());
            if (evocherJSON.getStatus() != null) {
                vocher.setStatus(evocherJSON.getStatus());
            }
            if (evocherJSON.getEvocher() != null) {
                vocher.setVocher(evocherJSON.getEvocher());
            }
            if (evocherJSON.getDateCreated() != null) {
                vocher.setActionDate(evocherJSON.getActionDate());
            }
            vocherRepository.save(vocher);
            historyService.createHistory(vocher);
        }
    }

    @Override
    @Async
    public CompletableFuture<Vocher> getVocher(VocherPk vocherPk) throws InterruptedException {
        System.out.println("------------Delay before 1s");
        Thread.sleep(5000L);
        System.out.println("------------Delay done");
        Optional<Vocher> vocherOptional = vocherRepository.findById(vocherPk);

        if (!vocherOptional.isPresent()) {
            return null;
        }
        return CompletableFuture.completedFuture(vocherOptional.get());
    }
}


