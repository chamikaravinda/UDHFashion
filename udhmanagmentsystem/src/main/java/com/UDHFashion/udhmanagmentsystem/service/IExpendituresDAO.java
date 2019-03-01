package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;

import com.UDHFashion.udhmanagmentsystem.model.Employee;
import com.UDHFashion.udhmanagmentsystem.model.PersonalExpenditures;
import com.UDHFashion.udhmanagmentsystem.model.ShopExpenditures;

public interface IExpendituresDAO {
	
	
	public abstract void insertPersonalExpenditures(PersonalExpenditures pExpenditures );
	public abstract List<PersonalExpenditures> getAllPersonalExpenditures();
	public abstract void deletePersonalExpenditures(int id );
	public abstract void updatePersonalExpenditures(PersonalExpenditures pExpenditures );
	public abstract PersonalExpenditures getPersonalExpendituresById( int id );
	
	public abstract void insertShopExpenditures(ShopExpenditures SpExpenditures );
	public abstract List<ShopExpenditures> getAllShopExpenditures();
	public abstract void deleteShopExpenditures(int id );
	public abstract boolean updateShopExpenditures(ShopExpenditures SpExpenditures );
	public abstract ShopExpenditures getShopExpendituresById( int id );
	
	

}
