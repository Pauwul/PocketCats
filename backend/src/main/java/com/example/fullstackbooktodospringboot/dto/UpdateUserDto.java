package com.example.fullstackbooktodospringboot.dto;

import java.sql.Date;
import lombok.Data;

@Data
public class UpdateUserDto {
    private String name;
    private Date dateRegister;
    private String username;
    private String password;
    private boolean completed;
}
