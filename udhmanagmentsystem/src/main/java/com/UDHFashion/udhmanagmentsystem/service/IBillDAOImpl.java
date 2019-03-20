package com.UDHFashion.udhmanagmentsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonConstants.GET_ALL_BILL_DETAILS);

		List<Bill> result = new ArrayList<Bill>();

		for (Map<String, Object> row : rows) {
			Bill bill = new Bill();

			bill.setDate((String) row.get("date"));
			bill.setCashireId((Integer) row.get("cashireId"));
			bill.setGrossAmount((Double) row.get("grossAmount"));
			bill.setNetAmount((Double) row.get("netAmount"));
			bill.setTotalDiscount((Double)row.get("totalDiscount"));
			bill.setBalance((Double)row.get("balance"));
			bill.setNoOfItem((Integer)row.get("noOfItem"));

			System.out.println("Shop Name Debug :  " + bill.getNetAmount());

			result.add(bill);
		}

		return result;
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
