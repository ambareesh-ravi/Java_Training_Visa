package com.visa.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visa.prj.dao.EmployeeDao;
import com.visa.prj.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	public List<Employee> getAllEmployees() {
		return employeeDao.findAll();
	}
	
	public Employee getEmployeeByEmail(String email) {
		return employeeDao.getByEmailId(email);
	}
	
	@Transactional
	public void addEmployee(Employee e) {
		employeeDao.save(e);
	}
}
