package com.UDHFashion.udhmanagmentsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.UDHFashion.udhmanagmentsystem.model.BankAccount;
import com.UDHFashion.udhmanagmentsystem.model.User;
import com.UDHFashion.udhmanagmentsystem.util.CommonConstants;

@Service
public class BankAccountsDAOImpl implements IBankAccountDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean AddBanKAccounts(BankAccount account) {

		try {
			int update = jdbcTemplate.update(CommonConstants.INSERT_BANK_DETAILS, account.getBankName(),
					account.getAccountNumber(), account.getAccountType(), account.getCurrentBalance());

			if (update == 1) {
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
	public List<BankAccount> GetAllAccounts() {
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonConstants.GET_ALL_BANK_ACCOUNT_DETAILS);

		List<BankAccount> result = new ArrayList<>();

		for (Map<String, Object> row : rows) {
			BankAccount account = new BankAccount();

			account.setId((Integer) row.get("id"));
			account.setBankName((String) row.get("bank_name"));
			account.setAccountNumber((String) row.get("account_number"));

			String accountType = (String) row.get("account_type");
			if (accountType.equals("currentAccount")) {
				account.setAccountType("Current Account");
			} else {
				account.setAccountType("Savings Account");
			}
			double acc_balance = Double.parseDouble((String) row.get("current_balance"));
			account.setCurrentBalance(acc_balance);
			result.add(account);
		}

		return result;
	}

	@Override
	public BankAccount GetBankAccount(int id) {

		try {

			BankAccount account = (BankAccount) jdbcTemplate.queryForObject(CommonConstants.GET_BANK_ACCOUNT,
					new Object[] { id }, new BeanPropertyRowMapper(BankAccount.class));

			return account;

		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public boolean UpdateAccounts(BankAccount account) {
		int update = jdbcTemplate.update(CommonConstants.UPDATE_BANK_ACCOUNT, account.getBankName(),
				account.getAccountNumber(), account.getAccountType(), account.getCurrentBalance(),account.getId());

		if (update == 1) {
			return true;
		} else {
			return false;
		}
	}

}
