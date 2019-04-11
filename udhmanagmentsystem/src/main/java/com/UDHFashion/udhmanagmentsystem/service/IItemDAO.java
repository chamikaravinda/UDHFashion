package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;

import com.UDHFashion.udhmanagmentsystem.model.Item;

public interface IItemDAO {
	
	public abstract void insertStockDetails( Item item );
	public abstract String getNextItemCode(double price,int shopId);
	public abstract double calculateEstimatedNetProfit( double netProfit, int quantity );
	public abstract double calculateNetProfit(double grossPrice, double netPrice);
	public abstract double calculateNetPrice(double priceTagAmount, int discount);;
	public abstract List<Item> getAllItemDetails(); 
	
	public abstract Item getItemById( String id );
	public abstract void deleteItem(String itemCode);
	public abstract boolean isItemRecorded( String itemCode );
	public abstract void updateItemDetails( Item item );
	
	//implement the Return Note Method
	public abstract Item getItemByCode( String itemCode );
	
    public abstract boolean updateReturnItem(Item item);
    
    //Calculate the count of the row
    
  
    
}
