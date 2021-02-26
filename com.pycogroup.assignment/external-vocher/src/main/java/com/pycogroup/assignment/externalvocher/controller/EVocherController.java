package com.pycogroup.assignment.externalvocher.controller;

import com.pycogroup.assignment.externalvocher.service.EVocherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EVocherController {

    @Autowired
    EVocherService evocherService;

    @PostMapping("/evocher")
    public ResponseEntity<?> getVocherCode(@RequestParam("simcard") String simcard) {
        return evocherService.generateEvocher(simcard);
    }

}
