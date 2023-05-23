package com.example.fullstackbooktodospringboot.security;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserPrincipalTest {

    @Test
    public void testCreate() {
        Long id = 1L;
        String email = "john.doe@example.com";
        String username = "johndoe";
        String password = "password";
        Collection<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));

        UserPrincipal userPrincipal = new UserPrincipal(id, email, username, password, authorities);

        assertEquals(id, userPrincipal.getId());
        assertEquals(email, userPrincipal.getEmail());
        assertEquals(username, userPrincipal.getUsername());
        assertEquals(password, userPrincipal.getPassword());
        assertEquals(authorities, userPrincipal.getAuthorities());
        assertTrue(userPrincipal.isAccountNonExpired());
        assertTrue(userPrincipal.isAccountNonLocked());
        assertTrue(userPrincipal.isCredentialsNonExpired());
        assertTrue(userPrincipal.isEnabled());
    }

    @Test
    public void testCreateWithAttributes() {
        Long id = 1L;
        String email = "john.doe@example.com";
        String username = "johndoe";
        String password = "password";
        Collection<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));

        UserPrincipal userPrincipal = new UserPrincipal(id, email, username, password, authorities);
        userPrincipal.setAttributes(Collections.singletonMap("attributeKey", "attributeValue"));

        assertEquals(Collections.singletonMap("attributeKey", "attributeValue"), userPrincipal.getAttributes());
    }
}
