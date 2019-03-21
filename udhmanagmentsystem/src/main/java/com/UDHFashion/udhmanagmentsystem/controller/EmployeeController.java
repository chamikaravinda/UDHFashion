package com.UDHFashion.udhmanagmentsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.UDHFashion.udhmanagmentsystem.model.BankAccount;
import com.UDHFashion.udhmanagmentsystem.model.Employee;
import com.UDHFashion.udhmanagmentsystem.model.PersonalExpenditures;
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
	public ModelAndView submitEmployee(@ModelAttribute("employee") Employee employee, ModelAndView model,
			RedirectAttributes redir) {

		if (serviceEmp.insertEmployeeDetails(employee)) {
			redir.addFlashAttribute("success", 1);
			model.setViewName("redirect:/viewEmployee");
			return model;
		} else {

			model.addObject("error", "Employee adding unsuccesfully");
			model.setViewName("redirect:/addEmployee");
			return model;
		}

	}

	//

	@RequestMapping(value = "/viewEmployee", method = RequestMethod.GET)
	public ModelAndView viewEmployee(ModelAndView model) {

		List<Employee> employeeList = serviceEmp.getAllEmployeeDetails();

		model.addObject("employeeList", employeeList);
		model.setViewName("employee/viewEmployee");
		return model;
	}

	/*----- Delete the method--- */
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
	public ModelAndView deleteEmployee(@ModelAttribute("employee") Employee employee, ModelAndView model,
			RedirectAttributes redir) {

		String employeeNo = employee.getEmpNo();

		if (serviceEmp.deleteEmployee(employeeNo)) {
			redir.addFlashAttribute("success", 3);
			model.setViewName("redirect:/viewEmployee");
			return model;

		} else {

			model.addObject("error", "Employee deleting unsuccesfully");
			model.setViewName("redirect:/viewEmployee");
			return model;

		}
	}

	/*---- -----------*/

	@RequestMapping(value = "/employeeSalarySheet", method = RequestMethod.GET)
	public String viewEmployeeSalarySheet(Model model) {

		return "employee/employeeSalarySheet";

	}



	// Load Data to the From -------------------------------

	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView ShowEditEmployee(@ModelAttribute("employee") Employee employee, ModelAndView model) {

		Employee emp = serviceEmp.getEmployeeById(employee.getEmpNo());

		model.addObject("employee", emp);
		model.setViewName("employee/editEmployee");

		return model;

	}

	// Update the Details in new Way
	@RequestMapping(value = "/submitUpdateEmployee", method = RequestMethod.POST)
	public ModelAndView submitUpdateEmployee(ModelAndView model, @ModelAttribute("employee") Employee employee,
			RedirectAttributes redir) {

		if (serviceEmp.updateEmployeeDetails(employee)) {
			redir.addFlashAttribute("success", 2);
			model.setViewName("redirect:/viewEmployee");
			return model;

		} else {

			model.addObject("error", "Employee updating unsuccesfully");
			model.setViewName("redirect:/viewEmployee");
			return model;
		}
		
		//update working but sweet alerts not working
	}
	
	
	//advance payment mapping
	
	@RequestMapping(value="/advancePay", method= RequestMethod.GET)
	public String advancePayment(Model model) {
		
		return "employee/advancePayment";
	}

	
	//Attendance
	
	@RequestMapping(value="/attendance", method= RequestMethod.GET)
	public ModelAndView attendance(ModelAndView model) {
		

		List<Employee> employeeList = serviceEmp.getAllEmployeeDetails();

		model.addObject("employeeList", employeeList);
		model.setViewName("employee/attendance");
		return model;
	}
	
}
