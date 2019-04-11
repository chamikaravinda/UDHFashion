package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;

import com.UDHFashion.udhmanagmentsystem.model.Billitems;
import com.UDHFashion.udhmanagmentsystem.model.ShopExpenditures;

public interface PrintNoteItemDAO {

	public abstract List<Billitems> getPrintNoteItem(int billId);

	boolean insertPrintNoteItem(Billitems items);

	public abstract List<Billitems> getAllPrintNoteItem();

	public boolean deleteTempReturnBillitem();

}
