package com.walmart.surveyformengine.service.models;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SurveyFormConfiguration {

    public String name() default "";

    public String displayName() default "";

    public String version() default "";

    public String controlType() default "";

    public boolean isDeprecated() default false;

    public String description() default "";

    public String documentationLink() default "";
}
