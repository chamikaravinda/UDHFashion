package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;

import com.UDHFashion.udhmanagmentsystem.model.Employee;

public interface IEmployeeDAO {

	
	public abstract boolean insertEmployeeDetails( Employee employee );
	public abstract List<Employee> getAllEmployeeDetails();
	public abstract boolean deleteEmployee(String empNo );
	public abstract boolean updateEmployeeDetails( Employee employee);
	public abstract Employee getEmployeeById( String empNo );
}
