package com.UDHFashion.udhmanagmentsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.UDHFashion.udhmanagmentsystem.model.ChequePayment;
import com.UDHFashion.udhmanagmentsystem.model.PaidBills;
import com.UDHFashion.udhmanagmentsystem.util.CommonConstants;

@Service
public class IChequeBillDAOImpl implements IChequeBillDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean insertChequePayment(ChequePayment chequePayment) {

		int insert = jdbcTemplate.update(CommonConstants.INSERT_CHEQUE_DETAILS,
				chequePayment.getBillNo(), chequePayment.getBillDate(),chequePayment.getBillAmount(), chequePayment.getShopName(),
				chequePayment.getBankName(), chequePayment.getBankAccount(), chequePayment.getChequeNo(),
				chequePayment.getChequeDate(), chequePayment.getPaymentDate());

		if (insert == 1) {
			return true;
		} else {

			return false;
		}

	}

	@Override
	public List<ChequePayment> getAllChequePaymentDetails() {

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonConstants.GET_ALL_CHEQUE_DETAILS);

		List<ChequePayment> result = new ArrayList<>();

		for (Map<String, Object> row : rows) {
			ChequePayment paidBills = new ChequePayment();

			paidBills.setId((Integer) row.get("id"));
			paidBills.setBillNo((String) row.get("billNo"));
			paidBills.setBillDate((String) row.get("billDate"));
			paidBills.setBillAmount((Double) row.get("billAmount") );
			paidBills.setShopName((String) row.get("shopName"));
			paidBills.setBankName((String) row.get("bankName"));
			paidBills.setBankAccount((String) row.get("bankAccount"));
			paidBills.setChequeNo((String) row.get("chequeNo"));
			paidBills.setPaymentDate((String) row.get("paymentDate"));
			paidBills.setPaymentDate((String) row.get("chequeDate"));
			result.add(paidBills);
		}

		return result;
	}

}
