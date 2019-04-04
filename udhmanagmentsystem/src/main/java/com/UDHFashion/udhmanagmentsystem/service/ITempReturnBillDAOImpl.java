package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.UDHFashion.udhmanagmentsystem.model.TempBill;
import com.UDHFashion.udhmanagmentsystem.util.CommonConstants;

@Service
public class ITempReturnBillDAOImpl implements TempReturnBillDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean insertTempReturnBill(TempBill tempBill) {

		int insertTempBill = jdbcTemplate.update(CommonConstants.INSERT_TEMP_RETURN_BILL_DETAILS, 
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
	public List<TempBill> getAllTempReturnBill() {

		return null;
	}

	@Override
	public boolean deleteTempReturnBill(int cashireId) {
		
		int update = jdbcTemplate.update(CommonConstants.DELETE_TEMP_RETURN_BILL_DETAILS_ID, cashireId);

		if (update == 1) {
			return true;

		} else {

			return false;
		}
	}

	@Override
	public TempBill getTempReturnBillById(int id) {

		return null;
	}

}
