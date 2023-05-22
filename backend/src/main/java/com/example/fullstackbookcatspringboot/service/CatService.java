package com.example.fullstackbookcatspringboot.service;

import com.example.fullstackbookcatspringboot.dto.CatDto;
import com.example.fullstackbookcatspringboot.dto.CreateCatDto;
import com.example.fullstackbookcatspringboot.dto.UpdateCatDto;
import com.example.fullstackbookcatspringboot.exception.CatException;
import com.example.fullstackbookcatspringboot.model.Cat;
import com.example.fullstackbookcatspringboot.repository.CatRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class CatService {

    @Autowired
    private CatRepository catRepository;

    public CatService(CatRepository catRepository){
        this.catRepository = catRepository;
    }

    public CatDto createCat(CreateCatDto createCatDto) throws IOException{
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

    
    public List<CatDto> getCats(){
        List<Cat> cats = catRepository.findAll();
        return cats.stream().map(entity -> new CatDto(entity)).toList();
    }

    public CatDto getCatById(Long id){
        Optional<Cat> cat = catRepository.findById(id);
        if(cat.isPresent())
            return new CatDto(cat.get());
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "getCatById - cat not found");
    }

    public CatDto updateCat(Long id,UpdateCatDto updateCatDto) throws IOException{
        Optional<Cat> cat = catRepository.findById(id);
        if(cat.isPresent()){
            cat.get().setName(updateCatDto.getName());
            cat.get().setBreed(updateCatDto.getBreed());
            cat.get().setDescription(updateCatDto.getDescription());
            byte[] result = Base64.getDecoder().decode(updateCatDto.getImage());
            cat.get().setImage(result);
            catRepository.saveAndFlush(cat.get());
            return new CatDto(cat.get());
        }
        else{
            throw new CatException(404, "updateCat - cat not found");
        }
    }

    public void deleteCat(Long id){
        Optional<Cat> cat = catRepository.findById(id);
        if(cat.isPresent()){
            catRepository.delete(cat.get());
        }
        else {
            throw new RuntimeException("deleteCat - cat not found");
        }
    }   
}