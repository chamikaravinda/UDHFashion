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
	public final static String CALCUALTE_ROW_IN_TABLE = "SELECT COUNT(*) FROM item";
	
	/*---------------------------Bar-code queries-------------------------------*/
	public final static String INSERT_BARCODE_DETAILS = "INSERT INTO temp_barcode_data(code,price,quantity) VALUES(?,?,?)";
	public final static String GET_ALL_BARCODE_DATA = "SELECT * FROM temp_barcode_data";
	public final static String DELETE_BARCODE_DATA = "DELETE FROM temp_barcode_data WHERE code = ?";
	public final static String GET_BARCODE_DATA_BY_ID = "SELECT * FROM temp_barcode_data WHERE code = ?";

	/*---------------------------User queries-------------------------------*/
	public final static String GET_USER_IS_VALID = "SELECT * FROM users WHERE username = ? AND password = ?";
	public final static String INSERT_USER = "INSERT INTO users (fname,lname,username ,password,role) VALUES(?,?,?,?,?)";
	public final static String UPDATE_USER = "UPDATE  users SET fname=?,lname=?,username=? ,password=?,role=? WHERE id = ?";
	public final static String DELETE_USER = "DELETE FROM users WHERE id = ?";
	public final static String GET_USERS   = "SELECT * FROM users";
	public final static String GET_USER = "SELECT * FROM users WHERE id=?";

	
	/*---------------------------Bank queries-------------------------------*/
	public final static String INSERT_BANK_DETAILS = "INSERT INTO bank_accounts(bank_name,account_number,account_type,current_balance) VALUES(?,?,?,?)";
	public final static String GET_ALL_BANK_ACCOUNT_DETAILS = "SELECT * FROM bank_accounts";
	public final static String GET_BANK_ACCOUNT = "SELECT * FROM bank_accounts WHERE id = ? ";
	public final static String UPDATE_BANK_ACCOUNT = "UPDATE bank_accounts SET bank_name = ? , account_number = ?, account_type = ?, current_balance = ? WHERE id = ?";
	public final static String INSERT_BANK_WITHDRAW = "INSERT INTO bank_withdraws(date,amount,account) VALUES(?,?,?)";
	public final static String UPDATE_BANK_ACCOUNT_BALANCE = "UPDATE bank_accounts SET current_balance = ? WHERE id = ?";
	public final static String GET_ALL_DEPOSITE_DETAILS = "SELECT * FROM bank_deposites ORDER BY id DESC";

	public final static String INSERT_BANK_DEPOSIT = "INSERT INTO bank_deposites(date,amount,account) VALUES(?,?,?)";
	public final static String GET_ALL_WITHDRAW_DETAILS = "SELECT * FROM bank_withdraws ORDER BY id DESC";

	/*---------------------------Credit Bills-------------------------------*/
	public final static String INSERT_CREDITBILL_DETAILS = "INSERT INTO credit_bill(billNo,billDate,shopName,billAmount) VALUES(?,?,?,?)";
	public final static String GET_ALL_CREDITBILL_DETAILS = "SELECT * FROM credit_bill";
	public final static String DELETE_CREDITBILL_DETAILS = "DELETE FROM credit_bill WHERE billNo = ?";
	public final static String DELETE_CREDITBILL_DETAILS_ID = "DELETE FROM credit_bill WHERE id = ?";
	public final static String UPDATE_CREDITBILL_DETAILS = "UPDATE credit_bill SET billNo = ? , billDate = ?,shopName = ?,billAmount=? WHERE id = ?";
	public final static String GET_CREDITBILL_BY_NO = "SELECT * FROM credit_bill WHERE id = ?";
	public final static String GET_CREDITBILL_BY_BILL_NO = "SELECT * FROM credit_bill WHERE billNo = ?";

	/*---------------------------Cash Payments-------------------------------*/

	public final static String INSERT_CASHPAYMENT_DETAILS = "INSERT INTO cash_payment(billNo,billDate,shopName,billAmount,paymentDate) VALUES(?,?,?,?,?)";
	public final static String GET_ALL_CASHPAYMENT_DETAILS = "SELECT * FROM cash_payment ORDER BY id DESC";

	/*--------------------------Cheque Payments-------------------------------*/

	public final static String INSERT_CHEQUE_DETAILS = "INSERT INTO cheque_payment(billNo,billDate,billAmount,shopName,bankName,bankAccount,chequeNo,chequeDate,paymentDate) VALUES(?,?,?,?,?,?,?,?,?)";
	public final static String GET_ALL_CHEQUE_DETAILS = "SELECT * FROM cheque_payment ORDER BY id DESC";

	/*---------------------------Paid Bills Payments-------------------------------*/
	public final static String INSERT_PAIDBILL_DETAILS = "INSERT INTO paid_bill(billNo,billDate,shopName,billAmount,paymentDate,paymentMethod) VALUES(?,?,?,?,?,?)";
	public final static String GET_ALL_PAIDBILL_DETAILS = "SELECT * FROM paid_bill";

	/*---------------------------All SQL about Sales-------------------------------::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::;*/

	/*---------------------------Temporary Bill-------------------------------*/
	public final static String INSERT_TEMPBILL_DETAILS = "INSERT INTO temp_bill(date,cashireId,grossAmount,netAmount,totalDiscount,balance) VALUES(?,?,?,?,?,?)";
	public final static String GET_ALL_TEMPBILL_DETAILS = "SELECT * FROM temp_bill where cashireId=?";
	public final static String DELETE_TEMPBILL_DETAILS_ID = "DELETE FROM temp_bill WHERE cashireId= ?";

	public final static String GET_TEMPBILL_BY_NO = "SELECT * FROM temp_bill WHERE id = ?";

	/*---------------------------Temporary Bill Items-------------------------------*/

	public final static String INSERT_TEMPBILLITEM_DETAILS = "INSERT INTO temp_bill_items(itemNo,price,qty,reduseDiscount,amount,cashireId)VALUES(?,?,?,?,?,?)";
	public final static String GET_ALL_TEMPBILLITEM_DETAILS = "SELECT * FROM temp_bill_items WHERE cashireId=?";
	public final static String DELETE_TEMPBILLITEM_DETAILS_ID = "DELETE FROM temp_bill_items WHERE cashireId= ?";

	public final static String GET_TEMPBILLITEM_BY_NO = "SELECT * FROM temp_bill_items WHERE id = ?";

	/*---------------------------Bill-------------------------------*/
	public final static String INSERT_BILL_DETAILS = "INSERT INTO bill(date,cashireId,grossAmount,netAmount,totalDiscount,balance,noOfItem,returnAmount ) VALUES(?,?,?,?,?,?,?,?)";
	public final static String GET_ALL_BILL_DETAILS = "SELECT * FROM bill";
	public final static String DELETE_BILL_DETAILS_ID = "DELETE FROM bill WHERE cashireId= ?";

	public final static String GET_BILL_BY_NO = "SELECT * FROM bill WHERE id = ?";

	/*-------------------------- Bill items --------------------------------------*/
	public final static String INSERT_BILL_ITEMS = "INSERT INTO bill_items(itemNo,price,qty,billId,reduseDiscount,amount)VALUES(?,?,?,?,?,?)";
	public final static String GET_BILLITEM_DETAILS = "SELECT * FROM bill_items WHERE billId=?";
	

	/*---------------------------Daily Business-----------------------------------*/
	public final static String INSERT_CRITICAL_SECTION = "INSERT INTO daily_busssiness(id,date,expenseAmount,bussinesAmount,returnAmount,netProfite,flag ) VALUES(?,?,?,?,?,?,?)";
	public final static String INSERT_DAILY_BUSINESS = "INSERT INTO daily_busssiness(date,expenseAmount,bussinesAmount,returnAmount,netProfite,flag ) VALUES(?,?,?,?,?,?)";
	public final static String GET_CRITICAL_SECTION = "SELECT * FROM daily_busssiness WHERE id = 1";
	public final static String UPDATE_CRITICAL_SECTION = "UPDATE daily_busssiness SET flag = ? WHERE id=1 ";
	public final static String GET_TODAY_ENTRY = "SELECT * FROM daily_busssiness WHERE date= ?";
	public final static String UPDATE_TODAT_ENTRY = "UPDATE daily_busssiness SET expenseAmount = ? ,bussinesAmount = ?,returnAmount = ?,netProfite= ? WHERE date = ? ";
	public final static String GET_DAILY_BUSINESS = "SELECT * FROM daily_busssiness ORDER BY id DESC;" ;
			
	/*--------------------------- Attendance -----------------------------------*/

	public final static String GET_TODAY_ATTENDENCE = "SELECT * FROM attendence WHERE date = ?";
	public final static String GET_TODAY_ATTENDENCE_LIST = "SELECT * FROM attendence_list WHERE date = ?";
	public final static String GET_TODAY_EMP_ATTENDENCE_LIST = "SELECT * FROM attendence_list WHERE id = ?";
	public final static String INSERT_DAILY_ATTENDENCE = "INSERT INTO attendence(date,present,absent) VALUES(?,?,?)";
	public final static String INSERT_EMP_ATTENDENCE = "INSERT INTO attendence_list(date,empNo,attendence_ID,status,reason) VALUES(?,?,?,?,?)";
	public final static String UPDATE_EMP_ATTENDENCE = "UPDATE attendence_list SET date =?,empNo=?,attendence_ID=?,status=?,reason=?  WHERE id=? ";
	public final static String UPDATE_DAILY_ATTENDENCE = "UPDATE attendence SET date =?,present=?,absent=? WHERE id=?";
	public final static String GET_TODAY_ATTENDENCE_LIST_BY_STATUS= "SELECT * FROM attendence_list WHERE status = 'PRESENT' ";
	
	/*-------------------------- Salary ---------------------------------------*/
	public final static String INSERT_EMP_SALARY = "INSERT INTO salary (empNo,empName,absent,present,totalBussines,monthlyBasic,basicSalary,bonus,advance_payment ,TotalSalray ) VALUES(?,?,?,?,?,?,?,?,?,?) ";
	public final static String UPDATE_EMP_SALARY = "UPDATE salary set empNo=?,empName=?,absent=?,present=?,totalBussines=?,monthlyBasic=?,basicSalary=?,bonus=?,advance_payment=?,TotalSalray=? WHERE id=?";
	public final static String GET_EMP_SALARY  = "SELECT * FROM salary WHERE empNo=?";
	public final static String GET_EMP_SALARY_ID  = "SELECT * FROM salary WHERE id=?";
	public final static String GET_ALL_EMP_SALARY  = "SELECT * FROM salary";
	public final static String GET_ALL_PAID_SALARY  = "SELECT * FROM payied_salary ORDER BY id DESC;";
	public final static String INSERT_PAID_EMP_SALARY = "INSERT INTO payied_salary (empNo,empName,absent,present,totalBussines,monthlyBasic,basicSalary,bonus,advance_payment ,TotalSalray,date) VALUES(?,?,?,?,?,?,?,?,?,?,?) ";
	public final static String DELETE_SALARY = "DELETE FROM salary WHERE id= ?";
  
	/*-------------------------- Return note Quearys ---------------------------------------*/
	public final static String UPDATE_RETURN_ITEM = "UPDATE item SET quantity = ? WHERE code = ?";
  
	/*-------------PritnNoteReturnItems---------------------------------*/
	
	public final static String INSERT_PRINT_RETURN_BILL_ITEM_DETAILS = "INSERT INTO  print_note_items(itemNo,price,qty,billId,reduseDiscount,amount)VALUES(?,?,?,?,?,?)";
	public final static String GET_PRINT_RETURN_BILL_ITEM_DETAILS = "SELECT * FROM  print_note_items ";
	
	public final static String DELETE_PRINT_RETURN_BILL_ITEM_DETAILS="DELETE FROM  print_note_items";
	


	/*---------------------------Temporary return Bill-------------------------------*/
	public final static String INSERT_TEMP_RETURN_BILL_DETAILS = "INSERT INTO temp_return_bill(id,date,cashireId,grossAmount,netAmount,totalDiscount,balance,noOfItem) VALUES(?,?,?,?,?,?,?,?)";
	public final static String GET_ALL_TEMP_RETURN_BILL_DETAILS = "SELECT * FROM temp_return_bill where cashireId=?";
	public final static String DELETE_TEMP_RETURN_BILL_DETAILS_ID = "DELETE FROM temp_return_bill WHERE cashireId= ?";
	public final static String GET_TEM_BILL_BY_ID = "SELECT * FROM temp_return_bill WHERE id = ?";


	/*---------------------------Temporary Return Bill Items-------------------------------*/
	
	
	public final static String INSERT_TEMP_RETURN_BILL_ITEM_DETAILS = "INSERT INTO temp_return_bill_items(itemNo,price,qty,billId,reduseDiscount,amount)VALUES(?,?,?,?,?,?)";
	public final static String GET_TEMP_RETURN_BILL_ITEM_DETAILS = "SELECT * FROM temp_return_bill_items WHERE billId=?";	
	public final static String DELETE_TEMP_RETURN_BILL_ITEM_DETAILS="DELETE FROM temp_return_bill_items WHERE id= ?";

}