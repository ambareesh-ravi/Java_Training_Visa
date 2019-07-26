package com.visa.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visa.prj.entity.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer> {
	
	Department findById(int id);

}
