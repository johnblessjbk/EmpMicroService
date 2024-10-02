package com.dailylearn.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailylearn.code.model.Department;
@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

}
