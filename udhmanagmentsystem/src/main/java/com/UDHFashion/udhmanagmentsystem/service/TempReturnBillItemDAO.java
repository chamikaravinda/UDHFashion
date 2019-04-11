package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;

import com.UDHFashion.udhmanagmentsystem.model.Bill;
import com.UDHFashion.udhmanagmentsystem.model.Billitems;
import com.UDHFashion.udhmanagmentsystem.model.TempBill;
import com.UDHFashion.udhmanagmentsystem.model.TempBillitems;

public interface TempReturnBillItemDAO {

	public abstract List<TempBillitems> getTempReturnBillitem(int billId);

	boolean insertTempReturnBillItems(List<Billitems> items);

	boolean deleteTempReturnBillitem(int id);

	TempBill getTemBillById(int id);

}