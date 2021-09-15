package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.model.EmployeeDetail;

public interface EmployeeRepository extends JpaRepository<EmployeeDetail, Integer>{
	
	EmployeeDetail findByMobile(long mobile);

}
