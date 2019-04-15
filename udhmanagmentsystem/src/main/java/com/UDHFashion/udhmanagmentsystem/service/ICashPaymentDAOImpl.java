package com.UDHFashion.udhmanagmentsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.UDHFashion.udhmanagmentsystem.model.CashPayments;
import com.UDHFashion.udhmanagmentsystem.model.CreditBill;
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
		
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonConstants.GET_ALL_CASHPAYMENT_DETAILS);

		List<CashPayments> result = new ArrayList<CashPayments>();

		for (Map<String, Object> row : rows) {
			CashPayments payment = new CashPayments();

			payment.setId((Integer) row.get("id"));
			payment.setBillNo((String) row.get("billNo"));
			payment.setBillDate((String) row.get("billDate"));
			payment.setShopName((String) row.get("shopName"));
			payment.setBillAmount((Double) row.get("billAmount"));
			payment.setPaymentDate("paymentDate");
			result.add(payment);
		}

		return result;

		
	}
	
	@Override
	public boolean deleteCashPayment(int id) {
		
		int delete = jdbcTemplate.update(CommonConstants.DELETE_CASH_PAYMENT_FROM_ID, id);

		if (delete == 1) {
			return true;

		} else {

			return false;
		}
		
		
	}

}
