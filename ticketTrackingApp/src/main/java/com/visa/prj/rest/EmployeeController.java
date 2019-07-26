package com.visa.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.Department;
import com.visa.prj.entity.Employee;
import com.visa.prj.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("employees")
	public @ResponseBody List<Employee> getEmployees() {
			return service.getAllEmployees();
	}
	
	@GetMapping("employees/{email}")
	public @ResponseBody Employee getEmployee(@PathVariable("email") String email) {
		return service.getEmployeeByEmail(email);
	}
	
	@PostMapping("employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee e) {
		service.addEmployee(e);
		return new ResponseEntity<>(e,HttpStatus.CREATED);
	}
	

}
