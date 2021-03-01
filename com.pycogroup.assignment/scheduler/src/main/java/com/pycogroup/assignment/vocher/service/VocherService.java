package com.pycogroup.assignment.vocher.service;

import com.pycogroup.assignment.integration.json.EvocherJSON;
import com.pycogroup.assignment.vocher.entity.Vocher;
import com.pycogroup.assignment.vocher.entity.VocherPk;

import java.util.concurrent.CompletableFuture;

public interface VocherService {

    void updateVocher(EvocherJSON evocherJSON);

}
