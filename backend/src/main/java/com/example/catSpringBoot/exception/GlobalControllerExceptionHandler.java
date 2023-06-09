package com.example.catSpringBoot.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.catSpringBoot.dto.ErrorDto;

/**
 * Global exception handler
 */
@ControllerAdvice(annotations = RestController.class)
@Log4j2
class GlobalControllerExceptionHandler {
    /**
     * Handle the ResponseStatusException
     * 
     * @param ex the exception
     * @return http status
     */
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorDto> handleResponseStatusException(ResponseStatusException ex) {
        log.error("response status exception", ex);
        ErrorDto errorDto = new ErrorDto(ex.getMessage());
        return new ResponseEntity<>(errorDto, ex.getStatus());
    }

    /**
     * Handle the CatException
     * 
     * @param ex the exception
     * @return http status
     */
    @ExceptionHandler(CatException.class)
    public ResponseEntity<ErrorDto> handleCatException(CatException ex) {
        log.error("cat custom exception", ex);
        ErrorDto errorDto = new ErrorDto(ex.getMessage());
        HttpStatus httpStatus = HttpStatus.resolve(ex.getStatus());
        return new ResponseEntity<>(errorDto, httpStatus);
    }

    /**
     * Handle the RuntimeException
     * 
     * @param ex the exception
     * @return http status
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDto> handleRuntimeException(RuntimeException ex) {
        log.error("internal server error", ex);
        ErrorDto errorDto = new ErrorDto("internal server error");
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
