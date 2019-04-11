package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.UDHFashion.udhmanagmentsystem.model.TempBill;
import com.UDHFashion.udhmanagmentsystem.util.CommonConstants;

@Service
public class ITempBillDAOImpl implements TempBillDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean insertTempBill(TempBill tempBill) {

		int insertTempBill = jdbcTemplate.update(CommonConstants.INSERT_TEMPBILL_DETAILS, 
				tempBill.getDate(),
				tempBill.getCashireId(),
				tempBill.getGrossAmount(),
				tempBill.getNetAmount(),
				tempBill.getTotalDiscount(),
				tempBill.getBalance(), 
				tempBill.getNoOfItem());

		if (insertTempBill == 1) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public List<TempBill> getAllTempBill() {

		return null;
	}

	@Override
	public boolean deleteTempBill(int cashireId) {
		
		int update = jdbcTemplate.update(CommonConstants.DELETE_TEMPBILL_DETAILS_ID, cashireId);

		if (update == 1) {
			return true;

		} else {

			return false;
		}
	}

	@Override
	public TempBill getTempBillById(int id) {
		
		
		
		

		return null;
	}

}
