package com.dailylearn.code.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailylearn.code.dto.DepartmentDTO;
import com.dailylearn.code.dto.Employee;
import com.dailylearn.code.feign.EmployeeClient;
import com.dailylearn.code.model.Department;
import com.dailylearn.code.repository.DepartmentRepo;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class DepartmentService {
	private final Logger log = LoggerFactory.getLogger(DepartmentService.class);
	@Autowired
	private DepartmentRepo departmentRepo;
	@Autowired
	private EmployeeClient employeeClient;

	public Department addDepartment(Department department) {
		return departmentRepo.save(department);
	}

	public Object getAllDepartment() {
		return departmentRepo.findAll();
	}

	public Object getIdfromEmployee() {
		return employeeClient.getEmployeesByIdandName();
	}

	public List<DepartmentDTO> getDepartmentwithEmployeeList() {
		List<Department> departments = departmentRepo.findAll();
		List<DepartmentDTO> deDtos = new ArrayList<>();
		for (Department d : departments) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			departmentDTO.setId(d.getId());
			departmentDTO.setName(d.getName());

			List<Employee> saveemployee = new ArrayList<>();
			List<Long> employeeIds = d.getEmployeeId();
			for (Long employeeId : employeeIds) {
				Optional<Employee> response = employeeClient.getEmployeeById(employeeId).getBody();
				if (response.isPresent()) {
					saveemployee.add(response.get());
					departmentDTO.setEmployees(saveemployee);
				}
			}
			deDtos.add(departmentDTO);
		}
		return deDtos;
	}

	public DepartmentDTO getDepartmentById(long id) {
		DepartmentDTO departmentDTO = new DepartmentDTO();
		Optional<Department> department = departmentRepo.findById(id);
		List<Long> employeeIds = department.get().getEmployeeId();
		departmentDTO.setId(department.get().getId());
		departmentDTO.setName(department.get().getName());
		List<Employee> saveemployee = new ArrayList<>();

		for (long employeeid : employeeIds) {
			Optional<Employee> employee = employeeClient.getEmployeeById(employeeid).getBody();
			if (employee.isPresent()) {
				saveemployee.add(employee.get());
				departmentDTO.setEmployees(saveemployee);
			}
		}
		return departmentDTO;
	}
}
