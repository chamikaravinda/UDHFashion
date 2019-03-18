package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;

import com.UDHFashion.udhmanagmentsystem.model.CashPayments;
import com.UDHFashion.udhmanagmentsystem.model.Shop;


public interface ICashPaymentDAO {
	
	
	
	public abstract boolean insertCashPayments( CashPayments cashPayment );
	public abstract List<CashPayments> getAllCashPaymentsDetails(); 
	

}
