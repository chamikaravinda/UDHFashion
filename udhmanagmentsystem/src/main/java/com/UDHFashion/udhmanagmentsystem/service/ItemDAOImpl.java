package com.UDHFashion.udhmanagmentsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.UDHFashion.udhmanagmentsystem.model.Item;
import com.UDHFashion.udhmanagmentsystem.util.CommonConstants;
import com.UDHFashion.udhmanagmentsystem.util.Generator;

@Service
public class ItemDAOImpl implements IItemDAO {

	private static DecimalFormat df2 = new DecimalFormat(".##");

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertStockDetails(Item item) {

		System.out.println("item desc : " + item.getItemDescription());
		// get the ID
		String itemCode = getNextItemCode(item.getPrice(), item.getShopId());

		double netPrice = calculateNetPrice(item.getPrice(), item.getDiscount());
		double netProfit = calculateNetProfit(item.getGrossPrice(), netPrice);
		double estimatedNetProfit = calculateEstimatedNetProfit(netProfit, item.getItemQuantity());

		double priceRoundOff = Math.round(item.getPrice() * 100.0) / 100.0;

		System.out.println("Item Code : " + itemCode);

		int update = jdbcTemplate.update(CommonConstants.INSERT_STOCK_DETAILS, itemCode, item.getItemQuantity(),
				item.getItemDescription(), item.getGrossPrice(), df2.format(netPrice), df2.format(priceRoundOff),
				item.getDiscount(), df2.format(estimatedNetProfit), df2.format(netProfit), item.getShopId());

		if (update == 1) {
			System.out.println("Stock Details added to the database");
		}

	}

	@Override
	public String getNextItemCode(double price, int shopId) {

		int intPrice = (int) price;

		String stripPriceString = Integer.toString(intPrice);

		System.out.println("Substring Vlaues : "
				+ stripPriceString.substring(stripPriceString.length() - 2, stripPriceString.length()));

		intPrice = Integer
				.parseInt(stripPriceString.substring(stripPriceString.length() - 2, stripPriceString.length()));

		String query = "SELECT code FROM item WHERE code LIKE 'I" + Integer.toString(shopId) + "%%"
				+ Integer.toString(intPrice) + "'";

		System.out.println("Query befor : " + query);

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

		if (rows.isEmpty()) {
			if (intPrice == 0) { // check whether the price stripped value is 0

				return "I" + shopId + "100" + "00";

			} else {

				return "I" + shopId + "100" + intPrice;

			}

		}

		System.out.println("Query : " + query);

		List<String> resultIDs = new ArrayList<String>();

		for (Map<String, Object> row : rows) {

			Item item = new Item();

			item.setItemCode((String) row.get("code"));

			resultIDs.add(item.getItemCode());
		}

		return Generator.generateNextItemCode(resultIDs, shopId);
	}

	@Override
	public double calculateNetPrice(double priceTagAmount, int discount) {

		double netPrice = priceTagAmount - discount;
		return netPrice;
	}

	@Override
	public double calculateEstimatedNetProfit(double netProfit, int quantity) {

		return netProfit * quantity;
	}

	@Override
	public double calculateNetProfit(double grossPrice, double netPrice) {

		return netPrice - grossPrice;
	}

	@Override
	public List<Item> getAllItemDetails() {

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonConstants.GET_ALL_ITEM_LIST);

		List<Item> result = new ArrayList<Item>();

		for (Map<String, Object> row : rows) {

			Item item = new Item();

			item.setItemCode((String) row.get("code"));
			item.setItemDescription((String) row.get("description"));
			item.setItemQuantity((Integer) row.get("quantity"));
			item.setGrossPrice((Double) row.get("gross_price"));
			item.setNetPrice((Double) row.get("net_price"));
			item.setPrice((Double) row.get("price"));
			item.setDiscount((Integer) row.get("discount_amount"));
			item.setEstimatedNetProfit((Double) row.get("est_net_profit"));
			item.setNetProfit((Double) row.get("net_profit"));
			item.setShopId((Integer) row.get("shop_id"));

			result.add(item);
		}

