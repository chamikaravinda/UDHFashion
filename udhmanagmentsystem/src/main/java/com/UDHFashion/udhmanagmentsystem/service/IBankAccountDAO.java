package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;

import com.UDHFashion.udhmanagmentsystem.model.BankAccount;
import com.UDHFashion.udhmanagmentsystem.model.BankDeposites;
import com.UDHFashion.udhmanagmentsystem.model.BankWithdraws;
import com.UDHFashion.udhmanagmentsystem.model.User;

public interface IBankAccountDAO {

	public boolean AddBanKAccounts(BankAccount account);
	public List<BankAccount> GetAllAccounts();
	public BankAccount GetBankAccount(int id);
	public boolean UpdateAccounts(BankAccount account);
	public boolean AddBanKDeposit(BankDeposites deposit);
	public boolean UpdateBankBalance(BankDeposites deposit);
	public List<BankDeposites> GetAllDeposites();
	boolean AddBanKWithdraws(BankWithdraws withdraws);
	boolean UpdateBankBalanceAfterWithdraw(BankWithdraws deposit);
	List<BankWithdraws> GetAllWithdraws();
	boolean RemoveAccount(int id);
}
