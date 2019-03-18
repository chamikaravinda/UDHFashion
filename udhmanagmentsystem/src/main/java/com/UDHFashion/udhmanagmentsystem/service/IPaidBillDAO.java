package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;

import com.UDHFashion.udhmanagmentsystem.model.PaidBills;

public interface IPaidBillDAO {

	public abstract boolean insertPaidBillDetails(PaidBills paidBills);

	public abstract List<PaidBills> getAllPaidBillDetails();

}
