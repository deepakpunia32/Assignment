package com.employee.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.EmployeeDetail;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/add")
	public EmployeeDetail add(@RequestBody EmployeeDetail emp) {
		return empService.addEmployee(emp);
	}

	@GetMapping("/employee")
	public String employee(@RequestParam int id,@RequestParam long mobile) {
		
		Optional<EmployeeDetail> ed=empService.getEmployeeById(id);
		
		EmployeeDetail empd=empService.getEmployeeByMobile(mobile);
		
		//condition when employee data is not found after validating both parameters  
		if(ed.isEmpty() && empd==null) {      
			
			return "Status: Not Found\nName: N.A";
		}
		
		//condition when employee data is found after validating parameters and employee id is present 
		else if(!ed.isEmpty()&&empd==null){
			
			String fn=ed.get().getfName();
			String ln=ed.get().getlName();
			String emp="Status: Found\nName: ";
		
			return emp+fn+" "+ln;
		}
		
		//condition when employee data is found after validating parameters and employee mobile number is present
		else if(ed.isEmpty()&& empd!=null)
		{
			String fn=empd.getfName();
			String ln=empd.getlName();
			String emp="Status: Found\nName: ";
			
			return emp+fn+" "+ln;
		}
		
		//when both parameters are valid. Using findById to remove ambiguity
		else {
			
			String fn=ed.get().getfName();
			String ln=ed.get().getlName();
			String emp="Status: Found\nName: ";
		
			return emp+fn+" "+ln;
		}
		
	}
		
}
