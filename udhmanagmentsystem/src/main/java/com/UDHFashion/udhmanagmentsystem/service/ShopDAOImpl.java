package com.UDHFashion.udhmanagmentsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.UDHFashion.udhmanagmentsystem.model.Shop;
import com.UDHFashion.udhmanagmentsystem.util.CommonConstants;

@Service
public class ShopDAOImpl implements IShopDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertShopDetails(Shop shop) {
		
		int update = jdbcTemplate.update(CommonConstants.INSERT_SHOP_DETAILS, shop.getShopName(), shop.getShopAddress(), shop.getShopTelephone());
		
		if( update == 1 ) {
			System.out.println("Shop Detail added to the database");
		}
		
	}

	@Override
	public List<Shop> getAllShopsDetails() {
			
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonConstants.GET_ALL_SHOP_DETAILS);
		
		List<Shop> result = new ArrayList<Shop>();
		
		for(Map<String, Object> row : rows){
			Shop shop = new Shop();

			shop.setShopId((Integer)row.get("id"));
			shop.setShopName((String)row.get("name"));
			shop.setShopAddress((String)row.get("address"));
			shop.setShopTelephone((String)row.get("telephone"));
			
			System.out.println("Shop Name Debug :  "  +shop.getShopName());
			
			result.add(shop);
		}
		
		return result;
	}

	@Override
	public void deleteShop(int shopId) {
		
		int update = jdbcTemplate.update(CommonConstants.DELETE_SHOP_DETAILS, shopId);
		
		if(update == 1 ) {
			System.out.println("Shop Detail deleted successfully ");
		}
	}
	
	
}
