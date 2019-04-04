package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;

import com.UDHFashion.udhmanagmentsystem.model.PayiedSalary;
import com.UDHFashion.udhmanagmentsystem.model.Salary;

public interface ISalaryDAO {
	
	public boolean AddNewSalarySheet(Salary salary);
	
	public boolean UpdateSalarySheet(Salary salary);

	Salary getEmployeeSalary(String empNo);

	List<Salary> getEmployeeSalary();

	Salary getEmployeeSalary(int id);

	boolean AddPaidSalary(PayiedSalary salary);

	boolean deleteSalary(int id);

	List<PayiedSalary> getEmployeePaidSalary();

}
