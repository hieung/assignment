package com.pycogroup.assignment.integration.service;

import com.google.gson.Gson;
import com.pycogroup.assignment.integration.event.RabbitMQSender;
import com.pycogroup.assignment.integration.json.EvocherJSON;
import com.pycogroup.assignment.vocher.entity.Vocher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.time.Instant;


@Service
public class ProcessingEvocherService {

    @Value("${api.evocher.url}")
    String url;

    @Autowired
    RabbitMQSender rabbitMQSender;

    public ResponseEntity<EvocherJSON> getEvocherFromExternalSystem(Vocher vocher) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("simcard", vocher.getVocherPk().getSimcard());
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
            Gson gson = new Gson();
            EvocherJSON evocherJSON = new EvocherJSON();
            evocherJSON = gson.fromJson(response.getBody(), EvocherJSON.class);
            evocherJSON.setDateCreated(vocher.getVocherPk().getCreatedDate());
            evocherJSON.setStatus("Success");
            System.out.println("Evocher is created successfully " + evocherJSON.toString());
            if (response.getStatusCode() == HttpStatus.CREATED) {
                System.out.println("Push Evocher to queue" + evocherJSON.toString());
                rabbitMQSender.send(evocherJSON);
            }
            return new ResponseEntity<>(evocherJSON, HttpStatus.CREATED);

        } catch (Exception e) {
            EvocherJSON evocherJSONFail = EvocherJSON.builder()
                    .actionDate(Timestamp.from(Instant.now()))
                    .simcard(vocher.getVocherPk().getSimcard())
                    .dateCreated(vocher.getVocherPk().getCreatedDate())
                    .status("Failed")
                    .evocher(null)
                    .build();

            System.out.println("Evocher could not be created - Fail " + evocherJSONFail.toString());
            System.out.println("Push failed evocher to queue");
            rabbitMQSender.send(evocherJSONFail);
            return new ResponseEntity<>(evocherJSONFail, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
