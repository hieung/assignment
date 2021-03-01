package com.pycogroup.assignment.vocher.service.impl;

import com.pycogroup.assignment.vocher.entity.Simcard;
import com.pycogroup.assignment.vocher.repository.SimcardRepository;
import com.pycogroup.assignment.vocher.service.SimcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimcardServiceImpl implements SimcardService {

    @Autowired
    SimcardRepository simcardRepository;

    @Override
    public Simcard findBySimcard(String simcard) {
        return simcardRepository.findBySimcard(simcard);
    }

    @Override
    public void create(String simcardNumber) {
        Simcard simcard = new Simcard();
        simcard.setSimcard(simcardNumber);
        simcardRepository.save(simcard);

    }
}
