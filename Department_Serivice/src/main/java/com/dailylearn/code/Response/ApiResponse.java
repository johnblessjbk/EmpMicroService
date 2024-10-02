package com.dailylearn.code.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {
    private String status;
    private String message;
    private int statusCode;
    private T data; // Generic type parameter

}