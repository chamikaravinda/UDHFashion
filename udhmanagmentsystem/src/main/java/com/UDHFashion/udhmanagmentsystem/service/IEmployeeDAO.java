package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;

import com.UDHFashion.udhmanagmentsystem.model.Employee;
public interface IEmployeeDAO {

	
	public abstract void insertEmployeeDetails( Employee employee );
	public abstract List<Employee> getAllEmployeeDetails();
	public abstract void deleteEmployee(String empNo );
	
}
