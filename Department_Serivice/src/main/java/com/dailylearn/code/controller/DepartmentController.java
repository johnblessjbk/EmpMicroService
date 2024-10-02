package com.dailylearn.code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailylearn.code.Response.ApiResponse;
import com.dailylearn.code.model.Department;
import com.dailylearn.code.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/adddepartment")
	public ResponseEntity<ApiResponse<Department>> postMethodName(@RequestBody Department department) {
	    Department savedDepartment = departmentService.addDepartment(department);
	    ApiResponse<Department> response = new ApiResponse<>(
	        "created", 
	        "department created successfully", 
	        HttpStatus.CREATED.value(), 
	        savedDepartment
	    );
	    return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	@GetMapping("/getAllDepartments")
	public ResponseEntity<?> getDepartments() {
	  
	    return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.getAllDepartment());
	}
	@GetMapping("/getDepartmentsById/{id}")
	public ResponseEntity<?> getDepartmentsById(@PathVariable long id) {
	  
	    return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.getDepartmentById(id));
	}
	@GetMapping("/getIdfromEmployee")
	public ResponseEntity<?> getIdfromEmployee() {
	  
	    return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.getIdfromEmployee());
	}
	@GetMapping("/getDepartmentwithEmployeeList")
	public ResponseEntity<?> getDepartmentwithEmployeeList() {
	  
	    return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.getDepartmentwithEmployeeList());
	}
}
