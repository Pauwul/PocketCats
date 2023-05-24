package com.example.catSpringBoot.dto;

import lombok.Data;

/**
 * Dto for creating a cat
 */
@Data
public class CreateCatDto {
    private String name;
    private String breed;
    private String description;
    private String image;
}
