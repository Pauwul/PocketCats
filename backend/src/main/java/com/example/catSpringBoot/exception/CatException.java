package com.example.catSpringBoot.exception;

/**
 * Exception for the cat
 */
public class CatException extends RuntimeException {
    /**
     * The status
     */
    private int status;

    /**
     * Constructor for the exception
     * 
     * @param status  the status
     * @param message the message
     */
    public CatException(int status, String message) {
        super(message);
        this.status = status;
    }

    /**
     * Get the status
     * 
     * @return the status
     */
    public int getStatus() {
        return status;
    }
}
