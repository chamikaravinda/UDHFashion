package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;

import com.UDHFashion.udhmanagmentsystem.model.Shop;

public interface IShopDAO {

	public abstract void insertShopDetails( Shop shop );
	public abstract List<Shop> getAllShopsDetails(); 
	public abstract void deleteShop(int shopId );
}
