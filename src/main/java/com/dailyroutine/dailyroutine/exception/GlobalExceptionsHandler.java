package com.dailyroutine.dailyroutine.exception;

import com.dailyroutine.dailyroutine.exception.resource.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionsHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgument(IllegalArgumentException ex){
        HttpStatus reqStatus = HttpStatus.BAD_REQUEST;
        Map<String, Object> body = generateMap(reqStatus, ex, "Invalid argument.");
        return new ResponseEntity<>(body, reqStatus);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        HttpStatus reqStatus = HttpStatus.BAD_REQUEST;

        Map<String, Object> body = generateMap(reqStatus, ex, "Validation failed");

        Map<String, String> validationErrors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((org.springframework.validation.FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            validationErrors.put(fieldName, errorMessage);
        });

        body.put("validationErrors", validationErrors);
        return new ResponseEntity<>(body, reqStatus);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex){
        HttpStatus reqStatus = HttpStatus.NOT_FOUND;
        Map<String, Object> body = generateMap(reqStatus, ex, "Resource not found.");
        return new ResponseEntity<>(body, reqStatus);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex){
        HttpStatus reqStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        Map<String, Object> body = generateMap(reqStatus, ex, "Internal server error.");
        return new ResponseEntity<>(body, reqStatus);
    }

    private Map<String, Object> generateMap(HttpStatus reqStatus,Exception ex, String error){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", reqStatus.value());
        body.put("error", error);
        body.put("message", ex.getMessage());
        return body;
    }
}
