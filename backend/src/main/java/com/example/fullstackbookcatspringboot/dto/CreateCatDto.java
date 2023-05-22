package com.example.fullstackbookcatspringboot.dto;

import lombok.Data;

@Data
public class CreateCatDto {
    private String name;
    private String breed;
    private String description;
    private String image;
}
