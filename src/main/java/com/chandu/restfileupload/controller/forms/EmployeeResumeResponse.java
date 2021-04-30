package com.chandu.restfileupload.controller.forms;

import com.chandu.restfileupload.model.EmployeeResume;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EmployeeResumeResponse {
	@JsonProperty(value = "EmployeeId")
	private Long employeeId;
	
	@JsonProperty(value = "FileId")
	private Long fileId;
	
	@JsonProperty(value = "FileName")
	private String fileName;
	
	@JsonProperty(value = "FileData")
	private String fileData;
	
	public EmployeeResumeResponse(EmployeeResume employeeResume) {
		this.employeeId = employeeResume.getEmployeeId();
		this.fileData = employeeResume.getFileData();
		this.fileId = employeeResume.getFileId();
		this.fileName = employeeResume.getFileName();
	}
}
