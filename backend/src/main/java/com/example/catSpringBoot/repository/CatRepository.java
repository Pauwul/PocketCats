package com.example.catSpringBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.catSpringBoot.model.Cat;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
    List<Cat> findAll();
}
