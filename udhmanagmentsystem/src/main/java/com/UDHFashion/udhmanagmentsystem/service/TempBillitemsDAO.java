package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;


import com.UDHFashion.udhmanagmentsystem.model.TempBillitems;

public interface TempBillitemsDAO {

	public abstract boolean insertTempBillitems(TempBillitems tempBillitems);

	public abstract List<TempBillitems> getAllTempBillitems(int cashireId);

	public abstract boolean deleteTempBillitems(int billId);

	public abstract TempBillitems getTempBillitemsById(int id);

}
