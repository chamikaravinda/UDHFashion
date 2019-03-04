package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.UDHFashion.udhmanagmentsystem.model.CashPayments;
import com.UDHFashion.udhmanagmentsystem.util.CommonConstants;

@Service
public class ICashPaymentDAOImpl implements ICashPaymentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean insertCashPayments(CashPayments cashPayment) {

		int insert = jdbcTemplate.update(CommonConstants.INSERT_CASHPAYMENT_DETAILS, 
				cashPayment.getBillNo(),
				cashPayment.getBillDate(),
				cashPayment.getShopName(),
				cashPayment.getBillAmount(),
				cashPayment.getPaymentDate());

		if (insert == 1) {
			return true;
		} else {

			return false;
		}

	}

	@Override
	public List<CashPayments> getAllCashPaymentsDetails() {
		
		
		

		return null;
	}

}
