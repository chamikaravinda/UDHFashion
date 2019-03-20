package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.UDHFashion.udhmanagmentsystem.model.Bill;
import com.UDHFashion.udhmanagmentsystem.util.CommonConstants;

@Service
public class IBillDAOImpl implements BillDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public boolean insertBill(Bill bill) {
		
		int insertBill = jdbcTemplate.update(CommonConstants.INSERT_BILL_DETAILS, 
				bill.getDate(),
				bill.getCashireId(),
				bill.getGrossAmount(),
				bill.getNetAmount(),
				bill.getTotalDiscount(),
				bill.getBalance(),
				bill.getNoOfItem());

		if (insertBill == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Bill> getAllBill() {
		   
		
		
		
		return null;
	}

	@Override
	public boolean deleteBill(int cashireId) {
	
		return false;
	}

	@Override
	public Bill getBillById(int id) {
		
		return null;
	}

}
