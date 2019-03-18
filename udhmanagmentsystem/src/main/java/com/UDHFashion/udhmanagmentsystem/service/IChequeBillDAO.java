package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;

import com.UDHFashion.udhmanagmentsystem.model.ChequePayment;

public interface IChequeBillDAO {

	public abstract boolean insertChequePayment(ChequePayment chequePayment);

	public abstract List<ChequePayment> getAllChequePaymentDetails();

}
