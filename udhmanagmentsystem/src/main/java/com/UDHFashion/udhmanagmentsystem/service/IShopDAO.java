package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;


import com.UDHFashion.udhmanagmentsystem.model.Shop;
import com.UDHFashion.udhmanagmentsystem.model.updateShop;

public interface IShopDAO {

	public abstract void insertShopDetails( Shop shop );
	public abstract List<Shop> getAllShopsDetails(); 
	public abstract void deleteShop(int shopId );
	public abstract void updateShopDetails( Shop shop );
	public abstract updateShop getShopById(int id);
	void updateShopDetails(updateShop Ushop);
	
}
