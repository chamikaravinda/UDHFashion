package com.UDHFashion.udhmanagmentsystem.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.UDHFashion.udhmanagmentsystem.model.Employee;
import com.UDHFashion.udhmanagmentsystem.model.Shop;
import com.UDHFashion.udhmanagmentsystem.util.CommonConstants;

@Service
public class EmployeeDAOImpl implements IEmployeeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertEmployeeDetails(Employee employee) {
		int insertEmployee = jdbcTemplate.update(CommonConstants.INSERT_EMPLOYEE_DETAILS, 
																employee.getEmpNo(),
																employee.getEmpName(), 
																employee.getEmpAddress(), 
																employee.getJobDate(), 
																employee.getContactNum(),
																employee.getContactNum());

		if (insertEmployee == 1) {
			System.out.println("Employee Detail added to the System");
		}

	}

	@Override
	public List<Employee> getAllEmployeeDetails() {

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonConstants.GET_ALL_EMPLOYEE_DETAILS);
		
		List<Employee> result = new ArrayList<Employee>();
		
		for(Map<String, Object> row : rows){
			Employee employee = new Employee();

			employee.setEmpNo((String)row.get("empNo"));
			employee.setEmpName((String)row.get("empName"));
			employee.setEmpAddress((String)row.get("empAddress"));
			//employee.setJobDate((Date)row.get("jobDate"));
			employee.setContactNum((String)row.get("contactNum"));
			employee.setgContactNum((String)row.get("gContactNum"));
			
			
			System.out.println("Shop Name Debug :  "  +employee.getEmpName());
			
			result.add(employee);
		}
		
		return result;
	}

	@Override
	public void deleteEmployee(String empNo) {

	}

}
