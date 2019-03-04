package com.UDHFashion.udhmanagmentsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.UDHFashion.udhmanagmentsystem.model.CreditBill;
import com.UDHFashion.udhmanagmentsystem.model.PersonalExpenditures;
import com.UDHFashion.udhmanagmentsystem.model.ShopExpenditures;
import com.UDHFashion.udhmanagmentsystem.util.CommonConstants;

@Service
public class ISupplierAccountsDAOImpl implements ISupplierAccountsDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean insertCreditBillDetails(CreditBill creditBills) {

		int insert = jdbcTemplate.update(CommonConstants.INSERT_CREDITBILL_DETAILS,

				creditBills.getBillNo(), 
				creditBills.getBillDate(),
				creditBills.getShopName(),
				creditBills.getBillAmount());

		if (insert == 1) {
			return true;
		} else {

			return false;
		}

	}

	@Override
	public List<CreditBill> getAllCreditBillDetails() {

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonConstants.GET_ALL_CREDITBILL_DETAILS);

		List<CreditBill> result = new ArrayList<CreditBill>();

		for (Map<String, Object> row : rows) {
			CreditBill creditBills = new CreditBill();

			creditBills.setId((Integer) row.get("id"));
			creditBills.setBillNo((String) row.get("billNo"));
			creditBills.setBillDate((String) row.get("billDate"));
			creditBills.setShopName((String) row.get("shopName"));
			creditBills.setBillAmount((Double) row.get("billAmount"));
			result.add(creditBills);
		}

		return result;
	}

	@Override
	public boolean deleteCreditBillDetails(int id) {

		int delete = jdbcTemplate.update(CommonConstants.DELETE_CREDITBILL_DETAILS, id);

		if (delete == 1) {
			return true;

		} else {

			return false;
		}

	}

	
	@Override
	public CreditBill getCreditBillById(int id) {

		try {

			CreditBill creditBill = (CreditBill) jdbcTemplate.queryForObject(
					CommonConstants.GET_CREDITBILL_BY_NO, new Object[] { id },
					new BeanPropertyRowMapper(CreditBill.class));

			return creditBill;

		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	// Update the Shop Expenditures
	@Override
	public boolean updateCreditBillDetails(CreditBill creditBill) {

		try {

			int updateCreditBill = jdbcTemplate.update(CommonConstants.UPDATE_CREDITBILL_DETAILS,
					creditBill.getBillNo(),
					creditBill.getBillDate(), 
					creditBill.getShopName(),
					creditBill.getBillAmount(),
					creditBill.getId());

			if (updateCreditBill == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	
}
