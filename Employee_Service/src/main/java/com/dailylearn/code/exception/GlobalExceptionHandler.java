package com.dailylearn.code.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dailylearn.code.Response.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<String>> handleResourceNotFoundException(RuntimeException ex) {
        ApiResponse<String> response = new ApiResponse<>(
            "error", 
            ex.getMessage(), 
            HttpStatus.NOT_FOUND.value(), 
            null
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleGenericException(Exception ex) {
        ApiResponse<String> response = new ApiResponse<>(
            "error", 
            "An unexpected error occurred", 
            HttpStatus.INTERNAL_SERVER_ERROR.value(), 
            null
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
