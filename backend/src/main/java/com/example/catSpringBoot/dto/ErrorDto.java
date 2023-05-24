package com.example.catSpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO for the error
 */
@Data
@AllArgsConstructor
public class ErrorDto {
    private String msg;
}
