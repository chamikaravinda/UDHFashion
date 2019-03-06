package com.UDHFashion.udhmanagmentsystem.util;

public class CommonConstants {

	/*---------------------- Shop queries--------------------------*/
	public final static String INSERT_SHOP_DETAILS = "INSERT INTO shop(name,address,telephone) VALUES(?,?,?)";
	public final static String GET_ALL_SHOP_DETAILS = "SELECT * FROM shop";
	public final static String DELETE_SHOP_DETAILS = "DELETE FROM shop WHERE id = ?";
	public final static String UPDATE_SHOP_DETAILS = "UPDATE shop SET name = ? , address = ?,telephone = ? WHERE id = ?";
	public final static String GET_SHOP_BY_NO = "SELECT * FROM shop WHERE id = ?";
	
	/*-----------------------Employee queries--------------------------*/
	public final static String INSERT_EMPLOYEE_DETAILS = "INSERT INTO employee(empNo,empName,empAddress,basicSalary,jobDate,contactNum,gContactNum ) VALUES(?,?,?,?,?,?,?)";
	public final static String GET_ALL_EMPLOYEE_DETAILS = "SELECT * FROM employee";
	public final static String DELETE_EMPLOYEE_DETAILS = "DELETE FROM employee WHERE empNo = ?";
	public final static String UPDATE_EMPLOYEE_DETAILS = "UPDATE employee SET empName = ? , empAddress = ?,basicSalary = ?, jobDate = ?, contactNum = ?, gContactNum = ? WHERE empNo = ?";
	public final static String GET_EMPLOYEE_BY_NO = "SELECT * FROM employee WHERE empNo = ?";

	/*------------------------Personal Expenditures----------------------*/
	public final static String INSERT_Pexpenditures_DETAILS = "INSERT INTO p_expenditures(date,reason,amount) VALUES(?,?,?)";
	public final static String GET_ALL_Pexpenditures_DETAILS = "SELECT * FROM p_expenditures";
	public final static String DELETE_Pexpenditures_DETAILS = "DELETE FROM p_expenditures WHERE id = ?";
	public final static String UPDATE_Pexpenditures_DETAILS = "UPDATE p_expenditures SET date = ? , reason = ?,amount = ? WHERE id = ?";
	public final static String GET_Pexpenditures_BY_NO = "SELECT * FROM p_expenditures WHERE id = ?";

	/*------------------------Shop Expenditures----------------------*/
	public final static String INSERT_SHOP_EXPENDITURES_DETAILS = "INSERT INTO shop_expenditures(date,billNo,name,reason,amount) VALUES(?,?,?,?,?)";
	public final static String GET_ALL_SHOP_EXPENDITURES_DETAILS = "SELECT * FROM shop_expenditures";
	public final static String DELETE_SHOP_EXPENDITURES_DETAILS = "DELETE FROM shop_expenditures WHERE id = ?";
	public final static String UPDATE_SHOP_EXPENDITURES_DETAILS = "UPDATE shop_expenditures SET  billNo = ?, name = ? , date = ?, reason = ?, amount = ? WHERE id = ?";
	public final static String GET_SHOP_EXPENDITURES_BY_NO = "SELECT * FROM shop_expenditures WHERE id = ?";

	/*---------------------- Item queries--------------------------------*/
	public final static String GET_ITEM_CODES_BY_LIKE_OPERATOR = "SELECT code FROM item WHERE code LIKE '?%%?'";
	public final static String INSERT_STOCK_DETAILS = "INSERT INTO item(code,quantity,description,gross_price,net_price,price,discount_amount,est_net_profit,net_profit,shop_id) VALUES(?,?,?,?,?,?,?,?,?,?)";
	public final static String GET_ALL_ITEM_LIST = "SELECT * FROM item";
	public final static String GET_ITEM_BY_ID = "SELECT * FROM item WHERE code = ?";
	public final static String DELETE_ITEM_DETAILS = "DELETE FROM item WHERE code = ?";
	public final static String GET_ITEM_DATA_BY_ID = "SELECT * FROM item WHERE code = ?";
	public final static String UPDATE_ITEM_DATA = "UPDATE item SET quantity = ? , description = ?, gross_price = ?, net_price = ?, price = ?, discount_amount = ?, est_net_profit = ?, net_profit = ?, shop_id = ? WHERE code = ?";

