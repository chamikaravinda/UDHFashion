package com.UDHFashion.udhmanagmentsystem.model;
public class Employee {

	private String empNo;
	private String empName;
	private String empAddress;
	private String jobDate;
	private String contactNum;
	private String gContactNum;
	private Double basicSalary;
	
	public Double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(Double basicSalary) {
		this.basicSalary = basicSalary;
	}
	// private image photo; >>>>must be added later
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
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public String getJobDate() {
		return jobDate;
	}
	public void setJobDate(String jobDate) {
		this.jobDate = jobDate;
	}
	public String getContactNum() {
		return contactNum;
	}
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}
	public String getgContactNum() {
		return gContactNum;
	}
	public void setgContactNum(String gContactNum) {
		this.gContactNum = gContactNum;
	}

}
