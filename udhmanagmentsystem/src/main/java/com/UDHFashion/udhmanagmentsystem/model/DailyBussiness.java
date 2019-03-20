package com.UDHFashion.udhmanagmentsystem.model;

public class DailyBussiness {
	
	private int id;
	private String date;
	private double expenseAmount;
	private double bussinesAmount;
	private double returnAmount;
	private double netProfite;
	private boolean flag;
	
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
	public double getExpenseAmount() {
		return expenseAmount;
	}
	public void setExpenseAmount(double expenseAmount) {
		this.expenseAmount = expenseAmount;
	}
	public double getBussinesAmount() {
		return bussinesAmount;
	}
	public void setBussinesAmount(double bussinesAmount) {
		this.bussinesAmount = bussinesAmount;
	}
	public double getReturnAmount() {
		return returnAmount;
	}
	public void setReturnAmount(double returnAmount) {
		this.returnAmount = returnAmount;
	}
	public double getNetProfite() {
		return netProfite;
	}
	public void setNetProfite(double netProfite) {
		this.netProfite = netProfite;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	

}
