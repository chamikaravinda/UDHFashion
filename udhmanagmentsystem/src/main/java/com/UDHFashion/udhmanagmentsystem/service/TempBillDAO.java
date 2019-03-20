package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;


import com.UDHFashion.udhmanagmentsystem.model.TempBill;

public interface TempBillDAO {

	public abstract boolean insertTempBill(TempBill tempBill);

	public abstract List<TempBill> getAllTempBill();

	public abstract boolean deleteTempBill(int cashireId );

	public abstract TempBill getTempBillById(int id);

}
