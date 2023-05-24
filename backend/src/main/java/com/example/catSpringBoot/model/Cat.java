package com.example.catSpringBoot.model;

import lombok.Data;

import javax.persistence.*;

import org.hibernate.annotations.Type;

/**
 * Model for the cat
 */
@Entity
@Data
@Table(name = "cats")
public class Cat {
    /**
     * The id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * The name
     */
    @Column
    private String name;

    /**
     * The breed
     */
    @Column
    private String breed;

    /**
     * The description
     */
    @Column
    private String description;
    /**
     * The image
     */
    @Lob
    @Column
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] image;
}
