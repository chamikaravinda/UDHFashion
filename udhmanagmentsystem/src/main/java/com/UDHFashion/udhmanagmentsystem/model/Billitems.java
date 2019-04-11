
package com.UDHFashion.udhmanagmentsystem.model;

public class Billitems {

	private int id;
	private String itemNo;
	private double price;
	private int qty;
	private int billId;
	private double reduseDiscount;
	private double amount;
	private String itemName;

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

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
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

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	
}
