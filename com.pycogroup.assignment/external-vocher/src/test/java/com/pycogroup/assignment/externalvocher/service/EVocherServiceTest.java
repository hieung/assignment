package com.pycogroup.assignment.externalvocher.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.ResponseEntity;

@RunWith(PowerMockRunner.class)
@PrepareForTest(RandomStringUtils.class)
public class EVocherServiceTest {

    @InjectMocks
    EVocherService eVocherService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void happyCase() {
        PowerMockito.mockStatic(RandomStringUtils.class);
        PowerMockito.when(RandomStringUtils.random(10, true, true)).thenReturn("abcdefgh123");
        PowerMockito.when(RandomStringUtils.random(1, false, true)).thenReturn("1");
        ResponseEntity<?> result = eVocherService.generateEvocher("0987123456");
        assert (result.getStatusCode().is2xxSuccessful());
    }

    @Test
    public void failCase() {
        PowerMockito.mockStatic(RandomStringUtils.class);
        PowerMockito.when(RandomStringUtils.random(10, true, true)).thenReturn("abcdefgh123");
        PowerMockito.when(RandomStringUtils.random(1, false, true)).thenReturn("8");
        ResponseEntity<?> result = eVocherService.generateEvocher("0987123456");
        assert (result.getStatusCode().is5xxServerError());
    }
}
