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

@RestController
@RequestMapping("/cats")
public class CatController {
    
    @Autowired
    private CatService catService;
    
    
    public CatController(CatService catService){
        this.catService = catService;
    }

    @PostMapping("")
    public ResponseEntity<Long> createCat(@RequestBody CreateCatDto newCat) throws IOException{
        CatDto catDto = catService.createCat(newCat);
        return new ResponseEntity<Long>(catDto.getId(), HttpStatus.CREATED);
    }

    @GetMapping("")
    public List<Long> getCats(CatService catService){
        return catService.getCats();
    }
    @GetMapping("/{id}")
    public ResponseEntity<CatDto> getCatById(@PathVariable Long id){
        try{
        return new ResponseEntity<CatDto>(catService.getCatById(id),HttpStatus.FOUND);
        }catch( ResponseStatusException e){
            return new ResponseEntity<>(e.getStatus());
        }
    }
    @PutMapping("/{id}")
    public  ResponseEntity<HttpStatus> updateCat(@PathVariable Long id, @RequestBody UpdateCatDto updateCatDto) throws IOException{
        try{
        return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(CatException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCat(@PathVariable Long id){
        try{
        catService.deleteCat(id);
        }catch(RuntimeException e){
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
