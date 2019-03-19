package com.UDHFashion.udhmanagmentsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.UDHFashion.udhmanagmentsystem.model.DailyBussiness;
import com.UDHFashion.udhmanagmentsystem.util.CommonConstants;

@Service
public class DailyBussinessDAOImpl implements IDailyBussinessDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean insertDailyBussinessEntry(DailyBussiness entry) {
		int insert = jdbcTemplate.update(CommonConstants.INSERT_DAILY_BUSINESS, entry.getDate(),
				entry.getExpenseAmount(), entry.getBussinesAmount(), entry.getReturnAmount(), entry.getNetProfite(),
				entry.isFlag());

		if (insert == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateDailyEntry(DailyBussiness entry) {

		while (true) {
			DailyBussiness creticalSection = (DailyBussiness) jdbcTemplate.queryForObject(
					CommonConstants.GET_CRITICAL_SECTION, new BeanPropertyRowMapper(DailyBussiness.class));

			if (creticalSection.isFlag()) {
				if (CriticalSectionFlag()) {

					DailyBussiness todayEntry = (DailyBussiness) jdbcTemplate.queryForObject(
							CommonConstants.GET_TODAY_ENTRY, new Object[] { entry.getDate() },
							new BeanPropertyRowMapper(DailyBussiness.class));

					if (todayEntry == null) {

						insertDailyBussinessEntry(entry);
						CriticalSectionRemoveFlag();
						return true;

					} else {

						todayEntry.setBussinesAmount(entry.getBussinesAmount() + todayEntry.getBussinesAmount());
						todayEntry.setExpenseAmount(todayEntry.getExpenseAmount() + entry.getExpenseAmount());
						todayEntry.setNetProfite(todayEntry.getNetProfite() + entry.getNetProfite());
						todayEntry.setReturnAmount(todayEntry.getReturnAmount() + entry.getReturnAmount());

						int update = jdbcTemplate.update(CommonConstants.UPDATE_TODAT_ENTRY,
								todayEntry.getExpenseAmount(), todayEntry.getBussinesAmount(),
								todayEntry.getReturnAmount(), todayEntry.getNetProfite(),todayEntry.getDate());
						
						CriticalSectionRemoveFlag();
						
						if (update == 1) {
							return true;
						} else {
							return false;
						}

					}
				}
			}

		}
	}

	@Override
	public DailyBussiness getEntry(String date) {
		DailyBussiness todayEntry = (DailyBussiness) jdbcTemplate.queryForObject(
				CommonConstants.GET_TODAY_ENTRY, new Object[] { date},
				new BeanPropertyRowMapper(DailyBussiness.class));
		
		return todayEntry;
	}

	@Override
	public boolean settingCreticalPoint() {

		try {

			DailyBussiness creticalSection = (DailyBussiness) jdbcTemplate.queryForObject(
					CommonConstants.GET_CRITICAL_SECTION, new BeanPropertyRowMapper(DailyBussiness.class));

			if (creticalSection == null) {

				int insert = jdbcTemplate.update(CommonConstants.INSERT_CRITICAL_SECTION, 1, 2000 / 01 / 01, 0, 0, 0, 0,
						true);

				if (insert == 1) {
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	private boolean CriticalSectionFlag() {
		while (true) {
			DailyBussiness creticalSection = (DailyBussiness) jdbcTemplate.queryForObject(
					CommonConstants.GET_CRITICAL_SECTION, new BeanPropertyRowMapper(DailyBussiness.class));
			if (creticalSection.isFlag()) {
				int update = jdbcTemplate.update(CommonConstants.UPDATE_CRITICAL_SECTION, false);

				if (update == 1) {
					return true;
				} else {
					return false;
				}
			}
		}
	}

	private boolean CriticalSectionRemoveFlag() {
		while (true) {
			DailyBussiness creticalSection = (DailyBussiness) jdbcTemplate.queryForObject(
					CommonConstants.GET_CRITICAL_SECTION, new BeanPropertyRowMapper(DailyBussiness.class));
			if (!creticalSection.isFlag()) {
				int update = jdbcTemplate.update(CommonConstants.UPDATE_CRITICAL_SECTION, true);

				if (update == 1) {
					return true;
				} else {
					return false;
				}
			}
		}
	}
	
	
	@Override
	public boolean deleteExpence(double amount,String date) {

		while (true) {
			DailyBussiness creticalSection = (DailyBussiness) jdbcTemplate.queryForObject(
					CommonConstants.GET_CRITICAL_SECTION, new BeanPropertyRowMapper(DailyBussiness.class));

			if (creticalSection.isFlag()) {
				if (CriticalSectionFlag()) {

					DailyBussiness todayEntry = (DailyBussiness) jdbcTemplate.queryForObject(
							CommonConstants.GET_TODAY_ENTRY, new Object[] { date},
							new BeanPropertyRowMapper(DailyBussiness.class));

					if (todayEntry != null) {
						todayEntry.setExpenseAmount(todayEntry.getExpenseAmount() - amount);
						int update = jdbcTemplate.update(CommonConstants.UPDATE_TODAT_ENTRY,
								todayEntry.getExpenseAmount(), todayEntry.getBussinesAmount(),
								todayEntry.getReturnAmount(), todayEntry.getNetProfite(),todayEntry.getDate());
						
						CriticalSectionRemoveFlag();
						
						if (update == 1) {
							return true;
						} else {
							return false;
						}

					}
				}
			}

		}
	}
	
}
