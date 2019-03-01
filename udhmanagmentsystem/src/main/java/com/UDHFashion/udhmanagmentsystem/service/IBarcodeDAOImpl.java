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

import com.UDHFashion.udhmanagmentsystem.model.Barcode;
import com.UDHFashion.udhmanagmentsystem.model.Item;
import com.UDHFashion.udhmanagmentsystem.util.CommonConstants;

@Service
public class IBarcodeDAOImpl implements IBarcodeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertBarcodeDetails(Barcode barcode) {
		int update = jdbcTemplate.update(CommonConstants.INSERT_BARCODE_DETAILS, barcode.getItemCode(),
				barcode.getPrice(), barcode.getQuantity());
		
		if( update == 1 ) {
			System.out.println("Barcode data added successfully ");
		}

	}

	@Override
	public List<Barcode> getAllBarcodeDetails() {
		
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(CommonConstants.GET_ALL_BARCODE_DATA);
		
		List<Barcode> result =  new ArrayList<Barcode>();
		
		for( Map<String,Object> row : rows ) {
			
			Barcode barcode = new Barcode();
			
			barcode.setItemCode((String)row.get("code"));
			barcode.setPrice((Double)row.get("price"));
			barcode.setQuantity((Integer)row.get("quantity"));
			
			result.add(barcode);
		}
		
		return result;
	}

	@Override
	public void deleteBarcodeData(String itemCode) {
		
		int update = jdbcTemplate.update(CommonConstants.DELETE_BARCODE_DATA, itemCode);
		
		if(update ==  1 ) {
			System.out.println("Barcode record removed ");
		}
	}

	@Override
	public boolean isBarcordRecorded(String itemCode) {
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonConstants.GET_BARCODE_DATA_BY_ID, itemCode);
		
		List<Barcode> result = new ArrayList<Barcode>();
		
		Barcode bar = new Barcode();
		
		for( Map<String,Object> row : rows ) {
			
			bar.setItemCode((String)row.get("code"));
			result.add(bar);
		}
		
		if(result.size() == 0 ) {
			return false;
		}else {
			return true;
		}
		
	}

}
