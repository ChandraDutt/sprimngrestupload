package com.chandu.restfileupload.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chandu.restfileupload.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	

}
