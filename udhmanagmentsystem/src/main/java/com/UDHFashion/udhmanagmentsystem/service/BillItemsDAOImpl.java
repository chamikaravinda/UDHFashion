package com.UDHFashion.udhmanagmentsystem.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.UDHFashion.udhmanagmentsystem.model.Billitems;
import com.UDHFashion.udhmanagmentsystem.util.CommonConstants;

@Service
public class BillItemsDAOImpl implements IBillItemDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean insertBillItems(ArrayList<Billitems> items) {

		for (Billitems item : items) {
			try {jdbcTemplate.update(CommonConstants.INSERT_BILL_ITEMS, item.getItemNo(), item.getPrice(), item.getQty(),
					item.getBillId(), item.getReduseDiscount(), item.getAmount());
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		
		}
		
		return true;
	}

}
