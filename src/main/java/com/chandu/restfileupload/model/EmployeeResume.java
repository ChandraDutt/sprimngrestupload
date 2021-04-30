package com.chandu.restfileupload.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@ToString
@Table(name = "resume")
public class EmployeeResume {
	@Id
	@GeneratedValue
	private Long fileId;
	
	@JsonIgnore
	private Long employeeId;
	
	private String fileName;
	
	private String fileData;

}
