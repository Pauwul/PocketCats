package com.example.fullstackbooktodospringboot.model;

import lombok.Data;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Data
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column
    private String name;
    @Column
    private Date dateRegister;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private boolean completed;
    
}
