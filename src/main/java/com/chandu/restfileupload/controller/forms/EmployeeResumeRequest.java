package com.chandu.restfileupload.controller.forms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeResumeRequest {

	private Long employeeId;

	private String fileName;

	private String fileType;

	private String uploadedBy;

	private String uploadedOn;

}
