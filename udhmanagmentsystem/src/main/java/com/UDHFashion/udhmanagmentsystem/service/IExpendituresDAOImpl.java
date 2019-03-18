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

import com.UDHFashion.udhmanagmentsystem.model.BankAccount;
import com.UDHFashion.udhmanagmentsystem.model.Employee;
import com.UDHFashion.udhmanagmentsystem.model.PersonalExpenditures;
import com.UDHFashion.udhmanagmentsystem.model.Shop;
import com.UDHFashion.udhmanagmentsystem.model.ShopExpenditures;
import com.UDHFashion.udhmanagmentsystem.util.CommonConstants;

@Service
public class IExpendituresDAOImpl implements IExpendituresDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean insertPersonalExpenditures(PersonalExpenditures pExpenditures) {

		int addPexpenditures = jdbcTemplate.update(CommonConstants.INSERT_Pexpenditures_DETAILS,
				pExpenditures.getDate(), pExpenditures.getReason(), pExpenditures.getAmount());

		if (addPexpenditures == 1) {
			return true;
		} else {

			return false;
		}

	}

	@Override
	public List<PersonalExpenditures> getAllPersonalExpenditures() {

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonConstants.GET_ALL_Pexpenditures_DETAILS);

		List<PersonalExpenditures> result = new ArrayList<>();

		for (Map<String, Object> row : rows) {
			PersonalExpenditures pExpenditures = new PersonalExpenditures();

			pExpenditures.setId((Integer) row.get("id"));
			pExpenditures.setDate((String) row.get("date"));
			pExpenditures.setReason((String) row.get("reason"));
			pExpenditures.setAmount((Double) row.get("amount"));

			System.out.println("Shop Name Debug :  " + pExpenditures.getAmount());

			result.add(pExpenditures);
		}

		return result;

	}

	@Override
	public boolean deletePersonalExpenditures(int id) {

		int update = jdbcTemplate.update(CommonConstants.DELETE_Pexpenditures_DETAILS, id);

		if (update == 1) {
			return true;

		} else {

			return false;
		}

	}

	@Override
	public boolean updatePersonalExpenditures(PersonalExpenditures pExpenditures) {

		try {

			int updatePersonalExpenditures = jdbcTemplate.update(CommonConstants.UPDATE_Pexpenditures_DETAILS,
					pExpenditures.getDate(), pExpenditures.getReason(), pExpenditures.getAmount(),
					pExpenditures.getId());

			if (updatePersonalExpenditures == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public PersonalExpenditures getPersonalExpendituresById(int id) {

		try {

			PersonalExpenditures perExpenditures = (PersonalExpenditures) jdbcTemplate.queryForObject(
					CommonConstants.GET_Pexpenditures_BY_NO, new Object[] { id },
					new BeanPropertyRowMapper(PersonalExpenditures.class));

			return perExpenditures;

		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}
	/*------------------------Shop----------------------*/

	@Override
	public boolean insertShopExpenditures(ShopExpenditures SpExpenditures) {

		int addSpExpenditures = jdbcTemplate.update(CommonConstants.INSERT_SHOP_EXPENDITURES_DETAILS,

				SpExpenditures.getDate(), SpExpenditures.getBillNo(), SpExpenditures.getName(),
				SpExpenditures.getReason(), SpExpenditures.getAmount());

		if (addSpExpenditures == 1) {
			return true;
		} else {
			// already working properly
			return false;
		}
	}

	@Override
	public List<ShopExpenditures> getAllShopExpenditures() {

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonConstants.GET_ALL_SHOP_EXPENDITURES_DETAILS);

		List<ShopExpenditures> result = new ArrayList<ShopExpenditures>();

		for (Map<String, Object> row : rows) {
			ShopExpenditures spExpen = new ShopExpenditures();

			spExpen.setId((Integer) row.get("id"));
			spExpen.setName((String) row.get("name"));
			spExpen.setBillNo((Integer) row.get("billNo"));
			spExpen.setReason((String) row.get("reason"));
			spExpen.setDate((String) row.get("date"));
			spExpen.setAmount((Double) row.get("amount"));

			result.add(spExpen);
		}
		// already working properly
		return result;
	}

	@Override
	public boolean deleteShopExpenditures(int id) {

		int update = jdbcTemplate.update(CommonConstants.DELETE_SHOP_EXPENDITURES_DETAILS, id);

		if (update == 1) {
			return true;
		} else {
			return false;
		}
	}

	// Load Data from Db to Edit Form's feilds
	@Override
	public ShopExpenditures getShopExpendituresById(int id) {

		return (ShopExpenditures) jdbcTemplate.queryForObject(CommonConstants.GET_SHOP_EXPENDITURES_BY_NO,
				new Object[] { id }, new RowMapper<ShopExpenditures>() {

					@Override
					public ShopExpenditures mapRow(ResultSet rs, int rwNumber) throws SQLException {

						ShopExpenditures shopExpe = new ShopExpenditures();

						shopExpe.setId(rs.getInt("id"));
						shopExpe.setName(rs.getString("name"));
						shopExpe.setDate(rs.getString("date"));
						shopExpe.setReason(rs.getString("reason"));
						shopExpe.setAmount(rs.getDouble("amount"));
						shopExpe.setBillNo(rs.getInt("billNo"));

						return shopExpe;

					}
				});

	}

	// Update the Shop Expenditures
	@Override
	public boolean updateShopExpenditures(ShopExpenditures SpExpenditures) {

		try {

			int updateShopExpenditures = jdbcTemplate.update(CommonConstants.UPDATE_SHOP_EXPENDITURES_DETAILS,
					SpExpenditures.getBillNo(), SpExpenditures.getName(), SpExpenditures.getDate(),
					SpExpenditures.getReason(), SpExpenditures.getAmount(), SpExpenditures.getId());

			if (updateShopExpenditures == 1) {
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
