package com.leandro.apiaccount.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@OpenAPIDefinition(security = {@SecurityRequirement(name = "bearer-key")})
public class SwaggerConfig {

    @Value("${leandro.openapi.dev-url}")
    private String devUrl;

    @Value("${leandro.openapi.prod-url}")
    private String prodUrl;

    public static final String BEARER_JWT = "bearer-jwt";

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .components(getComponents())
                .info(info())
                .servers(servers());
    }

    private List<Server> servers() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server URL in Production environment");
        return List.of(devServer, prodServer);

    }

    private License license() {
        return new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");
    }

    private Contact contact() {
        Contact contact = new Contact();
        contact.setEmail("leandrobhmgg@gmail.com");
        contact.setName("Leandro");
        contact.setUrl("https://leandrosilveira.dev/");
        return contact;

    }

    private Info info() {

        return new Info()
                .title("Account Management API")
                .version("1.0")
                .contact(contact())
                .description("This API exposes endpoints to manage tutorials.").termsOfService("https://leandrosilveira.dev/")
                .license(license());
    }

    private Components getComponents() {

        return new Components()
                .addSecuritySchemes("bearer-key",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT"));
    }
}
