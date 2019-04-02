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
public class BillItemsDAOImpl implements IBillItemDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean insertBillItems(ArrayList<Billitems> items) {

		for (Billitems item : items) {
			try {
				jdbcTemplate.update(CommonConstants.INSERT_BILL_ITEMS, item.getItemNo(), item.getPrice(), item.getQty(),
						item.getBillId(), item.getReduseDiscount(), item.getAmount());
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}

		}

		return true;
	}

	@Override
	public List<Billitems> getBillitem(int billId) {
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonConstants.GET_BILLITEM_DETAILS,
				billId);

		List<Billitems> result = new ArrayList<Billitems>();

		for (Map<String, Object> row : rows) {
			Billitems billItems = new Billitems();

			billItems.setItemNo((String) row.get("itemNo"));

			billItems.setQty((Integer) row.get("qty"));

			billItems.setAmount((Double) row.get("amount"));

			result.add(billItems);
		}

		System.out.println("Pass ID :"+billId);
		
		return result;
	}

}
