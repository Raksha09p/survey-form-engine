package com.walmart.surveyformengine.initialization.components;

import com.walmart.enginecommons.exceptions.SurveyFormException;
import com.walmart.enginecommons.exceptions.SurveyFormSerializationException;
import com.walmart.surveyformengine.service.RegistrationService;
import com.walmart.surveyformengine.initialization.models.SurveyFormContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class SurveyFormRegistrationService {

    private RestTemplate restTemplate;

    private ObjectMapper objectMapper;

    private RegistrationService registrationService;

    public SurveyFormRegistrationService(@Autowired ObjectMapper objectMapper,
                                             @Autowired RestTemplate restTemplate,
                                             @Autowired RegistrationService registrationService) {
        this.objectMapper = objectMapper;
        this.restTemplate = restTemplate;
        this.registrationService = registrationService;
}

    public void registerGlobalSurveyForm(SurveyFormContract surveyFormContract, String registrationUrl) throws SurveyFormException
           {

        String requestPayload = null;
        try {

            requestPayload = objectMapper.writeValueAsString(surveyFormContract);

        } catch (JsonProcessingException e) {

            log.error("Failed to register survey Form contracts : {} due to {}", surveyFormContract, e);
            throw new SurveyFormSerializationException(
                    String.format("Failed to serialize Survey Form - %s to register", surveyFormContract), e);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(requestPayload, headers);

        ResponseEntity<String> httpStatus = registrationService.invokeAPI(request, HttpMethod.POST, registrationUrl, restTemplate);

        if (HttpStatus.OK.equals(httpStatus)) {
            log.info("survey form contract loaded successfully");
        }

    }
}
