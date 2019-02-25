package com.UDHFashion.udhmanagmentsystem.model;

public class PersonalExpenditures {
	
private String date;
private String reason;
private Double amount;
private int id;

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
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	} 

}
