package com.UDHFashion.udhmanagmentsystem.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.UDHFashion.udhmanagmentsystem.model.Bill;
import com.UDHFashion.udhmanagmentsystem.model.TempBill;
import com.UDHFashion.udhmanagmentsystem.util.CommonConstants;
import com.mysql.jdbc.Statement;

@Service
public class ITempReturnBillDAOImpl implements TempReturnBillDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public long insertTempReturnBill(TempBill tempBill) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(CommonConstants.INSERT_TEMP_RETURN_BILL_DETAILS,
					Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, tempBill.getId());
			ps.setString(2, tempBill.getDate());
			ps.setInt(3,tempBill.getCashireId());
			ps.setDouble(4,tempBill.getGrossAmount());
			ps.setDouble(5,tempBill.getNetAmount());
			ps.setDouble(6,tempBill.getTotalDiscount());
			ps.setDouble(7,tempBill.getBalance());
			ps.setInt(8,tempBill.getNoOfItem());
			return ps;
		}, keyHolder);

		return (long) keyHolder.getKey();
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
