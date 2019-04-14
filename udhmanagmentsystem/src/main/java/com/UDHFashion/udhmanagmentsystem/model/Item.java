package com.UDHFashion.udhmanagmentsystem.model;

public class Item {

	private String itemCode;
	private Integer itemQuantity;
	private Double grossPrice;
	private Double netPrice;
	private Double price;
	private Integer discount;
	private Integer shopId;
	private Double netProfit;
	private Double estimatedNetProfit;
	private String itemDescription;
	private int quntity;
	
	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Double getNetProfit() {
		return netProfit;
	}

	public void setNetProfit(Double netProfit) {
		this.netProfit = netProfit;
	}
	public Double getEstimatedNetProfit() {
		return estimatedNetProfit;
	}
	public void setEstimatedNetProfit(Double estimatedNetProfit) {
		this.estimatedNetProfit = estimatedNetProfit;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public Integer getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(Integer itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public Double getGrossPrice() {
		return grossPrice;
	}
	public void setGrossPrice(Double grossPrice) {
		this.grossPrice = grossPrice;
	}
	public Double getNetPrice() {
		return netPrice;
	}
	public void setNetPrice(Double netPrce) {
		this.netPrice = netPrce;
	}  
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public int getQuntity() {
		return quntity;
	}

	public void setQuntity(int quntity) {
		this.quntity = quntity;
	}
	
}
