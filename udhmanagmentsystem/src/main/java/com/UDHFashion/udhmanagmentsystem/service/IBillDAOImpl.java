package com.UDHFashion.udhmanagmentsystem.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import com.UDHFashion.udhmanagmentsystem.model.Bill;
import com.UDHFashion.udhmanagmentsystem.model.Item;
import com.UDHFashion.udhmanagmentsystem.util.CommonConstants;
import com.mysql.jdbc.Statement;

@Service
public class IBillDAOImpl implements BillDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public long insertBill(Bill bill) {

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(CommonConstants.INSERT_BILL_DETAILS,
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, bill.getDate());
			ps.setInt(2, bill.getCashireId());
			ps.setDouble(3, bill.getGrossAmount());
			ps.setDouble(4, bill.getNetAmount());
			ps.setDouble(5, bill.getTotalDiscount());
			ps.setDouble(6, bill.getBalance());
			ps.setInt(7, bill.getNoOfItem());
			ps.setDouble(8, bill.getReturnAmount());
			return ps;

		}, keyHolder);

		return (long) keyHolder.getKey();
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
			bill.setTotalDiscount((Double) row.get("totalDiscount"));
			bill.setBalance((Double) row.get("balance"));
			bill.setNoOfItem((Integer) row.get("noOfItem"));

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

		return (Bill) jdbcTemplate.queryForObject(CommonConstants.GET_BILL_BY_NO, new Object[] { id },
				new RowMapper<Bill>() {

					@Override
					public Bill mapRow(ResultSet rs, int rwNumber) throws SQLException {
						Bill bill = new Bill();

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