	/*---------------------------Bar-code queries-------------------------------*/
	public final static String INSERT_BARCODE_DETAILS = "INSERT INTO temp_barcode_data(code,price,quantity) VALUES(?,?,?)";
	public final static String GET_ALL_BARCODE_DATA = "SELECT * FROM temp_barcode_data";
	public final static String DELETE_BARCODE_DATA = "DELETE FROM temp_barcode_data WHERE code = ?";
	public final static String GET_BARCODE_DATA_BY_ID = "SELECT * FROM temp_barcode_data WHERE code = ?";

	/*---------------------------User queries-------------------------------*/
	public final static String GET_USER_IS_VALID = "SELECT * FROM users WHERE username = ? AND password = ?";

	/*---------------------------Bank queries-------------------------------*/
	public final static String INSERT_BANK_DETAILS = "INSERT INTO bank_accounts(bank_name,account_number,account_type,current_balance) VALUES(?,?,?,?)";
	public final static String GET_ALL_BANK_ACCOUNT_DETAILS = "SELECT * FROM bank_accounts";
	public final static String GET_BANK_ACCOUNT = "SELECT * FROM bank_accounts WHERE id = ? ";
	public final static String UPDATE_BANK_ACCOUNT = "UPDATE bank_accounts SET bank_name = ? , account_number = ?, account_type = ?, current_balance = ? WHERE id = ?";
	public final static String INSERT_BANK_DEPOSIT = "INSERT INTO bank_deposites(date,amount,account) VALUES(?,?,?)";
	public final static String UPDATE_BANK_ACCOUNT_BALANCE = "UPDATE bank_accounts SET current_balance = ? WHERE id = ?";
	public final static String GET_ALL_DEPOSITE_DETAILS = "SELECT * FROM bank_deposites ORDER BY id DESC";
	
	
	/*---------------------------Credit Bills-------------------------------*/
	public final static String INSERT_CREDITBILL_DETAILS = "INSERT INTO credit_bill(billNo,billDate,shopName,billAmount) VALUES(?,?,?,?)";
	public final static String GET_ALL_CREDITBILL_DETAILS = "SELECT * FROM credit_bill";
	public final static String DELETE_CREDITBILL_DETAILS = "DELETE FROM credit_bill WHERE billNo = ?";
	public final static String DELETE_CREDITBILL_DETAILS_ID = "DELETE FROM credit_bill WHERE id = ?";
	public final static String UPDATE_CREDITBILL_DETAILS = "UPDATE credit_bill SET billNo = ? , billDate = ?,shopName = ?,billAmount=? WHERE empNo = ?";
	public final static String GET_CREDITBILL_BY_NO = "SELECT * FROM credit_bill WHERE id = ?";
	
	
	/*---------------------------Cash Payments-------------------------------*/
	
	
	public final static String INSERT_CASHPAYMENT_DETAILS ="INSERT INTO cash_payment(billNo,billDate,shopName,billAmount,paymentDate) VALUES(?,?,?,?,?)"; 
	public final static String GET_ALL_CASHPAYMENT_DETAILS = "SELECT * FROM cash_payment";
	
	/*--------------------------Cheque Payments-------------------------------*/
	
	public final static String INSERT_CHEQUE_DETAILS ="INSERT INTO cheque_payment(billNo,billDate,shopNo,shopName,bankName,bankAccountNo,chequeNo,chequeAmount,chequeDate,paymentDate,paymentAmount ) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	public final static String GET_ALL_CHEQUE_DETAILS = "SELECT * FROM cheque_payment";
	
	/*---------------------------Paid Bills Payments-------------------------------*/
	public final static String INSERT_PAIDBILL_DETAILS ="INSERT INTO paid_bill(billNo,billDate,shopName,billAmount,paymentDate,paymentMethod) VALUES(?,?,?,?,?,?)"; 
	public final static String GET_ALL_PAIDBILL_DETAILS = "SELECT * FROM paid_bill";
}
