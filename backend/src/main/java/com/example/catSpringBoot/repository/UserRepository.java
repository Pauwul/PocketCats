package com.example.catSpringBoot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catSpringBoot.model.User;

/**
 * Repository for the user
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Find a user by the username
     * 
     * @param username the username
     * @return the user
     */
    Optional<User> findByUsername(String username);
}
