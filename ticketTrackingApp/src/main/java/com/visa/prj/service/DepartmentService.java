package com.visa.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.DepartmentDao;
import com.visa.prj.entity.Department;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;
	
	public List<Department> getAllDepartments() {
		return departmentDao.findAll();
	}
	
	public Department getDeptById(int id) {
		return departmentDao.findById(id);
	}
	
	public void addDepartment(Department d) {
		departmentDao.save(d);
	}
}
