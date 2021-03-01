package com.pycogroup.assignment.vocher.scheduler;

import com.google.gson.Gson;
import com.pycogroup.assignment.integration.json.EvocherJSON;
import com.pycogroup.assignment.vocher.entity.Vocher;
import com.pycogroup.assignment.vocher.repository.VocherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Component
public class ProcessingFailedVocher {

    @Value("${api.evocher.url}")
    String url;

    @Autowired
    VocherRepository vocherRepository;

    @Scheduled(cron = "3 * * * * *")
    public void schedulerFailedVocher() {
        System.out.println("Scheduler CRONJOB 3s -----");
        List<Vocher> vocherLs = vocherRepository.findByStatus("Failed");

        vocherLs.forEach(System.out::println);
        vocherLs.stream().forEach(vocher -> {
            System.out.println(vocher.toString());
            vocher.setStatus("Send");
            vocher.setActionDate(Timestamp.from(Instant.now()));
            resubmitFailedVocher(vocher);
        });
    }

    private void resubmitFailedVocher(Vocher vocher) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("simcard", vocher.getVocherPk().getSimcard());
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        Gson gson = new Gson();
        EvocherJSON evocherJSON = new EvocherJSON();
        evocherJSON = gson.fromJson(response.getBody(), EvocherJSON.class);
        System.out.println("Result: " + evocherJSON.toString());
    }
}
