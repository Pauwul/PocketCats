package com.example.catSpringBoot.dto;

import com.example.catSpringBoot.model.Cat;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO for the cat
 */
@Data
@AllArgsConstructor
public class CatDto {
    private Long id;
    private String name;
    private String breed;
    private String description;
    private byte[] image;

    /**
     * Constructor
     * 
     * @param cat the cat
     */
    public CatDto(Cat cat) {
        this.id = cat.getId();
        this.name = cat.getName();
        this.breed = cat.getBreed();
        this.description = cat.getDescription();
        this.image = cat.getImage();
    }
}
