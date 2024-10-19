package com.dailylearn.code.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailylearn.code.Response.ApiResponse;
import com.dailylearn.code.model.Employee;
import com.dailylearn.code.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/add")
	public ResponseEntity<ApiResponse<Employee>> addEmployee(@RequestBody Employee department) {
		Employee savedEmployee = employeeService.addEmployee(department);

		return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>("created",
				"department created successfully", HttpStatus.CREATED.value(), savedEmployee));
	}

	@GetMapping("/getEmployee")
	public ResponseEntity<?> getEmployees() {

		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployee());
	}

	@GetMapping("/getEmployeeById/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable long id) {

		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeById(id));
	}

	@GetMapping("/getEmpByIdandName")
	public ResponseEntity<?> getEmployeesByIdandName() {

		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployeeByIdandName());
	}

	@DeleteMapping("/deleteEmployeeById/{id}")
	public ResponseEntity<ApiResponse<Object>> deleteEmployeeById(@PathVariable long id) {

		if (employeeService.deleteEmployeeById(id)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiResponse<>("error", "department failed to delete", HttpStatus.BAD_REQUEST.value()));
		}

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ApiResponse<>("success", "department deleted successfully", HttpStatus.CREATED.value()));
	}
}
