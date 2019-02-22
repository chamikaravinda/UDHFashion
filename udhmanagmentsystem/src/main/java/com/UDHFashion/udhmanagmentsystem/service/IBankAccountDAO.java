package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;

import com.UDHFashion.udhmanagmentsystem.model.BankAccount;
import com.UDHFashion.udhmanagmentsystem.model.User;

public interface IBankAccountDAO {

	public boolean AddBanKAccounts(BankAccount account);
	public List<BankAccount> GetAllAccounts();
	public BankAccount GetBankAccount(int id);
	public boolean UpdateAccounts(BankAccount account);
}
