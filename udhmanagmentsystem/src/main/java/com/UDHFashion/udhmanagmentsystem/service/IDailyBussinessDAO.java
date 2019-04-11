package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;


import com.UDHFashion.udhmanagmentsystem.model.DailyBussiness;

public interface IDailyBussinessDAO {
	
	public boolean insertDailyBussinessEntry(DailyBussiness entry);
	public boolean updateDailyEntry(DailyBussiness entry);
	public DailyBussiness getEntry(String date);
	public boolean settingCreticalPoint();
	public boolean deleteExpence(double amount,String date);
	public abstract List<DailyBussiness> getDailyBusiness();
	
}
