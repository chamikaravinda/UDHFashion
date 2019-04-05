package com.UDHFashion.udhmanagmentsystem.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.UDHFashion.udhmanagmentsystem.model.Attendence;
import com.UDHFashion.udhmanagmentsystem.model.AttendenceForm;
import com.UDHFashion.udhmanagmentsystem.model.AttendenceList;
import com.UDHFashion.udhmanagmentsystem.model.Employee;
import com.UDHFashion.udhmanagmentsystem.model.Salary;
import com.UDHFashion.udhmanagmentsystem.service.AttendendenceDAOImpl;
import com.UDHFashion.udhmanagmentsystem.service.EmployeeDAOImpl;
import com.UDHFashion.udhmanagmentsystem.service.SalaryDAOImpl;;

@Controller
public class EmployeeAttendenceController {

	@Autowired
	AttendendenceDAOImpl attendenceService;

	@Autowired
	EmployeeDAOImpl serviceEmployee;

	@Autowired
	SalaryDAOImpl serviceSalary;

	private int presentEmployees = 0;

	private int absentEmployees = 0;

	private int totalEmployees = 0;

	@RequestMapping(value = "/attendance", method = RequestMethod.GET)
	public ModelAndView ShowAttendence(ModelAndView model) {

		List<AttendenceList> attendence = new ArrayList<>();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String newDate = dateFormat.format(date);
		attendence = attendenceService.getAttendenceList(newDate);

		for (AttendenceList emp : attendence) {
			Employee employee = serviceEmployee.getEmployeeById(emp.getEmpNo());
			emp.setEmpName(employee.getEmpName());

		}

		AttendenceForm attendenceForm = new AttendenceForm();
		attendenceForm.setAttendence(attendence);
		model.setViewName("employee/attendance");
		model.addObject("attendenceForm", attendenceForm);
		return model;

	}

