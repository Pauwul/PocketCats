package com.example.demo.controller;

import java.util.List;

import com.example.demo.exception.CatNotFoundException;
import com.example.demo.model.Cat;
import com.example.demo.repository.CatRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class CatController {

    private final CatRepository repository;

    CatController(CatRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/cats")
    List<Cat> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/cats")
    Cat newCat(@RequestBody Cat newCat) {
        return repository.save(newCat);
    }

    // Single item

    @GetMapping("/cats/{id}")
    Cat one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new CatNotFoundException(id));
    }

    @PutMapping("/cats/{id}")
    Cat replaceCat(@RequestBody Cat newCat, @PathVariable Long id) {

        return repository.findById(id)
                .map(cat -> {
                    cat.setName(newCat.getName());
                    cat.setColor(newCat.getColor());
                    cat.setAge(newCat.getAge());
                    return repository.save(cat);
                })
                .orElseGet(() -> {
                    newCat.setId(id);
                    return repository.save(newCat);
                });
    }

    @DeleteMapping("/cats/{id}")
    void deleteCat(@PathVariable Long id) {
        repository.deleteById(id);
    }
}