package com.pycogroup.assignment.vocher.service.impl;

import com.pycogroup.assignment.integration.json.EvocherJSON;
import com.pycogroup.assignment.vocher.entity.Vocher;
import com.pycogroup.assignment.vocher.entity.VocherPk;
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
    HistoryService historyService;

    @Override
    public void updateVocher(EvocherJSON evocherJSON) {
//        System.out.println("evocherJSON --------" + evocherJSON.toString());
//        Optional<Vocher> vocherOptional = vocherRepository.findById(new VocherPk(evocherJSON.getSimcard(), evocherJSON.getDateCreated()));
//        if (vocherOptional.isPresent()) {
//            Vocher vocher = vocherOptional.get();
//            System.out.println("---------" + vocher.toString());
//            if (evocherJSON.getStatus() != null) {
//                vocher.setStatus(evocherJSON.getStatus());
//            }
//            if (evocherJSON.getEvocher() != null) {
//                vocher.setVocher(evocherJSON.getEvocher());
//            }
//            if (evocherJSON.getDateCreated() != null) {
//                vocher.setActionDate(evocherJSON.getActionDate());
//            }
//            vocherRepository.save(vocher);
//            historyService.createHistory(vocher);
//        }
    }
}


