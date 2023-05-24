package com.example.catSpringBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.catSpringBoot.model.Cat;

/**
 * Repository for the cat
 */
@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
    /**
     * Find all cats
     * 
     * @return all cats
     */
    List<Cat> findAll();
}
