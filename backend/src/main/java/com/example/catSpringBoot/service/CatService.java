package com.example.catSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.catSpringBoot.dto.CatDto;
import com.example.catSpringBoot.dto.CreateCatDto;
import com.example.catSpringBoot.dto.UpdateCatDto;
import com.example.catSpringBoot.exception.CatException;
import com.example.catSpringBoot.model.Cat;
import com.example.catSpringBoot.repository.CatRepository;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

/**
 * Service for the cat, this is where the business logic is
 */
@Service
public class CatService {
    /**
     * Repository for the cat
     */
    @Autowired
    private CatRepository catRepository;

    /**
     * Create a cat
     * 
     * @param createCatDto the cat to create
     * @return the created cat
     * @throws IOException
     */
    public CatDto createCat(CreateCatDto createCatDto) throws IOException {
        Cat newCat = new Cat();
        newCat.setName(createCatDto.getName());
        newCat.setBreed(createCatDto.getBreed());
        newCat.setDescription(createCatDto.getDescription());
        byte[] result = Base64.getDecoder().decode(createCatDto.getImage());
        newCat.setImage(result);
        System.out.println(newCat.getImage());
        Cat cat = catRepository.saveAndFlush(newCat);
        return new CatDto(cat);
    }

    /**
     * Get all cats
     * 
     * @return all cats
     * 
     */
    public List<Long> getCats() {
        List<Cat> cats = catRepository.findAll();
        return (cats.stream().map(Cat::getId)).toList();
    }

    /**
     * Get cat by id
     * 
     * @param id the id of the cat
     * @return the cat
     */
    public CatDto getCatById(Long id) {
        Optional<Cat> cat = catRepository.findById(id);
        if (cat.isPresent())
            return new CatDto(cat.get());
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "getCatById - cat not found");
    }

    /**
     * Update cat
     * 
     * @param id           the id of the cat
     * @param updateCatDto the cat to update
     * @return the updated cat
     * @throws IOException
     */
    public Long updateCat(Long id, UpdateCatDto updateCatDto) throws IOException {
        Optional<Cat> cat = catRepository.findById(id);
        if (cat.isPresent()) {
            cat.get().setName(updateCatDto.getName());
            cat.get().setBreed(updateCatDto.getBreed());
            cat.get().setDescription(updateCatDto.getDescription());
            byte[] result = Base64.getDecoder().decode(updateCatDto.getImage());
            cat.get().setImage(result);
            catRepository.saveAndFlush(cat.get());
            return new CatDto(cat.get()).getId();
        } else {
            throw new CatException(404, "updateCat - cat not found");
        }
    }

    /**
     * Delete cat
     * 
     * @param id the id of the cat
     * @return status of the delete
     */
    public ResponseEntity<HttpStatus> deleteCat(Long id) {
        Optional<Cat> cat = catRepository.findById(id);
        if (cat.isPresent()) {
            catRepository.delete(cat.get());
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } else {
            throw new RuntimeException("deleteCat - cat not found");
        }

    }
}