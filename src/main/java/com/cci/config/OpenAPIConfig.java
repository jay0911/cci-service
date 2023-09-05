package com.cci.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("UAAS Service API")
                        .description("User Authentication and Authorization Service")
                        .version("v1.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("LLD")
                        .url("https://collaborate.pruconnect.net/x/OC3SDQ"));
    }
}

