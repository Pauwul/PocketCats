package com.example.catSpringBoot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.catSpringBoot.repository.CatRepository;
import com.example.catSpringBoot.service.CatService;

@Configuration
public class AppConfig {
    private CatRepository catRepository;
    @Bean
    public CatService CatService(){
        return new CatService(this.catRepository);
    }
}
