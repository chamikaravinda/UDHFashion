package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;

import com.UDHFashion.udhmanagmentsystem.model.CreditBill;
import com.UDHFashion.udhmanagmentsystem.model.Employee;

public interface ISupplierAccountsDAO {
	
	public abstract boolean insertCreditBillDetails(CreditBill creditBills );
	public abstract List<CreditBill> getAllCreditBillDetails(); 
	public abstract boolean deleteCreditBillDetails(String  billNo );
	public abstract boolean deleteCreditBillDetails(int id);
	public abstract boolean updateCreditBillDetails(CreditBill creditBills);
	public abstract CreditBill getCreditBillById( int id );
	CreditBill getCreditBillByBillNo(String no);

}
