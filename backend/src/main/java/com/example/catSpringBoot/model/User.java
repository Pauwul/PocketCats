package com.example.catSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import org.springframework.lang.NonNull;

/**
 * Model for the user
 */
@Entity
@Table(name = "users")
public class User {
    /**
     * The id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name
     */
    @Column(nullable = false)
    private String username;

    /**
     * The email
     */
    @Column(nullable = false)
    private String email = "email-placeholder@email.com";

    /**
     * The image url
     */
    private String imageUrl;

    /**
     * Has the user verified their email
     */
    @Column(nullable = false)
    private Boolean emailVerified = false;

    /**
     * The password
     */
    @JsonIgnore
    private String password;
    /**
     * The provider id, google, facebook, etc
     */
    @NonNull
    private String providerId;

    /**
     * Get user id
     * 
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set user id
     * 
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get user name
     * 
     * @return the name
     */
    public String getName() {
        return username;
    }

    /**
     * Set user name
     * 
     * @param name the name
     */
    public void setName(String name) {
        this.username = name;
    }

    /**
     * Get user email
     * 
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set user email
     * 
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get user image url
     * 
     * @return the url
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Set user image url
     * 
     * @param imageUrl the url
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Get user email verified
     * 
     * @return the is email verified
     */
    public Boolean getEmailVerified() {
        return emailVerified;
    }

    /**
     * Set user email verified
     * 
     * @param emailVerified
     */
    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    /**
     * Get provider id
     * 
     * @return the provider id
     */
    public String getProviderId() {
        return providerId;
    }

    /**
     * Set provider id
     * 
     * @param providerId
     */
    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
