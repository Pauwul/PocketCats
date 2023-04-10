package com.example.demo.exception;

public class CatNotFoundException extends RuntimeException {
    public CatNotFoundException(Long id) {
        super("Could not find cat " + id);
    }

}
