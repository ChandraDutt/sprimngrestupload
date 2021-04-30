package com.chandu.restfileupload.controller.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
//@NoArgsConstructor
@ToString
public class EmployeeRequest {
	
	@JsonProperty(value = "EmployeeId", required = false)
	private Long Id;
	
	@JsonProperty(value = "FirstName",required = true)
//	@NotEmpty(message = "FirstName is mandatory")
	@NotBlank(message = "FirstName is mandatory")
	private String firstName;
	
	@JsonProperty(value = "LastName")
	private String lastName;
	
	@JsonProperty(value = "MailId", required = false)
	private String mailId;
}
