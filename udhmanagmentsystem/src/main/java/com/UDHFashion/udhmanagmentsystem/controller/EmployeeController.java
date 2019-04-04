package com.UDHFashion.udhmanagmentsystem.controller;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.UDHFashion.udhmanagmentsystem.model.BankAccount;
import com.UDHFashion.udhmanagmentsystem.model.Employee;
import com.UDHFashion.udhmanagmentsystem.model.Item;
import com.UDHFashion.udhmanagmentsystem.model.PayiedSalary;
import com.UDHFashion.udhmanagmentsystem.model.PersonalExpenditures;
import com.UDHFashion.udhmanagmentsystem.model.Salary;
import com.UDHFashion.udhmanagmentsystem.service.IEmployeeDAO;
import com.UDHFashion.udhmanagmentsystem.service.ISalaryDAO;
import com.UDHFashion.udhmanagmentsystem.util.SalaryToPayiedSalary;
import com.mysql.fabric.Response;

@Controller
public class EmployeeController {

	@Autowired
	IEmployeeDAO serviceEmp;

	@Autowired
	ISalaryDAO serviceSalary;

	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public String addEmployee(Model model) {

		return "employee/addEmployee";

	}

	@RequestMapping(value = "/submitEmployee", method = RequestMethod.POST)
	public ModelAndView submitEmployee(@ModelAttribute("employee") Employee employee, ModelAndView model,
			RedirectAttributes redir) {

		int result = serviceEmp.insertEmployeeDetails(employee);
		if (result == 1) {
			redir.addFlashAttribute("success", 1);
			model.setViewName("redirect:/viewEmployee");
			return model;
		} else if (result == 2) {
			model.addObject("error", 2);
			model.setViewName("redirect:/addEmployee");
			return model;
		} else {
			model.addObject("error", 1);
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

	@RequestMapping(value = "/employeeSalarySheet", method = RequestMethod.GET)
	public ModelAndView viewEmployeeSalarySheet(ModelAndView model) {

		List<Salary> salaryList = serviceSalary.getEmployeeSalary();

		model.addObject("salaryList", salaryList);
		model.setViewName("employee/employeeSalarySheet");
		return model;

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

		// update working but sweet alerts not working
	}

	@RequestMapping(value = "/advancePay", method = RequestMethod.GET)
	public ModelAndView advancePayment(ModelAndView model) {

		List<Employee> employees = serviceEmp.getAllEmployeeDetails();
		model.addObject("employees", employees);
		model.setViewName("employee/advancePayment");
		return model;

	}

	@RequestMapping(value = "/advancePay", method = RequestMethod.POST)
	public ModelAndView advancePaymentSave(ModelAndView model, @RequestParam("empNo") String empNo,
			@RequestParam("amount") double amount, RedirectAttributes redir) {

		Salary advance = serviceSalary.getEmployeeSalary(empNo);
		if (advance != null) {

			advance.setAdvancePayment(advance.getAdvancePayment() + amount);
			advance.setBasicSalary(advance.getBasicSalary() - amount);
			advance.setTotalSalray(advance.getTotalSalray() - amount);

			if (serviceSalary.UpdateSalarySheet(advance)) {
				redir.addFlashAttribute("success", 3);
				model.setViewName("redirect:/employeeSalarySheet");
				return model;
			} else {
				model.addObject("error", 1);
				model.setViewName("employee/advancePayment");
				return model;

			}
		} else {
			if (serviceSalary.AddNewSalarySheet(advance)) {

				Employee emp = serviceEmp.getEmployeeById(empNo);

				advance.setEmpNo(empNo);
				advance.setEmpName(emp.getEmpName());
				advance.setAbsent(0);
				advance.setPresent(0);
				advance.setTotalBussines(0);
				advance.setMonthlyBasic(emp.getBasicSalary());
				advance.setBasicSalary(0);
				advance.setBonus(0);
				advance.setAdvancePayment(amount);
				advance.setTotalSalray((advance.getBonus() + advance.getBasicSalary()) - advance.getAdvancePayment());

				serviceSalary.AddNewSalarySheet(advance);

				redir.addFlashAttribute("success", 3);
				model.setViewName("redirect:/employeeSalarySheet");
				return model;

			} else {
				model.addObject("error", 1);
				model.setViewName("employee/advancePayment");
				return model;

			}
		}
	}

	@RequestMapping(value = "/viewSalarySheet", method = RequestMethod.POST)
	public ModelAndView viewSalarySheet(ModelAndView model, @RequestParam("id") int salarySheetId) {
		NumberFormat formatter = new DecimalFormat("#0.00");

		Salary salarySheet = serviceSalary.getEmployeeSalary(salarySheetId);

		salarySheet.setTotalBussines(Double.parseDouble(formatter.format(salarySheet.getTotalBussines())));
		salarySheet.setBasicSalary(Double.parseDouble(formatter.format(salarySheet.getBasicSalary())));
		salarySheet.setBonus(Double.parseDouble(formatter.format(salarySheet.getBonus())));
		salarySheet.setBasicSalary(Double.parseDouble(formatter.format(salarySheet.getBasicSalary())));
		salarySheet.setTotalSalray(Double.parseDouble(formatter.format(salarySheet.getTotalSalray())));

		model.addObject("salary", salarySheet);
		model.setViewName("employee/editSalarySheet");
		return model;
	}

	@RequestMapping(value="/empSalarySheet" ,params = "SalarySheetUpdate", method = RequestMethod.POST)
	public ModelAndView updateSalarySheet(ModelAndView model, @ModelAttribute("salary") Salary salarySheet,
			RedirectAttributes redir, BindingResult result, SessionStatus status) {

		if (serviceSalary.UpdateSalarySheet(salarySheet)) {
			redir.addFlashAttribute("success", 1);
			model.setViewName("redirect:/employeeSalarySheet");
			return model;
		} else {
			model.addObject("error", 2);
			model.addObject("salary", salarySheet);
			model.setViewName("employee/editSalarySheet");
			return model;
		}
	}

	@RequestMapping(value="/empSalarySheet" ,params = "SalarySheetPay", method = RequestMethod.POST)
	public ModelAndView paySalary(ModelAndView model, @ModelAttribute("salary") Salary salarySheet,
			RedirectAttributes redir, BindingResult result, SessionStatus status) {

		SalaryToPayiedSalary conv= new SalaryToPayiedSalary();
		if (serviceSalary.AddPaidSalary(conv.toPayiedSalary(salarySheet))) {
			if (serviceSalary.deleteSalary(salarySheet.getId())) {

				redir.addFlashAttribute("success", 1);
				model.setViewName("redirect:/employeePaidSalarySheet");
			}
		} else {
			model.addObject("error", 3);
			model.addObject("salary", salarySheet);
			model.setViewName("employee/editSalarySheet");
			return model;
		}
		return model;
	}

	@RequestMapping(value="/empSalarySheet" ,params = "SalarySheetPrint", method = RequestMethod.POST)
	public String downloadPDFsalarySheet(Model model, @ModelAttribute("salary") Salary salarySheet,
			RedirectAttributes redir, BindingResult result, SessionStatus status) {
		model.addAttribute("report", getReport(salarySheet.getId()));
		return "salarySheet";

	}

	@RequestMapping(value = "/employeePaidSalarySheet", method = RequestMethod.GET)
	public ModelAndView viewEmployeePaidSalarySheet(ModelAndView model) {

		List<PayiedSalary> salaryList = serviceSalary.getEmployeePaidSalary();

		model.addObject("salaryList", salaryList);
		model.setViewName("employee/paidSalaries");
		return model;

	}

	public Salary getReport(int id) {
		// dummy report
		Salary salarySheet = serviceSalary.getEmployeeSalary(id);
		return salarySheet;
	}

}
