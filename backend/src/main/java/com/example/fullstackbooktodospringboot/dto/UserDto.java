package com.example.fullstackbooktodospringboot.dto;

import java.sql.Date;
import com.example.fullstackbooktodospringboot.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private Date dRegister;
    private String username;
    private String password;
    private boolean completed;

    public UserDto(User entity) {
        this.id = entity.getIdUser();
        this.name = entity.getName();
        this.dRegister = entity.getDateRegister();
        this.username = entity.getUsername();
        this.password = entity.getPassword();
        this.completed = false;
    }
}
