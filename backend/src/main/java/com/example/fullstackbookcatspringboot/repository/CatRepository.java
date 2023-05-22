package com.example.fullstackbookcatspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fullstackbookcatspringboot.model.Cat;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
}
