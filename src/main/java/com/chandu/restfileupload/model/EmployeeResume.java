package com.chandu.restfileupload.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.chandu.restfileupload.controller.forms.EmployeeResumeRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@ToString
@NoArgsConstructor
@Table(name = "resume")
public class EmployeeResume {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long fileId;
	
	@JsonIgnore
	private Long employeeId;
	
	private String fileName;
	
	private String fileType;
	
	private String uploadedBy;
	
	private String uploadedOn;
	
	@Lob
	private byte[] fileData;
	
	public EmployeeResume(EmployeeResumeRequest employeeResumeRequest) {
		this.employeeId = employeeResumeRequest.getEmployeeId();
		this.uploadedBy = employeeResumeRequest.getUploadedBy();
		this.uploadedOn = employeeResumeRequest.getUploadedOn();
	}
	
	public void setFile() {
		
	}

}
