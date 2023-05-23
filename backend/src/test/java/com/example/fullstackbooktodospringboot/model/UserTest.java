package com.example.fullstackbooktodospringboot.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void testGettersAndSetters() {
        // Create a User instance
        User user = new User();

        // Set values using setters
        user.setId(1L);
        user.setName("John Doe");
        user.setEmail("johndoe@example.com");
        user.setImageUrl("http://example.com/avatar.jpg");
        user.setEmailVerified(true);
        user.setProviderId("12345");

        // Verify values using getters
        Assertions.assertEquals(1L, user.getId());
        Assertions.assertEquals("John Doe", user.getName());
        Assertions.assertEquals("johndoe@example.com", user.getEmail());
        Assertions.assertEquals("http://example.com/avatar.jpg", user.getImageUrl());
        Assertions.assertTrue(user.getEmailVerified());
        Assertions.assertEquals("12345", user.getProviderId());
    }
}
