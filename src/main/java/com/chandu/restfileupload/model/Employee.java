package com.chandu.restfileupload.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@ToString
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue
	/*
	 * @GeneratedValue is taking maximum id from database table and incrementing it
	 */
	
	private Long Id;
	
	private String firstName;
	
	private String lastName;
	
	private String mailId;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "resume_id")
	private EmployeeResume resumeId;

}