	@RequestMapping(value = "/saveattendance", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("attendenceForm") AttendenceForm attendenceForm, RedirectAttributes redir,
			ModelAndView model) {

		List<AttendenceList> attendence = attendenceForm.getAttendence();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String newDate = dateFormat.format(date);

		if (attendence != null && attendence.size() > 0) {
			if (editAttendenceOrNewAttendenceCheck(attendence)) {

				Attendence newAttendence = new Attendence();
				newAttendence.setDate(newDate);
				newAttendence.setPresent(presentEmployees);
				newAttendence.setAbsent(absentEmployees);

				long attendenceId = attendenceService.addDailyAttendence(newAttendence);
				if (attendenceId != 0) {

					for (AttendenceList attend : attendence) {

						attend.setDate(newDate);
						attend.setAttendence_ID((int) attendenceId);
												
						if (attendenceService.AddEmployeeAttendence(attend)) {

							Salary salarySheet = serviceSalary.getEmployeeSalary(attend.getEmpNo());
							if (salarySheet == null) {
								
								salarySheet = new Salary();
								
								salarySheet.setEmpNo(attend.getEmpNo());
								salarySheet.setEmpName(attend.getEmpName());
								Employee employee = serviceEmployee.getEmployeeById(attend.getEmpNo());
								salarySheet.setMonthlyBasic(employee.getBasicSalary());
								
								if (attend.getStatus().equals("PRESENT")) {
									salarySheet.setAbsent(0);
									salarySheet.setPresent(1);	
									salarySheet.setBasicSalary(employee.getBasicSalary() / 30);
								} else {
									salarySheet.setAbsent(1);
									salarySheet.setPresent(0);
									salarySheet.setBasicSalary(0);
								}
								salarySheet.setTotalBussines(0);		
								salarySheet.setBonus(0);
								salarySheet.setAdvancePayment(0);
								salarySheet.setTotalSalray((salarySheet.getBonus() + salarySheet.getBasicSalary())-salarySheet.getAdvancePayment());

								serviceSalary.AddNewSalarySheet(salarySheet);
							} else {
								if (attend.getStatus().equals("PRESENT")) {
									
									salarySheet.setPresent(salarySheet.getPresent() + 1);
									
									Employee employee = serviceEmployee.getEmployeeById(attend.getEmpNo());
									salarySheet.setBasicSalary(salarySheet.getBasicSalary()+employee.getBasicSalary() / 30);
									salarySheet.setTotalSalray((salarySheet.getBonus() + salarySheet.getBasicSalary())-salarySheet.getAdvancePayment());
								} else {
									salarySheet.setAbsent(salarySheet.getAbsent() + 1);
								}
								
								serviceSalary.UpdateSalarySheet(salarySheet);

							}

						}

					}

				}

				redir.addFlashAttribute("success", 1);
				model.setViewName("redirect:/attendance");
				return model;

			} else {

				int attendenceID = 0;

				for (AttendenceList attend : attendence) {

					AttendenceList currentAttendence = attendenceService.getEmpDailyAttendence(attend.getId());

					Salary salarySheet = serviceSalary.getEmployeeSalary(attend.getEmpNo());
					
					if (salarySheet == null) {
						salarySheet = new Salary();
						
						salarySheet.setEmpNo(attend.getEmpNo());
						salarySheet.setEmpName(attend.getEmpName());
						Employee employee = serviceEmployee.getEmployeeById(attend.getEmpNo());
						salarySheet.setMonthlyBasic(employee.getBasicSalary());
						if (attend.getStatus().equals("PRESENT")) {
							salarySheet.setAbsent(0);
							salarySheet.setPresent(0);
							salarySheet.setBasicSalary(0);
						} else {
							salarySheet.setAbsent(1);
							salarySheet.setPresent(0);
							salarySheet.setBasicSalary(0);
						}
						salarySheet.setTotalBussines(0);						
						salarySheet.setBonus(0);
						salarySheet.setAdvancePayment(0);
						salarySheet.setTotalSalray((salarySheet.getBonus() + salarySheet.getBasicSalary())-salarySheet.getAdvancePayment());

						serviceSalary.AddNewSalarySheet(salarySheet);
					} else {

						AttendenceList empTodayAttendence= new AttendenceList();
						empTodayAttendence = attendenceService
								.getEmpDailyAttendence(attend.getId());

						if (empTodayAttendence.getStatus().equals("PRESENT")) {
							if (attend.getStatus().equals("ABSENT")) {
								salarySheet.setPresent(salarySheet.getPresent() - 1);
								salarySheet.setAbsent(salarySheet.getAbsent() + 1);
								
								Employee employee = serviceEmployee.getEmployeeById(attend.getEmpNo());
								salarySheet.setBasicSalary(salarySheet.getBasicSalary()-employee.getBasicSalary() / 30);
								salarySheet.setTotalSalray((salarySheet.getBonus() + salarySheet.getBasicSalary())-salarySheet.getAdvancePayment());
							}
						} else {
							if (attend.getStatus().equals("PRESENT")) {
								salarySheet.setPresent(salarySheet.getPresent() + 1);
								salarySheet.setAbsent(salarySheet.getAbsent() - 1);
								
								Employee employee = serviceEmployee.getEmployeeById(attend.getEmpNo());
								salarySheet.setBasicSalary(salarySheet.getBasicSalary()+employee.getBasicSalary() / 30);
								salarySheet.setTotalSalray((salarySheet.getBonus() + salarySheet.getBasicSalary())-salarySheet.getAdvancePayment());
							}
						}

						serviceSalary.UpdateSalarySheet(salarySheet);

					}

					attendenceID = attend.getAttendence_ID();
					attendenceService.UpdateEmployeeAttendence(attend);

				}

				Attendence editDailyAttend = new Attendence();
				editDailyAttend.setDate(newDate);
				editDailyAttend.setAbsent(absentEmployees);
				editDailyAttend.setPresent(presentEmployees);
				editDailyAttend.setId(attendenceID);

				attendenceService.UpdateDailyAttendence(editDailyAttend);
				redir.addFlashAttribute("success", 2);
				model.setViewName("redirect:/attendance");
				return model;
			}

		} else {
			redir.addFlashAttribute("unsuccess", 1);
			model.setViewName("redirect:/attendance");
			return model;
		}
	}

	public boolean editAttendenceOrNewAttendenceCheck(List<AttendenceList> attendence) {

		boolean returnVal = true;
		presentEmployees = 0;
		totalEmployees = 0;
		absentEmployees = 0;

		for (AttendenceList attend : attendence) {
			if (attend.getAttendence_ID() != 0) {

				returnVal = false;

				if (attend.getStatus().equals("PRESENT")) {
					presentEmployees++;
					totalEmployees++;
				} else {
					absentEmployees++;
					totalEmployees++;
				}

			} else {
				if (attend.getStatus().equals("PRESENT")) {
					presentEmployees++;
					totalEmployees++;
				} else {
					absentEmployees++;
					totalEmployees++;
				}
			}

		}

		return returnVal;
	}

}
