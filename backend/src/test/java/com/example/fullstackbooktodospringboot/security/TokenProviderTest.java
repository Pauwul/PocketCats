package com.example.fullstackbooktodospringboot.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.example.fullstackbooktodospringboot.model.User;

import static org.junit.jupiter.api.Assertions.*;

public class TokenProviderTest {
    private TokenProvider tokenProvider;
    private Authentication authentication;

    @BeforeEach
    public void setup() {
        User testUser = new User();
        testUser.setEmail("test@email.com");
        testUser.setName("Test User");
        testUser.setId(1L);
        tokenProvider = new TokenProvider();
        authentication = new UsernamePasswordAuthenticationToken(
                UserPrincipal.create(testUser), null);
    }

    @Test
    public void testCreateToken() {
        String token = tokenProvider.createToken(authentication);
        assertNotNull(token);
        assertTrue(token.length() > 0);
    }

    @Test
    public void testValidateTokenValid() {
        String token = tokenProvider.createToken(authentication);
        boolean isValid = tokenProvider.validateToken(token);
        assertTrue(isValid);
    }

    @Test
    public void testValidateTokenInvalid() {
        boolean isValid = tokenProvider.validateToken("invalid-token");
        assertFalse(isValid);
    }

    @Test
    public void testGetUsernameFromToken() {
        String token = tokenProvider.createToken(authentication);
        String username = tokenProvider.getUsernameFromToken(token);
        assertEquals("Test User", username);
    }
}
