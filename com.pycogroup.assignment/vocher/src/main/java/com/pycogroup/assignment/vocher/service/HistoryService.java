package com.pycogroup.assignment.vocher.service;

import com.pycogroup.assignment.vocher.entity.History;
import com.pycogroup.assignment.vocher.entity.Vocher;
import org.springframework.stereotype.Service;

@Service
public interface HistoryService {

    void save(History history);

    void createHistory(Vocher vocher);

}
