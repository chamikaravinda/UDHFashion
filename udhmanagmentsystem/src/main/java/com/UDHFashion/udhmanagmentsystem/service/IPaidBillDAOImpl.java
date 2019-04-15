package com.UDHFashion.udhmanagmentsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.UDHFashion.udhmanagmentsystem.model.BankDeposites;
import com.UDHFashion.udhmanagmentsystem.model.PaidBills;
import com.UDHFashion.udhmanagmentsystem.util.CommonConstants;
@Service
public class IPaidBillDAOImpl implements IPaidBillDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public boolean insertPaidBillDetails(PaidBills paidBills) {
		
		
		int addPaidBill = jdbcTemplate.update(CommonConstants.INSERT_PAIDBILL_DETAILS,
				paidBills.getBillNo(), 
				paidBills.getBillDate(),
				paidBills.getShopName(),
				paidBills.getBillAmount(),
				paidBills.getPaymentDate(),
				paidBills.getPaymentMethod()
				
				);

		if (addPaidBill == 1) {
			return true;
		} else {

			return false;
		}

	}

	@Override
	public List<PaidBills> getAllPaidBillDetails() {
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonConstants.GET_ALL_PAIDBILL_DETAILS);

		List<PaidBills> result = new ArrayList<>();

		for (Map<String, Object> row : rows) {
			PaidBills paidBills = new PaidBills();

			paidBills.setId((Integer)row.get("id"));
			paidBills.setBillNo((String)row.get("billNo"));
			paidBills.setBillDate((String)row.get("billDate"));
			paidBills.setShopName((String)row.get("shopName"));
			paidBills.setBillAmount((Double)row.get("billAmount"));
			paidBills.setPaymentDate((String)row.get("paymentDate"));
			paidBills.setPaymentMethod((String)row.get("paymentMethod"));

			result.add(paidBills);
		}

		return result;
	}

	@Override
	public boolean deletePaidBill(int id) {
		
		int delete = jdbcTemplate.update(CommonConstants.DELETE_PAIDBILL_FROM_ID, id);

		if (delete == 1) {
			return true;

		} else {

			return false;
		}
		
		
	}
}
