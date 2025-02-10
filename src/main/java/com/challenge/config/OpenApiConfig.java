package com.challenge.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                title = "Challenge API",
                version = "1.0",
                description = "Challenge API IT Patagonia"
        )
)
public class OpenApiConfig {
}
