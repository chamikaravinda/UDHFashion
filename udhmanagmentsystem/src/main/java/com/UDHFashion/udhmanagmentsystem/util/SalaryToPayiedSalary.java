package com.UDHFashion.udhmanagmentsystem.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.UDHFashion.udhmanagmentsystem.model.PayiedSalary;
import com.UDHFashion.udhmanagmentsystem.model.Salary;

public class SalaryToPayiedSalary {

	public  PayiedSalary toPayiedSalary(Salary toPaied) {

		PayiedSalary salary =new PayiedSalary();
		
		salary.setEmpNo(toPaied.getEmpNo());
		salary.setEmpName(toPaied.getEmpName());
		salary.setAbsent(toPaied.getAbsent());
		salary.setPresent(toPaied.getPresent());
		salary.setTotalBussines(toPaied.getTotalBussines());
		salary.setMonthlyBasic(toPaied.getMonthlyBasic());
		salary.setBasicSalary(toPaied.getBasicSalary());
		salary.setBonus(toPaied.getBonus());
		salary.setAdvancePayment(toPaied.getAdvancePayment());
		salary.setTotalSalray(toPaied.getTotalSalray());
		salary.setDate(getCurrentDate());
		return salary;
		
	}

	private String getCurrentDate() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String newDate = dateFormat.format(date);

		return newDate;

	}
}
