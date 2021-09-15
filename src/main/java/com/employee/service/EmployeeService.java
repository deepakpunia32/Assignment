package com.employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.EmployeeDetail;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepository;
	
	public EmployeeDetail addEmployee(EmployeeDetail emp) {
		
		return this.empRepository.save(emp);
	}

	public Optional<EmployeeDetail> getEmployeeById(int id) {
		
		return this.empRepository.findById(id);
	}
	
	public EmployeeDetail getEmployeeByMobile(long mobile) {
		
		return this.empRepository.findByMobile(mobile);
	}
}
