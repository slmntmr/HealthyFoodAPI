package com.example.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()// http://<railway-url>/swagger-ui/index.html

                        .title("Food-Disease API Documentation")
                        .version("1.0.0")
                        .description("This is the API documentation for the Food and Disease application."));
    }
}
