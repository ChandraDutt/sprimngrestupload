package com.chandu.restfileupload.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chandu.restfileupload.controller.forms.EmployeeRequest;
import com.chandu.restfileupload.controller.forms.EmployeeResponse;
import com.chandu.restfileupload.controller.forms.EmployeeResumeResponse;
import com.chandu.restfileupload.model.Employee;
import com.chandu.restfileupload.model.EmployeeResume;
import com.chandu.restfileupload.repository.EmployeeRepository;
import com.chandu.restfileupload.repository.EmployeeResumeRepository;
import com.chandu.restfileupload.service.EmployeeResumeService;
import com.chandu.restfileupload.service.EmployeeService;
import com.chandu.restfileupload.utils.ObjectMapperUtils;

@RestController

@RequestMapping("/api")
public class ApiController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeResumeService employeeResumeService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeResumeRepository employeeResumeRepository;
	
	@GetMapping("/home")
	public ResponseEntity<String> welcomeGreeting() {
		String response = "Welcome to the API";
		return ResponseEntity.ok(response);
	}
	
	
	@GetMapping(path="/Employees", produces={"application/json","application/xml"})
	public List<Employee> getEmployees(){		
		List<Employee> employeeList = employeeService.getEmployees();
//		List<EmployeeResponse> employeeListResponse = ObjectMapperUtils.mapAll(employeeList, EmployeeResponse.class);
		return employeeList;		
	}
	
	@GetMapping(path="/EmployeesR", produces={"application/json","application/xml"})
	public List<Employee> getEmployeesR(){		
		List<Employee> employeeList = employeeService.getEmployees();
//		List<EmployeeResponse> employeeListResponse = ObjectMapperUtils.mapAll(employeeList, EmployeeResponse.class);
		return employeeList;		
	}
	
	@GetMapping("/private/Employees")
	public List<Employee> getEmployeesPrivate(){		
		List<Employee> employeeList = employeeService.getEmployees();
		return employeeList;		
	}
	
	@GetMapping("/Employees/{id}")
	public Employee getEmployee(@PathVariable Long id) {
		Employee employee =  employeeService.getEmployee(id);
//		EmployeeResponse employeeResponse = ObjectMapperUtils.map(employee, EmployeeResponse.class);
		return employee;
	}
	
	@GetMapping("/private/Employees/{id}")
	public Employee getEmployeesPrivate(@PathVariable Long id){		
		Employee employee =  employeeService.getEmployee(id);
		return employee;		
	}
	
	@PostMapping("/Employees")
	public ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) throws Exception {
		logger.info(employeeRequest.toString());
		Employee employee;
		employee = ObjectMapperUtils.map(employeeRequest ,Employee.class);
		logger.info(employee.toString());
		EmployeeResponse employeeResponse = employeeService.createEmployee(employee);
		return new ResponseEntity<>(employeeResponse, HttpStatus.CREATED);
	}
	
	@PostMapping("/Employees/{id}/Resume")
	public ResponseEntity<?> uploadResume(@PathVariable Long id, @RequestBody EmployeeResume employeeResume) {
		logger.info(employeeResume.toString());
		Employee employee = employeeService.getEmployee(id);
		Employee employeeResumeResponse = null;
		if(employee != null){
			employeeResume.setEmployeeId(id);
			employee.setResumeId(employeeResume);
			employeeResumeResponse= employeeRepository.save(employee);

		}
		return new ResponseEntity<>(employeeResumeResponse,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/EmployeesId")
	public ResponseEntity<?> createEmployeeWithId(@Valid @RequestBody EmployeeRequest employeeRequest, @RequestParam Long id) {
		logger.info(employeeRequest.toString());
		employeeRequest.setId(id);
		Employee employee;
		employee = ObjectMapperUtils.map(employeeRequest ,Employee.class);
		logger.info(employee.toString());
		EmployeeResponse employeeResponse = employeeService.createEmployee(employee);
		return new ResponseEntity<>(employeeResponse, HttpStatus.CREATED);
	}
	
	/*
	 * @PostMapping("/TestFile") public String testfile( @RequestPart
	 * EmployeeRequest employeeRequest ,@RequestParam MultipartFile file) {
	 * logger.info(employeeRequest.toString()); logger.info(file.getName() + "$" +
	 * file.getOriginalFilename() + "$" + file.getContentType() + file.getSize());
	 * return "Ok"; }
	 */
	
}
