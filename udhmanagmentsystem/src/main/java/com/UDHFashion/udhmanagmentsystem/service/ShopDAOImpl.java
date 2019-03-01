package com.UDHFashion.udhmanagmentsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.UDHFashion.udhmanagmentsystem.model.Employee;
import com.UDHFashion.udhmanagmentsystem.model.Shop;
import com.UDHFashion.udhmanagmentsystem.model.updateShop;
import com.UDHFashion.udhmanagmentsystem.util.CommonConstants;

@Service
public class ShopDAOImpl implements IShopDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertShopDetails(Shop shop) {

		int update = jdbcTemplate.update(CommonConstants.INSERT_SHOP_DETAILS, shop.getShopName(), shop.getShopAddress(),
				shop.getShopTelephone());

		if (update == 1) {
			System.out.println("Shop Detail added to the database");
		}

	}

	// Read All Data from DB
	@Override
	public List<Shop> getAllShopsDetails() {

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonConstants.GET_ALL_SHOP_DETAILS);

		List<Shop> result = new ArrayList<Shop>();

		for (Map<String, Object> row : rows) {
			Shop shop = new Shop();

			shop.setShopId((Integer) row.get("id"));
			shop.setShopName((String) row.get("name"));
			shop.setShopAddress((String) row.get("address"));
			shop.setShopTelephone((String) row.get("telephone"));

			System.out.println("Shop Name Debug :  " + shop.getShopName());

			result.add(shop);
		}

		return result;
	}

	// Delete selected Shop by iD
	@Override
	public void deleteShop(int shopId) {

		int update = jdbcTemplate.update(CommonConstants.DELETE_SHOP_DETAILS, shopId);

		if (update == 1) {
			System.out.println("Shop Detail deleted successfully ");
		}
	}

	// Update the Shop Details(Currently work with it)....3:57PM 19/2/25

	@Override
	public void updateShopDetails(updateShop Ushop) {

		int updateShop = jdbcTemplate.update(CommonConstants.UPDATE_SHOP_DETAILS,

				Ushop.getName(), 
				Ushop.getAddress(), 
				Ushop.getTelephone(),
				Ushop.getId());

		if (updateShop == 1) {

			System.out.println("Shop Detail update to the System");

		}
	}

	
	//Get Details by ID
	@Override
	public updateShop getShopById(int id) {
		
		return (updateShop) jdbcTemplate.queryForObject(CommonConstants.GET_SHOP_BY_NO, new Object[] {id},
				new RowMapper<updateShop>() {

					@Override
					public updateShop mapRow(ResultSet rs, int rwNumber) throws SQLException {
						updateShop Ushop = new updateShop();
						
						Ushop.setId(((Integer)rs.getInt("id")));
						Ushop.setName((String)rs.getString("name"));
						Ushop.setAddress((String)rs.getString("address"));
						Ushop.setTelephone(((String)rs.getString("telephone")));

						

						return Ushop;
					}
				});
		

//		updateShop ushop=(updateShop)jdbcTemplate.queryForObject(CommonConstants.GET_SHOP_BY_NO, 
//				new Object[] {id},new BeanPropertyRowMapper<updateShop>(updateShop.class) );
//		
//		return null;

		
		
	}

	@Override
	public void updateShopDetails(Shop shop) {
		// TODO Auto-generated method stub
		
	}

}
