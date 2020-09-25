package com.pycogroup.assignment.vocher.service;

import com.pycogroup.assignment.integration.json.EvocherJSON;
import com.pycogroup.assignment.vocher.entity.Vocher;
import com.pycogroup.assignment.vocher.entity.VocherPk;

import java.util.concurrent.CompletableFuture;

public interface VocherService {

    Vocher createNewVocherBySimcard(String simcard);

    Vocher createVocher(String simcard);

    void updateVocher(EvocherJSON evocherJSON);

    CompletableFuture<Vocher> getVocher(VocherPk vocherPk) throws InterruptedException;
}
