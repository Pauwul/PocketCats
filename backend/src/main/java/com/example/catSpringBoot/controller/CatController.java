package com.example.catSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.catSpringBoot.dto.CatDto;
import com.example.catSpringBoot.dto.CreateCatDto;
import com.example.catSpringBoot.dto.UpdateCatDto;
import com.example.catSpringBoot.exception.CatException;
import com.example.catSpringBoot.service.CatService;

import java.io.IOException;
import java.util.List;

/**
 * Controller for the cats path
 */
@RestController
@RequestMapping("/cats")
public class CatController {

    @Autowired
    private CatService catService;

    /**
     * Create a new cat
     * 
     * @param newCat the cat to create
     * @return the id of the created cat
     * @throws IOException
     */
    @PostMapping("")
    public ResponseEntity<Long> createCat(@RequestBody CreateCatDto newCat) throws IOException {
        CatDto catDto = catService.createCat(newCat);
        return new ResponseEntity<Long>(catDto.getId(), HttpStatus.CREATED);
    }

    /**
     * Return the list of cats
     * 
     * @return the list of cats
     */
    @GetMapping("")
    public List<Long> getCats() {
        return catService.getCats();
    }

    /**
     * Return a cat by its id
     * 
     * @param id the id of the cat
     * @return the cat
     */
    @GetMapping("/{id}")
    public ResponseEntity<CatDto> getCatById(@PathVariable Long id) {
        try {
            return new ResponseEntity<CatDto>(catService.getCatById(id), HttpStatus.FOUND);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getStatus());
        }
    }

    /**
     * Update a cat
     * 
     * @param id           the id of the cat to update
     * @param updateCatDto the new values of the cat
     * @return the status of the update, 200 if the cat was updated, 404 if the cat
     *         was not found
     * @throws IOException
     */
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateCat(@PathVariable Long id, @RequestBody UpdateCatDto updateCatDto)
            throws IOException {
        try {
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (CatException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete a cat
     * 
     * @param id the id of the cat to delete
     * @return response status, 200 if the cat was deleted, 404 if the cat was not
     *         found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCat(@PathVariable Long id) {
        try {
            catService.deleteCat(id);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
