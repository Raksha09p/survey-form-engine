package com.walmart.surveyformengine;

import com.walmart.surveyformengine.service.models.EnableSurveyFormConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableSurveyFormConfiguration
@SpringBootApplication
public class SurveyFormEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurveyFormEngineApplication.class, args);
	}

}
