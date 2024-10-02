package com.dailylearn.code.dto;

import java.util.List;

import lombok.Data;

@Data
public class DepartmentDTO {
	private long id;
	private String name;
	private List<Employee> employees;
}
