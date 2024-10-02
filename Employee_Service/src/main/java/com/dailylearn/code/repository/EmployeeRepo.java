package com.dailylearn.code.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dailylearn.code.model.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	@Query("select e.id, e.name from Employee as e")
	List<Object[]> findByNameAndId();


}
