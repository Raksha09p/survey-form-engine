package com.walmart.surveyformengine.service.models;

import com.walmart.enginecommons.commons.annotations.*;
import lombok.Data;

@Data
@SurveyFormConfiguration(
        name = "Workshop Registration Form",
        version = "1.0.0",
        displayName = "Workshop Registration Form",
        description = "Form to register for the workshop",
        controlType = "FORM",
        isDeprecated = false,
        documentationLink = "some link")

public class WorkshopRegistrationForm {

    public static final String CLASS_IDENTIFIER = "Workshop Registration Form";

    @Tooltip(displayName = "Employee ID", description = "Please mention your user ID")
    @Required
    @Order(1)
    @Pattern(regexp = "^[a-zA-Z0-9_]*$")
    @Size
    private String employeeId;

    @Tooltip(displayName = "Name", description = "Please mention your name")

    @Required
    @Order(2)
    @Pattern(regexp = "^[A-Za-z]*$")
    @Size
    private String name;

    @Tooltip(displayName = " Department name", description = "Please mention the name of your department")
    @Required
    @Order(3)
    @Pattern(regexp = "^[a-zA-Z]*$")
    @Size
    private String deptName;

}

