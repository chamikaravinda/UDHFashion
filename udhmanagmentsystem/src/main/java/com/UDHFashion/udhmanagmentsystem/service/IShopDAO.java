package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;


import com.UDHFashion.udhmanagmentsystem.model.Shop;
import com.UDHFashion.udhmanagmentsystem.model.updateShop;

public interface IShopDAO {

	public abstract boolean insertShopDetails( Shop shop );
	public abstract List<Shop> getAllShopsDetails(); 
	public abstract boolean deleteShop(int shopId );
//	public abstract boolean updateShopDetails( Shop shop );
	public abstract updateShop getShopById(int id);
	public  boolean updateShopDetails(updateShop Ushop);//void to boolean
	
}
