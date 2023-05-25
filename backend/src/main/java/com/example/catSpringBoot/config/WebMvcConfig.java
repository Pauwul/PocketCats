package com.example.catSpringBoot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configure CORS support
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * Enable CORS support
     * 
     * @param registry CorsRegistry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "PUT", "POST", "DELETE")
                .allowedOrigins("http://localhost:3000")
                .allowCredentials(true)
                .allowedHeaders("*");
    }
}