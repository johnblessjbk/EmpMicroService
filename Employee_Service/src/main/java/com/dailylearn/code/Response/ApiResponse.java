package com.dailylearn.code.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {
	private String status;
	private String message;

	public ApiResponse(String status, String message, int statusCode) {
		super();
		this.status = status;
		this.message = message;
		this.statusCode = statusCode;
	}

	private int statusCode;
	private T data; // Generic type parameter

}