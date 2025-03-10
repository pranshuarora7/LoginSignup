package com.pranshu.signup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**") // Allow all API routes
                        .allowedOrigins("http://localhost:5173", "https://loginsignup.up.railway.app") // ✅ Allow frontend URLs
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow essential HTTP methods
                        .allowedHeaders("*") // Allow all headers
                        .allowCredentials(true); // Required for cookies, sessions, and authentication
            }
        };
    }
}

