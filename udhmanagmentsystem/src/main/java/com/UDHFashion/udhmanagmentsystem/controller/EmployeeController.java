package com.UDHFashion.udhmanagmentsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {
	
	
	@RequestMapping(value="/addEmployee",method=RequestMethod.GET)
	public String addEmployee(Model model) {
		
		return "employee/addEmployee";
		
	}

	@RequestMapping(value="/viewEmployee",method=RequestMethod.GET)
	public String viewEmployee(Model model) {
		
		return "employee/viewEmployee";
		
	}
	@RequestMapping(value="/employeeSalarySheet",method=RequestMethod.GET)
	public String viewEmployeeSalarySheet(Model model) {
		
		return "employee/employeeSalarySheet";
		
	}


}
