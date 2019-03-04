package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;

import com.UDHFashion.udhmanagmentsystem.model.Employee;
import com.UDHFashion.udhmanagmentsystem.model.PersonalExpenditures;
import com.UDHFashion.udhmanagmentsystem.model.ShopExpenditures;

public interface IExpendituresDAO {
	
	
	public abstract boolean insertPersonalExpenditures(PersonalExpenditures pExpenditures );
	public abstract List<PersonalExpenditures> getAllPersonalExpenditures();
	public abstract boolean deletePersonalExpenditures(int id );
	public abstract boolean updatePersonalExpenditures(PersonalExpenditures pExpenditures );
	public abstract PersonalExpenditures getPersonalExpendituresById( int id );
	
	public abstract boolean insertShopExpenditures(ShopExpenditures SpExpenditures );
	public abstract List<ShopExpenditures> getAllShopExpenditures();
	public abstract boolean deleteShopExpenditures(int id );
	public abstract boolean updateShopExpenditures(ShopExpenditures SpExpenditures );
	public abstract ShopExpenditures getShopExpendituresById( int id );
	
	

}
