package com.example.catSpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for the root path
 */
@RestController
public class AppController {
    /**
     * Return a public message
     * 
     * @return
     */
    @GetMapping("/")
    public String getRoot() {
        return "Public information available to everyone";
    }
}
