package com.UDHFashion.udhmanagmentsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.UDHFashion.udhmanagmentsystem.model.Employee;
import com.UDHFashion.udhmanagmentsystem.model.Item;
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
																employee.getBasicSalary(),
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
		
		List<Employee> result = new ArrayList<>();
		
		for(Map<String, Object> row : rows){
			Employee employee = new Employee();

			employee.setEmpNo((String)row.get("empNo"));
			employee.setEmpName((String)row.get("empName"));
			employee.setEmpAddress((String)row.get("empAddress"));
			employee.setBasicSalary((Double)row.get("basicSalary"));
			employee.setJobDate((String)row.get("jobDate"));
			employee.setContactNum((String)row.get("contactNum"));
			employee.setgContactNum((String)row.get("gContactNum"));
			
			
			System.out.println("Shop Name Debug :  "  +employee.getEmpName());

			
			
			result.add(employee);
		}
		
		return result;
	}

	@Override
	public void deleteEmployee(String empNo) {
		
		int update = jdbcTemplate.update(CommonConstants.DELETE_EMPLOYEE_DETAILS, empNo );
		
		if( update == 1 ) {
			System.out.println("Employee detail deleted ! ");
		}

	}
/*-------------------------------------  */
	@Override
	public void updateEmployeeDetails(Employee employee) {
		
		int updateEmployee = jdbcTemplate.update(CommonConstants.UPDATE_EMPLOYEE_DETAILS,
				employee.getEmpNo(),
				employee.getEmpName(), 
				employee.getEmpAddress(),
				employee.getBasicSalary(),
				employee.getJobDate(), 
				employee.getContactNum(),
				employee.getContactNum());

				if (updateEmployee == 1) {
					
				System.out.println("Employee Detail update to the System");
				
				}
	}

	@Override
	public Employee getEmployeeById(String empNo) {
		
		return (Employee)jdbcTemplate.queryForObject(CommonConstants.GET_EMPLOYEE_BY_NO , new Object[]{empNo}, new RowMapper<Employee>(){
			
			@Override
			public Employee mapRow(ResultSet rs, int rwNumber) throws SQLException {
				Employee employee = new Employee();
				employee.setEmpNo(rs.getString("empNo"));
				employee.setEmpName(rs.getString("empName"));
				employee.setEmpAddress(rs.getString("empAddress"));
				employee.setBasicSalary(rs.getDouble("basicSalary"));
				employee.setJobDate(rs.getString("jobDate"));
				employee.setContactNum(rs.getString("contactNum"));
				employee.setgContactNum(rs.getString("gContactNum"));
				
				System.out.println("Show item code : " + employee.getEmpName());
				
				return employee;
			}
		});
		
		
		
	}
	

	
}
