package com.dossantoscarlos.pge.core.config.Error;


import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpServerErrorException;

@Component
@ControllerAdvice
public class HandlerResponseExceptionApiController {

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(OptimisticLockingFailureException.class)
    public Map<String, String> handleOptimisticLockingFailureExceptions(OptimisticLockingFailureException ex) {
        Map<String, String> errors = new HashMap<>();
        String fieldName = "Message";
        String errorMessage = ex.getMessage();
        errors.put(fieldName, errorMessage);
        return errors;
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Map<String, String> handleHttpRequestMethodNotSupportedExceptions(
            HttpRequestMethodNotSupportedException ex) {
        Map<String, String> errors = new HashMap<>();
        String fieldName = "Message";
        String errorMessage = ex.getMessage();
        errors.put(fieldName, errorMessage);
        return errors;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(HttpServerErrorException.class)
    public Map<String, String> handleHttpServerErrorExceptions(HttpServerErrorException ex) {
        Map<String, String> errors = new HashMap<>();
        String fieldName = "Message";
        String errorMessage = ex.getMessage();
        errors.put(fieldName, errorMessage);
        return errors;
    }


    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String, String> handleIllegalArgumentExceptions(IllegalArgumentException ex) {
        Map<String, String> errors = new HashMap<>();
        String fieldName = "Message";
        String errorMessage = ex.getMessage();
        errors.put(fieldName, errorMessage);
        return errors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public Map<String, String> handleNoSuchElementExceptions(NoSuchElementException ex) {
        Map<String, String> errors = new HashMap<>();
        String fieldName = "Message";
        String errorMessage = ex.getMessage();
        errors.put(fieldName, errorMessage);
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
