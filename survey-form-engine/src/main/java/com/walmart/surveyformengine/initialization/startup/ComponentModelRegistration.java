package com.walmart.surveyformengine.initialization.startup;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.walmart.enginecommons.commons.utils.CommonUtil;
import com.walmart.enginecommons.exceptions.SurveyFormException;
import com.walmart.enginecommons.initialization.ContractParserService;
import com.walmart.surveyformengine.initialization.components.SurveyFormRegistrationService;
import com.walmart.surveyformengine.initialization.models.SurveyFormContract;
import com.walmart.surveyformengine.service.models.SurveyFormConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
@Slf4j
public class ComponentModelRegistration {

    private ApplicationContext applicationContext;
    private SurveyFormRegistrationService surveyFormRegistrationService;
    private String hostName;
    private String apiRegistrationUrl = "http://localhost:8080/surveyForm";

    public ComponentModelRegistration(@Autowired ApplicationContext applicationContext,
                                      @Autowired SurveyFormRegistrationService surveyFormRegistrationService) {
        this.applicationContext = applicationContext;
        this.surveyFormRegistrationService = surveyFormRegistrationService;
    }

    @PostConstruct
    public void postConstruct() {
        this.hostName = CommonUtil.getHostName();
    }
    @EventListener
    public void registerServices(ContextRefreshedEvent event) throws SurveyFormException {
        log.info("Extracting Survey Form Configurations");
        Map<Object, String> surveyFormConfigurationSchematics = extractSchematics(
                applicationContext.getBeansWithAnnotation(SurveyFormConfiguration.class));
        log.info("Registering Survey Form Configurations");
        for (Map.Entry<Object, String> surveyFormConfiguration : surveyFormConfigurationSchematics
                .entrySet()) {
            SurveyFormContract surveyFormContract = new SurveyFormContract(surveyFormConfiguration.getKey(),
                    surveyFormConfiguration.getValue(), this.hostName);
            surveyFormRegistrationService.registerGlobalSurveyForm(surveyFormContract, apiRegistrationUrl);
        }
    }
    private Map<Object, String> extractSchematics(Map<String, Object> beans) {

        Map<Object, String> jsonStructures = new HashMap<>();

        for (Map.Entry<String, Object> bean : beans.entrySet()) {
            log.info(bean.getKey());


            JsonIgnoreProperties jsonIgnoreProperties = bean.getValue().getClass()
                    .getDeclaredAnnotation(JsonIgnoreProperties.class);

            List<String> fieldsToIgnore = new ArrayList<>();

            if (jsonIgnoreProperties != null) {
                fieldsToIgnore.addAll(Arrays.asList(jsonIgnoreProperties.value()));
            }

            String jsonStructure = ContractParserService
                    .getSchema(bean.getValue().getClass(),fieldsToIgnore, this.hostName)
                    .toString();

            log.info(jsonStructure);
            jsonStructures.put(bean.getValue(), jsonStructure);

        }

        return jsonStructures;
    }
}


