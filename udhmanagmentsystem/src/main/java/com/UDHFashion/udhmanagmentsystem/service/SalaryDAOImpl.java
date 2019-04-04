package com.UDHFashion.udhmanagmentsystem.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.UDHFashion.udhmanagmentsystem.model.BankAccount;
import com.UDHFashion.udhmanagmentsystem.model.Employee;
import com.UDHFashion.udhmanagmentsystem.model.PayiedSalary;
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
					,salary.getTotalBussines(),salary.getMonthlyBasic(),salary.getBasicSalary(),salary.getBonus(),salary.getAdvancePayment(),salary.getTotalSalray());

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
		int update = jdbcTemplate.update(CommonConstants.UPDATE_EMP_SALARY,salary.getEmpNo(),salary.getEmpName(),salary.getAbsent(),salary.getPresent()
				,salary.getTotalBussines(),salary.getMonthlyBasic(),salary.getBasicSalary(),salary.getBonus(),salary.getAdvancePayment(),salary.getTotalSalray(),salary.getId());

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
	
	@Override
	public Salary getEmployeeSalary(int id) {
		try {

			Salary salary= (Salary) jdbcTemplate.queryForObject(CommonConstants.GET_EMP_SALARY_ID,
					new Object[] { id }, new BeanPropertyRowMapper(Salary.class));

			return salary;

		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	@Override
	public List<Salary> getEmployeeSalary() {

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonConstants.GET_ALL_EMP_SALARY);

		List<Salary> result = new ArrayList<>();

		for (Map<String, Object> row : rows) {
			Salary salary = new Salary();

			salary.setId((int) row.get("id"));
			salary.setEmpNo((String) row.get("empNo"));
			salary.setEmpName((String) row.get("empName"));
			salary.setAbsent((int) row.get("absent"));
			salary.setPresent((int) row.get("present"));
			salary.setTotalBussines((double) row.get("totalBussines"));
			salary.setMonthlyBasic((double) row.get("monthlyBasic"));
			salary.setBasicSalary((double) row.get("basicSalary") );
			salary.setBonus((double) row .get("bonus"));
			salary.setAdvancePayment((double) row.get("advance_payment"));
			salary.setTotalSalray((double) row.get("TotalSalray"));

			result.add(salary);
		}

		return result;
	}

	@Override
	public boolean AddPaidSalary(PayiedSalary salary) {

		try {
			int update = jdbcTemplate.update(CommonConstants.INSERT_PAID_EMP_SALARY, salary.getEmpNo(),salary.getEmpName(),salary.getAbsent(),salary.getPresent()
					,salary.getTotalBussines(),salary.getMonthlyBasic(),salary.getBasicSalary(),salary.getBonus(),salary.getAdvancePayment(),salary.getTotalSalray(),salary.getDate());

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
	public boolean deleteSalary(int id) {
		
		int update = jdbcTemplate.update(CommonConstants.DELETE_SALARY, id);

		if (update == 1) {
			return true;

		} else {

			return false;
		}
	}
	
	@Override
	public List<PayiedSalary> getEmployeePaidSalary() {

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonConstants.GET_ALL_PAID_SALARY);

		List<PayiedSalary> result = new ArrayList<>();

		for (Map<String, Object> row : rows) {
			PayiedSalary salary = new PayiedSalary();

			salary.setId((int) row.get("id"));
			salary.setEmpNo((String) row.get("empNo"));
			salary.setEmpName((String) row.get("empName"));
			salary.setAbsent((int) row.get("absent"));
			salary.setPresent((int) row.get("present"));
			salary.setTotalBussines((double) row.get("totalBussines"));
			salary.setMonthlyBasic((double) row.get("monthlyBasic"));
			salary.setBasicSalary((double) row.get("basicSalary") );
			salary.setBonus((double) row .get("bonus"));
			salary.setAdvancePayment((double) row.get("advance_payment"));
			salary.setTotalSalray((double) row.get("TotalSalray"));
			Date cdate = (Date) row.get("date");
			salary.setDate(cdate.toString());
			result.add(salary);
		}

		return result;
	}
}
