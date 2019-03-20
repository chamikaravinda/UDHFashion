package com.UDHFashion.udhmanagmentsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.UDHFashion.udhmanagmentsystem.model.CreditBill;
import com.UDHFashion.udhmanagmentsystem.model.TempBillitems;
import com.UDHFashion.udhmanagmentsystem.util.CommonConstants;

@Service
public class ITempBillitemsDAOImpl implements TempBillitemsDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean insertTempBillitems(TempBillitems tempBillitems) {

		int insertTempBill = jdbcTemplate.update(CommonConstants.INSERT_TEMPBILLITEM_DETAILS,
				tempBillitems.getItemNo(),
				tempBillitems.getPrice(), 
				tempBillitems.getQty(), 
				tempBillitems.getBillId(),
				tempBillitems.getReduseDiscount(),
				tempBillitems.getAmount(),
				tempBillitems.getCashireId());

		if (insertTempBill == 1) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public List<TempBillitems> getAllTempBillitems(int cashireId ) {
		
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonConstants.GET_ALL_TEMPBILLITEM_DETAILS,cashireId);

		List<TempBillitems> result = new ArrayList<TempBillitems>();

		for (Map<String, Object> row : rows) {
			TempBillitems tempBillList = new TempBillitems();

			tempBillList.setItemNo((String) row.get("itemNo"));
			tempBillList.setPrice((Double) row.get("price"));
			tempBillList.setQty((Integer) row.get("qty"));
			tempBillList.setReduseDiscount((Double) row.get("reduseDiscount"));
			tempBillList.setAmount((Double) row.get("amount"));
			//tempBillList.setCashireId((Integer) row.get("cashireId"));
			result.add(tempBillList);
		}

		return result;
		
	}

	@Override
	public boolean deleteTempBillitems(int cashireId) {

		int update = jdbcTemplate.update(CommonConstants.DELETE_TEMPBILLITEM_DETAILS_ID, cashireId);

		if (update == 1) {
			return true;

		} else {

			return false;
		}
	}

	@Override
	public TempBillitems getTempBillitemsById(int id) {
		
		
		return null;
	}

}
