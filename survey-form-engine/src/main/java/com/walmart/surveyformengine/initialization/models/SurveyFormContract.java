package com.walmart.surveyformengine.initialization.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.walmart.surveyformengine.service.models.SurveyFormConfiguration;
import com.fasterxml.jackson.annotation.JsonRawValue;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class SurveyFormContract {

    private String surveyName;
    private String lastUpdatedBy;

    private ContractMetaData contractMetaData;

    @JsonRawValue
    private String serviceSchema;

    public SurveyFormContract(Object bean, String serviceSchema, String lastUpdatedBy) {

        this.surveyName = bean.getClass().getSimpleName();

        SurveyFormConfiguration surveyConfiguration = bean.getClass()
                .getAnnotation(SurveyFormConfiguration.class);

        if (surveyConfiguration != null) {
            this.contractMetaData = new ContractMetaData(surveyConfiguration);

        }

        this.serviceSchema = serviceSchema;
        this.lastUpdatedBy = lastUpdatedBy;
    }
}
