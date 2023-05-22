package com.example.fullstackbookcatspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.fullstackbookcatspringboot.repository.CatRepository;
import com.example.fullstackbookcatspringboot.service.CatService;

@Configuration
public class AppConfig {
    private CatRepository catRepository;
    @Bean
    public CatService CatService(){
        return new CatService(this.catRepository);
    }
}
