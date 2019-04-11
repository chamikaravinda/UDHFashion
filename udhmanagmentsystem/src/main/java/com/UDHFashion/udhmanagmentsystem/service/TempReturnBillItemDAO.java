package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;

import com.UDHFashion.udhmanagmentsystem.model.Billitems;

public interface TempReturnBillItemDAO {

	public abstract List<Billitems> getTempReturnBillitem(int billId);

	boolean insertTempReturnBillItems(List<Billitems> items);

	public boolean deleteTempReturnBillitem(String itemNo);

}
