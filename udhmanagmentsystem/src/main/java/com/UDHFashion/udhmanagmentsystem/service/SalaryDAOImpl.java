package com.UDHFashion.udhmanagmentsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.UDHFashion.udhmanagmentsystem.model.BankAccount;
import com.UDHFashion.udhmanagmentsystem.model.Salary;
import com.UDHFashion.udhmanagmentsystem.util.CommonConstants;

@Service
public class SalaryDAOImpl implements ISalaryDAO{


	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean AddNewSalarySheet(Salary salary) {

		try {
			int update = jdbcTemplate.update(CommonConstants.INSERT_EMP_SALARY, salary.getEmpNo(),salary.getEmpName(),salary.getAbsent(),salary.getPresent()
					,salary.getTotalBussines(),salary.getMonthlyBasic(),salary.getBasicSalary(),salary.getBonus(),salary.getTotalSalray());

			if (update == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean UpdateSalarySheet(Salary salary) {
		int update = jdbcTemplate.update(CommonConstants.UPDATE_EMP_SALARY,   salary.getEmpNo(),salary.getEmpName(),salary.getAbsent(),salary.getPresent()
				,salary.getTotalBussines(),salary.getMonthlyBasic(),salary.getBasicSalary(),salary.getBonus(),salary.getTotalSalray(),salary.getId());

		if (update == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public Salary getEmployeeSalary(String empNo) {
		try {

			Salary salary= (Salary) jdbcTemplate.queryForObject(CommonConstants.GET_EMP_SALARY,
					new Object[] { empNo }, new BeanPropertyRowMapper(Salary.class));

			return salary;

		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	
}
