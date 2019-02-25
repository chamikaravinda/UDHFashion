package com.UDHFashion.udhmanagmentsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.UDHFashion.udhmanagmentsystem.model.Employee;
import com.UDHFashion.udhmanagmentsystem.service.IEmployeeDAO;

@Controller
public class EmployeeController {

	@Autowired
	IEmployeeDAO serviceEmp;

	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public String addEmployee(Model model) {

		return "employee/addEmployee";

	}

	@RequestMapping(value = "/submitEmployee", method = RequestMethod.POST)
	public String submitEmployee(@ModelAttribute("employee") Employee employee, ModelMap model) {

		serviceEmp.insertEmployeeDetails(employee);
		return "redirect:/viewEmployee";

	}

	@RequestMapping(value = "/viewEmployee", method = RequestMethod.GET)
	public String viewEmployee(Model model) {

		List<Employee> employeeList = serviceEmp.getAllEmployeeDetails();

		model.addAttribute("employeeList", employeeList);

		return "employee/viewEmployee";
	}

	/*----- Delete the method--- */
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
	public String deleteEmployee(@ModelAttribute("employee") Employee employee, ModelMap model) {

		String employeeNo = employee.getEmpNo();

		serviceEmp.deleteEmployee(employeeNo);

		List<Employee> employeeList = serviceEmp.getAllEmployeeDetails();
		model.addAttribute("employeeList", employeeList);
		return "employee/viewEmployee";
	}

	/*---- -----------*/

	@RequestMapping(value = "/employeeSalarySheet", method = RequestMethod.GET)
	public String viewEmployeeSalarySheet(Model model) {

		return "employee/employeeSalarySheet";

	}

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.GET)
 	public String updateEmployee(@ModelAttribute("employee") Employee employee, ModelAndView model) {

		return "employee/editEmployee";

	}
    //Load Data to the forms
	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editEmployee(@ModelAttribute("employee") Employee employee, ModelAndView model) {
		
		
		Employee emp = serviceEmp.getEmployeeById(employee.getEmpNo());
		model.addObject("employee", emp);
		model.setViewName("employee/editEmployee");

		
		return model;
	}
	
	//Update the Details
	
	@RequestMapping(value = "/submitUpdateEmployee", method = RequestMethod.POST)
	public String submitUpdateEmployee(@ModelAttribute("employee") Employee employee, ModelMap model) {

		System.out.println(employee.getBasicSalary());

		serviceEmp.updateEmployeeDetails(employee);

		List<Employee> employeeList = serviceEmp.getAllEmployeeDetails();
		model.addAttribute("employeeList", employeeList);
		return "employee/viewEmployee";
	}
	

}
