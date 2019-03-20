package com.UDHFashion.udhmanagmentsystem.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

					String date = entry.getDate();
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // your template here
					java.util.Date dateStr;
					try {

						dateStr = formatter.parse(date);
						java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());

						DailyBussiness todayEntry = (DailyBussiness) jdbcTemplate.queryForObject(
								CommonConstants.GET_TODAY_ENTRY, new Object[] { dateDB },
								new BeanPropertyRowMapper(DailyBussiness.class));

						if (todayEntry == null) {
							throw new EmptyResultDataAccessException(1);

						} else {

							todayEntry.setBussinesAmount(entry.getBussinesAmount() + todayEntry.getBussinesAmount());
							todayEntry.setExpenseAmount(todayEntry.getExpenseAmount() + entry.getExpenseAmount());
							todayEntry.setNetProfite(todayEntry.getNetProfite() + entry.getNetProfite());
							todayEntry.setReturnAmount(todayEntry.getReturnAmount() + entry.getReturnAmount());

							int update = jdbcTemplate.update(CommonConstants.UPDATE_TODAT_ENTRY,
									todayEntry.getExpenseAmount(), todayEntry.getBussinesAmount(),
									todayEntry.getReturnAmount(), todayEntry.getNetProfite(), todayEntry.getDate());

							CriticalSectionRemoveFlag();

							if (update == 1) {
								return true;
							} else {
								return false;
							}

						}
					} catch (EmptyResultDataAccessException e) {
						
						if (insertDailyBussinessEntry(entry)) {
							CriticalSectionRemoveFlag();
							return true;
						}else {
							CriticalSectionRemoveFlag();
							return false;
						}
						
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
	}

	@Override
	public DailyBussiness getEntry(String date) {
		DailyBussiness todayEntry = (DailyBussiness) jdbcTemplate.queryForObject(CommonConstants.GET_TODAY_ENTRY,
				new Object[] { date }, new BeanPropertyRowMapper(DailyBussiness.class));

		return todayEntry;
	}

	@Override
	public boolean settingCreticalPoint() {

		try {

			DailyBussiness creticalSection = (DailyBussiness) jdbcTemplate.queryForObject(
					CommonConstants.GET_CRITICAL_SECTION, new BeanPropertyRowMapper(DailyBussiness.class));

			if (creticalSection == null) {

				throw new EmptyResultDataAccessException(1);

			} else {
				return true;
			}

		} catch (EmptyResultDataAccessException e) {

			String date = "2000-01-01";
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // your template here
			java.util.Date dateStr;
			try {

				dateStr = formatter.parse(date);

				java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());

				int insert = jdbcTemplate.update(CommonConstants.INSERT_CRITICAL_SECTION, 1, dateDB, 0, 0, 0, 0, true);

				if (insert == 1) {
					return true;
				} else {
					return false;
				}

			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return false;
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
	public boolean deleteExpence(double amount, String date) {

		while (true) {

			DailyBussiness creticalSection = (DailyBussiness) jdbcTemplate.queryForObject(
					CommonConstants.GET_CRITICAL_SECTION, new BeanPropertyRowMapper(DailyBussiness.class));

			if (creticalSection.isFlag()) {
				if (CriticalSectionFlag()) {

					DailyBussiness todayEntry = (DailyBussiness) jdbcTemplate.queryForObject(
							CommonConstants.GET_TODAY_ENTRY, new Object[] { date },
							new BeanPropertyRowMapper(DailyBussiness.class));

					if (todayEntry != null) {

						todayEntry.setExpenseAmount(todayEntry.getExpenseAmount() - amount);
						int update = jdbcTemplate.update(CommonConstants.UPDATE_TODAT_ENTRY,
								todayEntry.getExpenseAmount(), todayEntry.getBussinesAmount(),
								todayEntry.getReturnAmount(), todayEntry.getNetProfite(), todayEntry.getDate());

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
