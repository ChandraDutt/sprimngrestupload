package com.chandu.restfileupload.controller.forms;

import com.chandu.restfileupload.model.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@NoArgsConstructor
public class EmployeeResponse {
	
	@JsonProperty(value = "FirstName")
	public String firstName;
	
	@JsonProperty(value = "SecondName")
	public String lastName;
	
	@JsonProperty(value = "MailId")
	public String mailId;
	
	@JsonProperty(value = "ResumeId")
	public Long resumeId;
	
	public EmployeeResponse(Employee employee) {
		this.firstName = employee.getFirstName();
		this.lastName = employee.getLastName();
		this.mailId = employee.getMailId();		
		this.resumeId = employee.getResumeId().getFileId();
	}
	

}
