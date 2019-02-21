package com.UDHFashion.udhmanagmentsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.UDHFashion.udhmanagmentsystem.model.Employee;
import com.UDHFashion.udhmanagmentsystem.service.IEmployeeDAO;
import com.UDHFashion.udhmanagmentsystem.service.IShopDAO;

@Controller
public class EmployeeController {
	
	@Autowired
	IEmployeeDAO iEmployee;
	
	
	
	@RequestMapping(value="/addEmployee",method=RequestMethod.GET)
	public String addEmployee(Model model) {
		
		return "employee/addEmployee";
		
	}

	@RequestMapping(value="/submitEmployee",method=RequestMethod.POST)
	public String submitEmployee(@ModelAttribute("employee") Employee employee,ModelMap model) {
		
		
		iEmployee.insertEmployeeDetails(employee);
		
		List<Employee> employeeList=iEmployee.getAllEmployeeDetails();
		model.addAttribute("employeeList",employeeList);
		return "employee/viewEmployee";
		
	}
	
	
	
	@RequestMapping(value="/employeeSalarySheet",method=RequestMethod.GET)
	public String viewEmployeeSalarySheet(Model model) {
		
		return "employee/employeeSalarySheet";
		
	}


}
