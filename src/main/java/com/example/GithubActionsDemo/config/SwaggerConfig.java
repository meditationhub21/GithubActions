package com.example.GithubActionsDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket postsApi(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("Github Action Demo").apiInfo(apiInfo()).select()
                .paths(regex("/api/student.*")).build();

    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("Github Action Service")
                .description("Sample Documentation Generated Using SEAGGER2 for our Rest API's.")
                .version("1.0").build();
    }
}
