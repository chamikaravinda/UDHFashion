package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;

import com.UDHFashion.udhmanagmentsystem.model.Bill;


public interface BillDAO {

	public abstract long insertBill(Bill bill);

	public abstract List<Bill> getAllBill();

	public abstract boolean deleteBill(int cashireId );

	public abstract Bill getBillById(int id);

}
