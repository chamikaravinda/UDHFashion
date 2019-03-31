package com.UDHFashion.udhmanagmentsystem.service;

import com.UDHFashion.udhmanagmentsystem.model.Salary;

public interface ISalaryDAO {
	
	public boolean AddNewSalarySheet(Salary salary);
	
	public boolean UpdateSalarySheet(Salary salary);

	Salary getEmployeeSalary(String empNo);

}
