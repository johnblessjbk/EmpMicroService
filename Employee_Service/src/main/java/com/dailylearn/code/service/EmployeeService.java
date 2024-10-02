package com.dailylearn.code.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailylearn.code.model.Address;
import com.dailylearn.code.model.Employee;
import com.dailylearn.code.repository.EmployeeRepo;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	public Employee addEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	public List<Employee> getAllEmployee() {
		return employeeRepo.findAll();
	}
	public List<Object[]> getAllEmployeeByIdandName() {
		return employeeRepo.findByNameAndId();
	}

	public Optional<Employee> getEmployeeById(long id) {
		return employeeRepo.findById(id);
	}
}
