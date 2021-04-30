package com.chandu.restfileupload.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chandu.restfileupload.model.Employee;
import com.chandu.restfileupload.model.EmployeeResume;

public interface EmployeeResumeRepository extends JpaRepository<EmployeeResume, Long> {

}
