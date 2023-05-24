package com.example.catSpringBoot.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.example.catSpringBoot.model.User;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * The user principal
 */
public class UserPrincipal implements OAuth2User, UserDetails {
    /**
     * The id of the user
     */
    private Long id;
    /**
     * The email of the user
     */
    private String email;
    /**
     * The username of the user
     */
    private String username;
    /**
     * The password of the user
     */
    private String password;
    /**
     * The authorities of the user
     */
    private Collection<? extends GrantedAuthority> authorities;
    /**
     * The attributes of the user
     */
    private Map<String, Object> attributes;

    /**
     * Constructor for the user principal, this object realizes the connection
     * between the oauth2 user and the user details
     * 
     * @param id          the id of the user
     * @param email       the email of the user
     * @param username    the username of the user
     * @param password    the password of the user
     * @param authorities the authorities of the user
     */
    public UserPrincipal(Long id, String email, String username, String password,
            Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    /**
     * Create a user principal from a user
     * 
     * @param user the user
     * @return the user principal
     */
    public static UserPrincipal create(User user) {
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));

        return new UserPrincipal(
                user.getId(),
                user.getEmail(),
                user.getName(),
                "",
                authorities);
    }

    /**
     * Create a user principal from a user and attributes
     * 
     * @param user       the user
     * @param attributes the attributes
     * @return the user principal
     */
    public static UserPrincipal create(User user, Map<String, Object> attributes) {
        UserPrincipal userPrincipal = UserPrincipal.create(user);
        userPrincipal.setAttributes(attributes);
        return userPrincipal;
    }

    /**
     * Get the id
     * 
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Get the email
     * 
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Get the password
     * 
     * @return the password
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Get the username
     * 
     * @return the username
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Check if the account is not expired
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Check if the account is not locked
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Check if the credentials are not expired
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Check if the user is enabled
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * Get the authorities
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * Get the attributes
     * 
     * @return the attributes
     */
    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    /**
     * Set the attributes
     * 
     * @param attributes the attributes
     */
    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    /**
     * Get the name
     * 
     * @return the name
     */
    @Override
    public String getName() {
        return String.valueOf(id);
    }
}
