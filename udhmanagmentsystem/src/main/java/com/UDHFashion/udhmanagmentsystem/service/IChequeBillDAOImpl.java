package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.UDHFashion.udhmanagmentsystem.model.ChequePayment;
import com.UDHFashion.udhmanagmentsystem.util.CommonConstants;

@Service
public class IChequeBillDAOImpl implements IChequeBillDAO{
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public boolean insertChequePayment(ChequePayment chequePayment) {
		
		int insert = jdbcTemplate.update(CommonConstants.INSERT_CHEQUE_DETAILS, 
				
				chequePayment.getBillNo(),
				chequePayment.getBillDate(),
				chequePayment.getShopNo(),
				chequePayment.getShopName(),
				chequePayment.getBankName(),
				chequePayment.getBankAccount(),
				chequePayment.getChequeNo(),
				chequePayment.getChequeAmount(),
				chequePayment.getChequeDate(),
				chequePayment.getPaymentDate(),
				chequePayment.getPaymentAmount()
				
				
				
				);

		if (insert == 1) {
			return true;
		} else {

			return false;
		}

	}

	@Override
	public List<ChequePayment> getAllChequePaymentDetails() {
		
		return null;
	}

}
