package com.chandu.restfileupload.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.chandu.restfileupload.controller.forms.EmployeeResumeRequest;
import com.chandu.restfileupload.model.Employee;
import com.chandu.restfileupload.model.EmployeeResume;
import com.chandu.restfileupload.repository.EmployeeRepository;
import com.chandu.restfileupload.repository.EmployeeResumeRepository;

@Service
public class EmployeeResumeService {
	
	@Autowired
	private EmployeeResumeRepository employeeResumeRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeResume setEmployeeResume(EmployeeResume employeeResume) {
		return employeeResumeRepository.save(employeeResume);
	}
	
	public EmployeeResume uploadEmployeeResume(EmployeeResume employeeResume, MultipartFile file) throws IOException{
		employeeResume.setFileData(file.getBytes());
		employeeResume.setFileName(file.getOriginalFilename());
		employeeResume.setFileType(file.getContentType());
		Employee employee = employeeRepository.findById(employeeResume.getEmployeeId()).get();
		employee.setResumeId(employeeResume);
		
		return employeeResumeRepository.save(employeeResume);
	}
	
	public EmployeeResume getEmployeeResume(Long id) {
		/*
		 * Employee employee = employeeRepository.findById(id).get(); EmployeeResume
		 * resumeId = employee.getResumeId(); EmployeeResume employeeResume =
		 * employeeResumeRepository.findAll(employee.getResumeId());
		 */
		
		return employeeResumeRepository.findByEmployeeId(id);
	}
		

}
