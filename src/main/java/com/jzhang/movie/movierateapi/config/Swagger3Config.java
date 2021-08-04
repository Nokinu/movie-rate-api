package com.jzhang.movie.movierateapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger3Config {

    @Bean
    public Docket webApiConfig() {
       return new Docket(DocumentationType.SWAGGER_2)
               .groupName("Movie-Rate-API")
               .apiInfo(webApiInfo())
               .select()
               .paths(PathSelectors.regex("/movies/.*"))
               .build();
    }

    @Bean
    public ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("Movie API Doc")
                .description("To describe the API")
                .version("1.0")
                .contact(new Contact("jzhang", "https://", "gmail"))
                .build();
    }
}
