package com.backend_pisici.catloversservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.backend_pisici.catloversservices"})
public class CatLoversServicesApplication {
    public static void main(String[] args) {
        SpringApplication.run(CatLoversServicesApplication.class, args);
    }
}
