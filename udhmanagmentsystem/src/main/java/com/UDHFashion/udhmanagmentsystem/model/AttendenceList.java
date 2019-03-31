package com.UDHFashion.udhmanagmentsystem.model;

public class AttendenceList {

	private int id;
	private String date;
	private String empNo;
	private String empName;
	private int attendence_ID;
	private String status;
	private String reason;
	
	public AttendenceList() {
	}
	
	public AttendenceList(int id, String date, String empNo, String empName, int attendence_ID, String status,
			String reason) {
		this.id = id;
		this.date = date;
		this.empNo = empNo;
		this.empName = empName;
		this.attendence_ID = attendence_ID;
		this.status = status;
		this.reason = reason;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public int getAttendence_ID() {
		return attendence_ID;
	}
	public void setAttendence_ID(int attendence_ID) {
		this.attendence_ID = attendence_ID;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
	
}

