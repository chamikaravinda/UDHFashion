package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;


import com.UDHFashion.udhmanagmentsystem.model.TempBill;

public interface TempReturnBillDAO {

	public abstract long insertTempReturnBill(TempBill tempBill);

	public abstract List<TempBill> getAllTempReturnBill();

	public abstract boolean deleteTempReturnBill(int cashireId);

	public abstract TempBill getTempReturnBillById(int id);

}