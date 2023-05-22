package com.example.fullstackbookcatspringboot.model;

import lombok.Data;

import javax.persistence.*;

import org.hibernate.annotations.Type;


@Entity
@Data
@Table(name = "cats")
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String breed;

    @Column
    private String description;

    @Lob
    @Column
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] image;
}
