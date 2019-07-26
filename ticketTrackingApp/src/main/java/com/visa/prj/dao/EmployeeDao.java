package com.visa.prj.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.visa.prj.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, String> {
	
	@Query("from Employee e inner join Department d where e.email=:e")
	Employee getByEmailId(@Param("e") String email);
	
	@Query("from Employee e where e.email=:email")
	Employee getEmployeeById(@Param("email") String email);

}
