package com.example.catSpringBoot.exception;

public class CatException extends RuntimeException{
    private int status;

    public CatException(int status,String message){
        super(message);
        this.status = status;
    }

    public int getStatus(){
        return status;
    }
}
