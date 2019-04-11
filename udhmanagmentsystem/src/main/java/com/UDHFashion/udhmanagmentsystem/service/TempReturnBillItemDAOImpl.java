package com.UDHFashion.udhmanagmentsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.UDHFashion.udhmanagmentsystem.model.Billitems;
import com.UDHFashion.udhmanagmentsystem.model.TempBillitems;
import com.UDHFashion.udhmanagmentsystem.util.CommonConstants;

@Service
public class TempReturnBillItemDAOImpl implements TempReturnBillItemDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean insertTempReturnBillItems(List<Billitems> items) {

		for (Billitems item : items) {
			try {
				jdbcTemplate.update(CommonConstants.INSERT_TEMP_RETURN_BILL_ITEM_DETAILS, 
						item.getItemNo(), 
						item.getPrice(),
						item.getQty(),
						item.getBillId(),
						item.getReduseDiscount(),
						item.getAmount());
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}

		}
		System.out.println("Succefulyy added to the Temp return Bill item Table");
		return true;
		
		
	}

	@Override
	public List<Billitems> getTempReturnBillitem(int billId) {
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonConstants.GET_TEMP_RETURN_BILL_ITEM_DETAILS,
				billId);

		List<Billitems> result = new ArrayList<Billitems>();

		for (Map<String, Object> row : rows) {
			Billitems billItems = new Billitems();

			billItems.setItemNo((String) row.get("itemNo"));

			billItems.setQty((Integer) row.get("qty"));

			billItems.setAmount((Double) row.get("amount"));

			result.add(billItems);
		}

		System.out.println("Temp Return  bill item Bill ID :"+billId);
		
		return result;
	}
	
	@Override
	public boolean deleteTempReturnBillitem(String itemNo) {

		int deleteTempReturnBillitem = jdbcTemplate.update(CommonConstants.DELETE_TEMP_RETURN_BILL_ITEM_DETAILS, itemNo);

		if (deleteTempReturnBillitem == 1) {
			return true;
		} else {
			return false;
		}
	}


}
