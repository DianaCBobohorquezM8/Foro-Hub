package com.forohub.foro.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {


    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT"))
                )
                .info(new Info()
                        .title("ForoHub API")
                        .description("API para el foro educativo ForoHub")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Soporte ForoHub")
                                .url("https://foroHub.api/contact")
                                .email("soporte@foroHub.api"))
                        .license(new License() .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")));
    }
}
