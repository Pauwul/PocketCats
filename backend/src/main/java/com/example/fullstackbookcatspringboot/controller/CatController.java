package com.example.fullstackbookcatspringboot.controller;

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

import com.example.fullstackbookcatspringboot.dto.CatDto;
import com.example.fullstackbookcatspringboot.dto.CreateCatDto;
import com.example.fullstackbookcatspringboot.dto.UpdateCatDto;
import com.example.fullstackbookcatspringboot.service.CatService;

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
    public ResponseEntity<CatDto> createCat(@RequestBody CreateCatDto newCat) throws IOException{
        CatDto catDto = catService.createCat(newCat);
        return new ResponseEntity<CatDto>(catDto, HttpStatus.CREATED);
    }

    @GetMapping("")
    public List<CatDto> getCats(CatService catService){
        return catService.getCats();
    }
    @GetMapping("/{id}")
    public CatDto getCatById(@PathVariable Long id){
        return catService.getCatById(id);
    }
    @PutMapping("/{id}")
    public CatDto updateCat(@PathVariable Long id, @RequestBody UpdateCatDto updateCatDto) throws IOException{
        return catService.updateCat(id,updateCatDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCat(@PathVariable Long id){
        catService.deleteCat(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
