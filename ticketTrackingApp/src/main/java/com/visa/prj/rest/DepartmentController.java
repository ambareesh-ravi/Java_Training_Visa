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
import com.visa.prj.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService service;
	
	@GetMapping("departments")
	public @ResponseBody List<Department> getDepartments() {
			return service.getAllDepartments();
	}
	
	@GetMapping("departments/{id}")
	public @ResponseBody Department getDepartment(@PathVariable("id") int id) {
		return service.getDeptById(id);
	}
	
	@PostMapping("departments")
	public ResponseEntity<Department> addDepartment(@RequestBody Department d) {
		service.addDepartment(d);
		return new ResponseEntity<>(d,HttpStatus.CREATED);
	}
}
