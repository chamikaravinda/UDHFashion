package com.UDHFashion.udhmanagmentsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.UDHFashion.udhmanagmentsystem.model.PersonalExpenditures;
import com.UDHFashion.udhmanagmentsystem.model.Shop;
import com.UDHFashion.udhmanagmentsystem.model.ShopExpenditures;
import com.UDHFashion.udhmanagmentsystem.util.CommonConstants;

@Service
public class IExpendituresDAOImpl implements IExpendituresDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertPersonalExpenditures(PersonalExpenditures pExpenditures) {
	
		
		int addPexpenditures = jdbcTemplate.update(CommonConstants.INSERT_Pexpenditures_DETAILS, 
				pExpenditures.getDate(),
				pExpenditures.getReason(), 
				pExpenditures.getAmount());
			
				if (addPexpenditures == 1) {
				System.out.println("Employee Detail added to the System");
				}
		
	}

	@Override
	public List<PersonalExpenditures> getAllPersonalExpenditures() {
	
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonConstants.GET_ALL_Pexpenditures_DETAILS);
		
		List<PersonalExpenditures> result = new ArrayList<>();
		
		for(Map<String, Object> row : rows){
			PersonalExpenditures pExpenditures = new PersonalExpenditures();

			pExpenditures.setId((Integer)row.get("id"));
			pExpenditures.setDate((String)row.get("date"));
			pExpenditures.setReason((String)row.get("reason"));
			pExpenditures.setAmount((Double)row.get("amount"));
			
			System.out.println("Shop Name Debug :  "  +pExpenditures.getAmount());
			
			result.add(pExpenditures);
		}
		
		return result;
		
		
		
		
		
	}

	@Override
	public void deletePersonalExpenditures(int id) {

		int update = jdbcTemplate.update(CommonConstants. DELETE_Pexpenditures_DETAILS, id);
		
		if(update == 1 ) {
			System.out.println("PersoanlExpenditure Detail deleted successfully ");
		}
		
	}

	@Override
	public void updatePersonalExpenditures(PersonalExpenditures pExpenditures) {
		
		
	}

	@Override
	public PersonalExpenditures getPersonalExpendituresById(int id) {
		
		return null;
	}
  /*------------------------Shop----------------------*/

	@Override
	public void insertShopExpenditures(ShopExpenditures SpExpenditures) {
		

		int addSpExpenditures = jdbcTemplate.update(CommonConstants.INSERT_SHOP_EXPENDITURES_DETAILS, 
				
				
				SpExpenditures.getDate(),
				SpExpenditures.getBillNo(),
				SpExpenditures.getName(),
				SpExpenditures.getReason(), 
				SpExpenditures.getAmount());
			
				if (addSpExpenditures == 1) {
				System.out.println("Employee Detail added to the System");
				}
		//already working properly	
	}

	@Override
	public List<ShopExpenditures> getAllShopExpenditures() {
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonConstants.GET_ALL_SHOP_EXPENDITURES_DETAILS);
		
		List<ShopExpenditures> result = new ArrayList<ShopExpenditures>();
		
		for(Map<String, Object> row : rows){
			ShopExpenditures spExpen = new ShopExpenditures();

			spExpen.setId((Integer)row.get("id"));
			spExpen.setName((String)row.get("name"));
			spExpen.setBillNo((Integer)row.get("billNo"));
			spExpen.setReason((String)row.get("reason"));
			spExpen.setDate((String)row.get("date"));
			spExpen.setAmount((Double)row.get("amount"));
			
			
			System.out.println("Shop Name Debug :  "  +spExpen.getName());
			
			result.add(spExpen);
		}
		//already working properly	
		return result;
	}

	@Override
	public void deleteShopExpenditures(int id) {
		
		int update = jdbcTemplate.update(CommonConstants.DELETE_SHOP_EXPENDITURES_DETAILS, id);
		
		if(update == 1 ) {
			System.out.println("ShopExpenditure Detail deleted successfully ");
		}
		
		
	}

	@Override
	public void updateShopExpenditures(ShopExpenditures SpExpenditures) {
		
		
		
		
		
		
	}

	@Override
	public PersonalExpenditures getShopExpendituresById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
