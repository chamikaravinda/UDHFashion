package com.UDHFashion.udhmanagmentsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.UDHFashion.udhmanagmentsystem.model.Bill;
import com.UDHFashion.udhmanagmentsystem.model.Billitems;
import com.UDHFashion.udhmanagmentsystem.model.TempBill;
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
				jdbcTemplate.update(CommonConstants.INSERT_TEMP_RETURN_BILL_ITEM_DETAILS, item.getItemNo(),
						item.getPrice(), item.getQty(), item.getBillId(), item.getReduseDiscount(), item.getAmount());
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}

		}
		System.out.println("Succefulyy added to the Temp return Bill item Table");
		return true;

	}

	@Override
	public List<TempBillitems> getTempReturnBillitem(int billId) {
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonConstants.GET_TEMP_RETURN_BILL_ITEM_DETAILS,
				billId);

		List<TempBillitems> result = new ArrayList<TempBillitems>();

		for (Map<String, Object> row : rows) {

			TempBillitems billItems = new TempBillitems();
			billItems.setId((int) row.get("id"));
			billItems.setBillId((int) row.get("billId"));
			billItems.setItemNo((String) row.get("itemNo"));

			billItems.setQty((Integer) row.get("qty"));
		//	billItems.setCashireId((Integer) row.get("cashireId"));   

			billItems.setAmount((Double) row.get("amount"));

			result.add(billItems);
		}

		System.out.println("Temp Return  bill item Bill ID :" + billId);

		return result;
	}

	@Override
	public boolean deleteTempReturnBillitem(int id) {

		int deleteTempReturnBillitem = jdbcTemplate.update(CommonConstants.DELETE_TEMP_RETURN_BILL_ITEM_DETAILS, id);

		if (deleteTempReturnBillitem == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public TempBill getTemBillById(int id) {

		return (TempBill) jdbcTemplate.queryForObject(CommonConstants.GET_TEM_BILL_BY_ID, new Object[] { id },
				new RowMapper<TempBill>() {

					@Override
					public TempBill mapRow(ResultSet rs, int rwNumber) throws SQLException {
						TempBill bill = new TempBill();

						bill.setId(rs.getInt("id"));
						bill.setDate(rs.getString("date"));
						bill.setCashireId(rs.getInt("cashireId"));
						bill.setGrossAmount(rs.getDouble("grossAmount"));
						bill.setNetAmount(rs.getDouble("netAmount"));
						bill.setTotalDiscount(rs.getDouble("totalDiscount"));
						bill.setBalance(rs.getDouble("balance"));
						bill.setNoOfItem(rs.getInt("noOfItem"));

						return bill;
					}
				});

	}


}