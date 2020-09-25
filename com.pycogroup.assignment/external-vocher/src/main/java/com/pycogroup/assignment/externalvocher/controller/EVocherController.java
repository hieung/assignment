package com.pycogroup.assignment.externalvocher.controller;

import com.pycogroup.assignment.externalvocher.json.EvocherJSON;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.Instant;

@RestController
public class EVocherController {

    @PostMapping("/evocher")
    public ResponseEntity<EvocherJSON> getVocherCode(@RequestParam("simcard") String simcard) {

        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        String number = RandomStringUtils.random(1, false, true);
        int no = Integer.parseInt(number);
        System.out.println("Simcard Number: "+simcard);

        if (no < 2) {
            System.out.println("Create Evocher Successfully: " + generatedString);
            EvocherJSON evocher = new EvocherJSON(generatedString, simcard, Timestamp.from(Instant.now()));
            evocher.setEvocher(generatedString);
            return new ResponseEntity<EvocherJSON>(evocher, HttpStatus.CREATED);
        } else {
            System.out.println("Create Evocher Failed");
            return new ResponseEntity<>(null, HttpStatus.GATEWAY_TIMEOUT);
        }

    }

}
