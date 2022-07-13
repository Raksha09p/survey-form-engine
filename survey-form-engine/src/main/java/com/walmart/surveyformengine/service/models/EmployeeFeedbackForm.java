package com.walmart.surveyformengine.service.models;
import com.walmart.enginecommons.commons.annotations.*;
import lombok.Data;

@Data
@SurveyFormConfiguration(
        name = "Employee Feedback Form",
        version = "1.0.0",
        displayName = "Employee Feedback Form",
        description = "Form to collect employee's feedback",
        controlType = "FORM",
        isDeprecated = false,
        documentationLink = "some link")
public class EmployeeFeedbackForm {

    public static final String CLASS_IDENTIFIER = "Employee Feedback Form";

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

    @Tooltip(displayName = "E-mail", description = "Please mention your e-mail")
    @Required
    @Order(3)
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
    @Size
    private String email;

    @Tooltip(displayName = "Contact number", description = "Please mention your contact number")
    @Required
    @Order(4)
    @Pattern(regexp = "^(0|[1-9][0-9]*)$")
    @Size(min= 10,max = 10)
    private String contact;

    @Tooltip(displayName = " Department name", description = "Please mention the name of your department")
    @Required
    @Order(5)
    @Pattern(regexp = "^[a-zA-Z]*$")
    @Size
    private String deptName;

    @Tooltip(displayName = " Are you given enough guidance to perform your job?", description = "Please elaborate")
    @Required
    @Order(6)
    @Pattern(regexp = "^[a-zA-Z0-9_]*$")
    @Size
    private String guidance;

    @Tooltip(displayName = "Are you given adequate opportunities to develop your skills?", description = "Please elaborate")
    @Required
    @Order(7)
    @Pattern(regexp = "^[a-zA-Z0-9_]*$")
    @Size
    private String opportunities;

    @Tooltip(displayName = " Tell us how we can improve", description = "Please provide any additional comments or suggestions")
    @Required
    @Order(8)
    @Pattern(regexp = "^[a-zA-Z0-9_]*$")
    @Size
    private String feedback;


}