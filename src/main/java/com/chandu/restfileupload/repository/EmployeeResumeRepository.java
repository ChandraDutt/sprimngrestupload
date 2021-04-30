package com.chandu.restfileupload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.chandu.restfileupload.model.EmployeeResume;

@Transactional
public interface EmployeeResumeRepository extends JpaRepository<EmployeeResume, Long> {
	
	
	EmployeeResume findByEmployeeId(Long employeeId);

}
