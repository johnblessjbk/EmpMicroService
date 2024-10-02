package com.dailylearn.code.feign;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dailylearn.code.dto.Employee;


@FeignClient("employee-service")
public interface EmployeeClient {
	
	@GetMapping("/employee/getEmpByIdandName")
	public ResponseEntity<?> getEmployeesByIdandName();

	@GetMapping("/employee/getEmployeeById/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable long id);
}
