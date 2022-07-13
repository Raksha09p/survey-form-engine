package com.walmart.surveyformengine.service.models;

import com.walmart.enginecommons.commons.annotations.*;
import lombok.Data;

@Data
@SurveyFormConfiguration(
        name = "Consumer Feedback Form",
        version = "1.0.0",
        displayName = "Consumer Feedback Form",
        description = "Form to collect consumer's feedback",
        controlType = "FORM",
        isDeprecated = false,
        documentationLink = "some link")

public class ConsumerFeedbackForm {

    public static final String CLASS_IDENTIFIER = "Consumer Feedback Form";

    @Tooltip(displayName = "Consumer ID", description = "Please mention your user ID")
    @Required
    @Order(1)
    @Pattern(regexp = "^[a-zA-Z0-9_]*$")
    @Size
    private String consumerId;

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


    @Tooltip(displayName = "Product name", description = "Please mention the name of the product you bought")
    @Required
    @Order(5)
    @Pattern(regexp = "^[A-Za-z]*$")
    @Size
    private String productName;

    @Tooltip(displayName = "Rating", description = "Please rate this product from 1 - 5")
    @Required
    @Order(6)
    @Pattern(regexp = "^[1-5]*$")
    @Size(min= 1,max =1)
    private String rating;


}