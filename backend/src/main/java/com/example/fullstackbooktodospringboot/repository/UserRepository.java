package com.example.fullstackbooktodospringboot.repository;

import com.example.fullstackbooktodospringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByCompleted(Boolean completed);
}
