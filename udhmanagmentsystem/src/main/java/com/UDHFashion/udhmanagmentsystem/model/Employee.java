package com.UDHFashion.udhmanagmentsystem.model;

import java.util.Date;

public class Employee {

	private String empNo;
	private String empName;
	private String empAddress;
	private Date jobDate;
	private String contactNum;
	private String gContactNum;
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
	public Date getJobDate() {
		return jobDate;
	}
	public void setJobDate(Date jobDate) {
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
