package com.walmart.surveyformengine.initialization.models;

import com.walmart.surveyformengine.service.models.SurveyFormConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContractMetaData {

    private String  name;
    private String  displayName;
    private String  version;
    private String  controlType;
    @JsonProperty(value = "isDeprecated")
    private boolean isDeprecated;
    private String  description;
    private String  documentationLink;

    public ContractMetaData(SurveyFormConfiguration enableSurveyFormRegistration) {
        this.name = enableSurveyFormRegistration.name();
        this.displayName = enableSurveyFormRegistration.displayName();
        this.controlType = enableSurveyFormRegistration.controlType();
        this.description = enableSurveyFormRegistration.description();
        this.isDeprecated = enableSurveyFormRegistration.isDeprecated();
        this.version = enableSurveyFormRegistration.version();
        this.documentationLink = enableSurveyFormRegistration.documentationLink();
    }
}
