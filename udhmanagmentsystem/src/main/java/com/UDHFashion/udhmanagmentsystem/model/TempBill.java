package com.UDHFashion.udhmanagmentsystem.model;

public class TempBill {
	
	private  int id;
	private String date;
	private int cashireId;
	private double grossAmount;
	private double netAmount;
	private double totalDiscount;
	private double balance;
	private int noOfItem;
	
	
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
	
	
	public int getCashireId() {
		return cashireId;
	}
	public void setCashireId(int cashireId) {
		this.cashireId = cashireId;
	}
	public double getGrossAmount() {
		return grossAmount;
	}
	public void setGrossAmount(double grossAmount) {
		this.grossAmount = grossAmount;
	}
	
	
	public double getNetAmount() {
		return netAmount;
	}
	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}
	public double getTotalDiscount() {
		return totalDiscount;
	}
	public void setTotalDiscount(double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getNoOfItem() {
		return noOfItem;
	}
	public void setNoOfItem(int noOfItem) {
		this.noOfItem = noOfItem;
	}
	
	
	
	
	
	
	

}
