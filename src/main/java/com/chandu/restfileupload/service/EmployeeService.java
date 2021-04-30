package com.chandu.restfileupload.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandu.restfileupload.controller.forms.EmployeeResponse;
import com.chandu.restfileupload.model.Employee;
import com.chandu.restfileupload.repository.EmployeeRepository;
import com.chandu.restfileupload.utils.ObjectMapperUtils;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}
	
	public Employee getEmployee(Long Id) {
		Optional<Employee> optinalEmployee = employeeRepository.findById(Id);
		Employee employee = optinalEmployee.get();
		return employee;
	}
	
	public EmployeeResponse createEmployee(Employee employeeIn) {
		Employee employeeOut =  employeeRepository.save(employeeIn);
		EmployeeResponse employeeResponse = ObjectMapperUtils.map(employeeOut, EmployeeResponse.class);
		return employeeResponse;
	}
	
//	public EmployeeResponse createOrUpdateEmployee(Employee employeeIn) {
//		Employee employeeOut =  employeeRepository.s(employeeIn);
//		EmployeeResponse employeeResponse = ObjectMapperUtils.map(employeeOut, EmployeeResponse.class);
//		return employeeResponse;
//	}
}
