package com.example.catSpringBoot.dto;

import lombok.Data;

@Data
public class UpdateCatDto {
    private String name;
    private String breed;
    private String description;
    private String image;
}
