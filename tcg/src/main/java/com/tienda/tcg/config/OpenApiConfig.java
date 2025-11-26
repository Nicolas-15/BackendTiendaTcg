package com.tienda.tcg.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Tienda TCG")
                        .version("1.0.0")
                        .description("Documentación Swagger para la tienda online TCG, incluyendo endpoints CRUD y autenticación"));
    }
}
