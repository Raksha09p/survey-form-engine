package com.walmart.surveyformengine.service.models;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


import lombok.extern.slf4j.Slf4j;

@Configuration
@ComponentScan(basePackages = {
        "com.walmart.surveyformengine.service.models","com.walmart.enginecommons.commons" }, includeFilters = {
        @ComponentScan.Filter(SurveyFormConfiguration.class) })
@Slf4j
public class GlobalSurveyFormConfiguration {

    @PostConstruct
    public void postConstruct() {

        log.info("Survey Form Configuration INCLUDED");
    }
}