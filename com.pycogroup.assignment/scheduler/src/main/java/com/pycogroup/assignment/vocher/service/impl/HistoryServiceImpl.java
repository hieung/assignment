package com.pycogroup.assignment.vocher.service.impl;

import com.pycogroup.assignment.vocher.entity.History;
import com.pycogroup.assignment.vocher.entity.Vocher;
import com.pycogroup.assignment.vocher.repository.HistoryRepository;
import com.pycogroup.assignment.vocher.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    HistoryRepository historyRepository;

    @Override
    public void save(History history) {
        historyRepository.save(history);
    }

    @Override
    public void createHistory(Vocher vocher) {
        History history = History.builder()
                .status(vocher.getStatus())
                .interactionDate(vocher.getActionDate())
                .simcard(vocher.getVocherPk().getSimcard())
                .build();

        historyRepository.save(history);
    }
}
