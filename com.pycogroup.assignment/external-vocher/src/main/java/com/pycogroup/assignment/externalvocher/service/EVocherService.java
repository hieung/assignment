package com.pycogroup.assignment.externalvocher.service;

import com.pycogroup.assignment.externalvocher.json.EvocherJSON;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class EVocherService {

    public ResponseEntity<? extends Object> generateEvocher(String simcard){

        int characterLength = 10;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(characterLength, useLetters, useNumbers);

        String number = RandomStringUtils.random(1, false, true);
        System.out.println("Simcard Number: "+simcard);
        int no = Integer.parseInt(number);

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
