package com.UDHFashion.udhmanagmentsystem.service;

import java.util.ArrayList;
import java.util.List;


import com.UDHFashion.udhmanagmentsystem.model.Billitems;

public interface IBillItemDAO {
	
	public boolean insertBillItems(ArrayList<Billitems> items);
	public abstract List<Billitems>getBillitem(int billId);
	
	

}
