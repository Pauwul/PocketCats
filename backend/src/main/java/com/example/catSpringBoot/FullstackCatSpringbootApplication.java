package com.example.catSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Main class for the application
 */
@SpringBootApplication
@EnableJpaRepositories
@EnableConfigurationProperties
@EntityScan
public class FullstackCatSpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(FullstackCatSpringbootApplication.class, args);
    }
}