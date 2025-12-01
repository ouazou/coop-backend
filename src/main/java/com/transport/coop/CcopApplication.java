package com.transport.coop;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "School Transport Management API",
                version = "1.0.0",
                description = "API for managing school transport routes and students"
        )
)
public class CcopApplication {
    public static void main(String[] args) {
        SpringApplication.run(CcopApplication.class, args);
    }
}
