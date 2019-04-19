package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;

import com.UDHFashion.udhmanagmentsystem.model.Billitems;
import com.UDHFashion.udhmanagmentsystem.model.ShopExpenditures;
import com.UDHFashion.udhmanagmentsystem.model.TempBillitems;

public interface PrintNoteItemDAO {

	public abstract List<Billitems> getPrintNoteItem(int billId);

	boolean insertPrintNoteItem(TempBillitems item, int cashierID);

	boolean deleteTempReturnBillitem(int cashierID);

	List<Billitems> getAllPrintNoteItem(int casherID);

}