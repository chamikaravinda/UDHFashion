package com.UDHFashion.udhmanagmentsystem.model;

public class Salary {
	
	private int id;
	private String empNo;
	private String empName;
	private int absent;
	private int present;
	private double totalBussines;
	private double monthlyBasic;
	private double basicSalary;
	private double bonus;
	private double TotalSalray;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getAbsent() {
		return absent;
	}

	public void setAbsent(int absent) {
		this.absent = absent;
	}

	public int getPresent() {
		return present;
	}

	public void setPresent(int present) {
		this.present = present;
	}

	public double getTotalBussines() {
		return totalBussines;
	}

	public void setTotalBussines(double totalBussines) {
		this.totalBussines = totalBussines;
	}

	public double getMonthlyBasic() {
		return monthlyBasic;
	}

	public void setMonthlyBasic(double monthlyBasic) {
		this.monthlyBasic = monthlyBasic;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getTotalSalray() {
		return TotalSalray;
	}

	public void setTotalSalray(double totalSalray) {
		TotalSalray = totalSalray;
	}

}
