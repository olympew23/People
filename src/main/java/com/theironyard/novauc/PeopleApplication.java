package com.theironyard.novauc;



import com.theironyard.novauc.entities.Person;
import io.swagger.annotations.Contact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.annotation.Annotation;

@SpringBootApplication
@EnableSwagger2


public class PeopleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeopleApplication.class, args);
	}

	@Bean
	public Docket swaggerSettings() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(""))
				.paths(PathSelectors.regex("/people.*"))
				.build()
				.pathMapping("/")
				.apiInfo(metaData());

	}

	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo(
				"Spring Boot REST API",
				"Spring Boot REST API for Online Store",
				"1.0",
				"Terms of service",
				"Olympew Jordan", "https://git.heroku.com/lit-beach-24368.git",
				"Apache License Version 2.0");


	return apiInfo;


	}



}




