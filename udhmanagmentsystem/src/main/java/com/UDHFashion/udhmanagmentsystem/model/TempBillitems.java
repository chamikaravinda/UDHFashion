

package com.UDHFashion.udhmanagmentsystem.model;

public class TempBillitems {

	private int id;
	private String itemNo;
	private double price;
	private int qty;
	private int cashireId;
	public int getCashireId() {
		return cashireId;
	}
	public void setCashireId(int cashireId) {
		this.cashireId = cashireId;
	}
	private String billId;
	private double reduseDiscount;
	private double amount;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemNo() {
		return itemNo;
	}
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public double getReduseDiscount() {
		return reduseDiscount;
	}
	public void setReduseDiscount(double reduseDiscount) {
		this.reduseDiscount = reduseDiscount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
	
	
	
	
	
}