		return result;
	}

	@Override
	public Item getItemById(String id) {

		return (Item) jdbcTemplate.queryForObject(CommonConstants.GET_ITEM_BY_ID, new Object[] { id },
				new RowMapper<Item>() {

					@Override
					public Item mapRow(ResultSet rs, int rwNumber) throws SQLException {
						Item item = new Item();
						item.setItemCode(rs.getString("code"));
						item.setItemDescription(rs.getString("description"));
						item.setItemQuantity(rs.getInt("quantity"));
						item.setGrossPrice(rs.getDouble("gross_price"));
						item.setNetPrice(rs.getDouble("net_price"));
						item.setPrice(rs.getDouble("price"));
						item.setShopId(rs.getInt("shop_id"));
						item.setDiscount(rs.getInt("discount_amount"));
						item.setPrice(Double.parseDouble(rs.getString("price")));
						item.setNetProfit(rs.getDouble("net_profit"));
						return item;
					}
				});

	}

	@Override
	public void deleteItem(String itemCode) {

		int update = jdbcTemplate.update(CommonConstants.DELETE_ITEM_DETAILS, itemCode);

		if (update == 1) {
			System.out.println("Item detail deleted ! ");
		}

	}

	@Override
	public boolean isItemRecorded(String itemCode) {

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonConstants.GET_ITEM_DATA_BY_ID, itemCode);

		List<Item> result = new ArrayList<Item>();

		Item item = new Item();

		for (Map<String, Object> row : rows) {

			item.setItemCode((String) row.get("code"));
			result.add(item);
		}

		if (result.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void updateItemDetails(Item item) {

		double netPrice = calculateNetPrice(item.getPrice(), item.getDiscount());
		double netProfit = calculateNetProfit(item.getGrossPrice(), netPrice);
		double estimatedNetProfit = calculateEstimatedNetProfit(netProfit, item.getItemQuantity());

		netPrice = Math.round(netPrice * 100.0) / 100.0;
		netProfit = Math.round(netProfit * 100.0) / 100.0;
		estimatedNetProfit = Math.round(estimatedNetProfit * 100.0) / 100.0;

		double priceRoundOff = Math.round(item.getPrice() * 100.0) / 100.0;

		int update = jdbcTemplate.update(CommonConstants.UPDATE_ITEM_DATA, item.getItemQuantity(),
				item.getItemDescription(), item.getGrossPrice(), df2.format(netPrice), df2.format(priceRoundOff),
				item.getDiscount(), df2.format(estimatedNetProfit), df2.format(netProfit), item.getShopId(),
				item.getItemCode());

		System.out.println("Updated : " + item.getItemCode());

		if (update == 1) {
			System.out.println("Item Updated successfully ");
		}
	}

	@Override
	public boolean updateReturnItem(Item item) {

		try {

			int updateReturnItem = jdbcTemplate.update(CommonConstants.UPDATE_RETURN_ITEM,

					item.getItemQuantity(), item.getItemCode());

			if (updateReturnItem == 2) {

				return true;

			} else {
				return false;
			}

		} finally {

		}
	}

	@Override
	public Item getItemByCode(String itemCode) {

		return (Item) jdbcTemplate.queryForObject(CommonConstants.GET_ITEM_BY_ID, new Object[] { itemCode },
				new RowMapper<Item>() {

					@Override
					public Item mapRow(ResultSet rs, int rwNumber) throws SQLException {
						Item itemdb = new Item();
						itemdb.setItemCode(rs.getString("code"));
						itemdb.setItemDescription(rs.getString("description"));
						itemdb.setItemQuantity(rs.getInt("quantity"));
						itemdb.setGrossPrice(rs.getDouble("gross_price"));
						itemdb.setNetPrice(rs.getDouble("net_price"));
						itemdb.setPrice(rs.getDouble("price"));
						itemdb.setShopId(rs.getInt("shop_id"));
						itemdb.setDiscount(rs.getInt("discount_amount"));
						itemdb.setPrice(Double.parseDouble(rs.getString("price")));
						itemdb.setNetProfit(rs.getDouble("net_profit"));
						itemdb.setEstimatedNetProfit(Double.parseDouble(rs.getString("est_net_profit")));		
						return itemdb;
					}
				});
	}
	

	
}