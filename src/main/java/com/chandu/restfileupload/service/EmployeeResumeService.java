package com.chandu.restfileupload.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandu.restfileupload.model.EmployeeResume;
import com.chandu.restfileupload.repository.EmployeeResumeRepository;

@Service
public class EmployeeResumeService {
	
	@Autowired
	private EmployeeResumeRepository employeeResumeRepository;
	
	public EmployeeResume setEmployeeResume(EmployeeResume employeeResume) {
		return employeeResumeRepository.save(employeeResume);
	}

}
