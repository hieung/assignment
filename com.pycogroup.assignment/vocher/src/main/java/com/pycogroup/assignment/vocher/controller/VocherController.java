package com.pycogroup.assignment.vocher.controller;

import com.pycogroup.assignment.vocher.entity.Vocher;
import com.pycogroup.assignment.vocher.repository.VocherRepository;
import com.pycogroup.assignment.vocher.service.VocherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class VocherController {

    @Autowired
    VocherService vocherService;

    @Autowired
    VocherRepository vocherRepository;

    @PostMapping("/vocher")
    public ResponseEntity<? extends Serializable> getVocherCode(@RequestParam("simcard") String simcard) throws ExecutionException, InterruptedException {
        String result = "";
        System.out.println(simcard);
        Vocher vocherRequest = vocherService.createNewVocherBySimcard(simcard);
        CompletableFuture<Vocher> vocherResponse = vocherService.getVocher(vocherRequest.getVocherPk());
        if (vocherResponse == null) {
            return new ResponseEntity<String>("Vocher will send through SMS later", HttpStatus.SERVICE_UNAVAILABLE);
        }
        Vocher vocher = vocherResponse.get();

        return new ResponseEntity<Vocher>(vocher, HttpStatus.CREATED);
    }

}
