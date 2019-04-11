package com.UDHFashion.udhmanagmentsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.UDHFashion.udhmanagmentsystem.model.Billitems;
import com.UDHFashion.udhmanagmentsystem.model.ShopExpenditures;
import com.UDHFashion.udhmanagmentsystem.model.TempBillitems;
import com.UDHFashion.udhmanagmentsystem.util.CommonConstants;

@Service
public class PrintNoteItemDAOimpl implements PrintNoteItemDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean insertPrintNoteItem(TempBillitems item) {

			try {
				jdbcTemplate.update(CommonConstants.INSERT_PRINT_RETURN_BILL_ITEM_DETAILS, 
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
		System.out.println("Succefulyy added to the P return Bill item Table");
		return true;
		
	}

	@Override
	public List<Billitems> getPrintNoteItem(int billId) {
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
	public boolean deleteTempReturnBillitem() {

		int deleteTempReturnBillitem = jdbcTemplate.update(CommonConstants.DELETE_PRINT_RETURN_BILL_ITEM_DETAILS);

		if (deleteTempReturnBillitem == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Billitems> getAllPrintNoteItem() {
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonConstants.GET_PRINT_RETURN_BILL_ITEM_DETAILS);

		List<Billitems> result = new ArrayList<Billitems>();

		for (Map<String, Object> row : rows) {
			Billitems billitems = new Billitems();

			billitems.setId((Integer) row.get("id"));
			billitems.setItemNo((String) row.get("itemNo"));
			billitems.setPrice((Double) row.get("price"));
			billitems.setQty((Integer) row.get("qty"));
			billitems.setBillId((Integer) row.get("billId"));
			billitems.setAmount((Double) row.get("amount"));

			result.add(billitems);
		}
		// already working properly
		return result;
	}


}
