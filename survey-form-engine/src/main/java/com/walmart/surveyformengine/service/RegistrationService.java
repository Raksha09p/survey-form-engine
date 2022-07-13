package com.walmart.surveyformengine.service;

import com.walmart.enginecommons.exceptions.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class RegistrationService {
    private static final String SERVICE_RESPONSE = " services responded with Status Code : ";
    private static final String ENDPOINT_ATTEMPT = "Endpoint attempted: ";

    public ResponseEntity<String> invokeAPI(HttpEntity<String> request, HttpMethod method, String endpoint,
                                            RestTemplate restTemplate) throws SurveyFormException {
        log.info("");
        ResponseEntity<String> response = null;

        try {
            response = restTemplate.exchange(endpoint, method, request, String.class);

            log.info("Response from services: " + response.getStatusCode());
        } catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
            String errorStr = ("Error communicating with Api Layer " + "Method Attempted: " + method.name()
                    + ENDPOINT_ATTEMPT + endpoint + SERVICE_RESPONSE + httpClientOrServerExc.getStatusCode()
                    + " and Response Body : " + httpClientOrServerExc.getResponseBodyAsString());

            log.error(errorStr);
            throw new SurveyFormApiCommunicationFailedException(errorStr, httpClientOrServerExc);

        } catch (Exception e) {
            throw new SurveyFormException("Some error occurred");
             }

        return response;
    }
}
