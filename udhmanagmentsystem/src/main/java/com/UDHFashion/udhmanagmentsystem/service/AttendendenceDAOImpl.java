package com.UDHFashion.udhmanagmentsystem.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.UDHFashion.udhmanagmentsystem.model.Attendence;
import com.UDHFashion.udhmanagmentsystem.model.AttendenceList;
import com.UDHFashion.udhmanagmentsystem.model.BankAccount;
import com.UDHFashion.udhmanagmentsystem.model.DailyBussiness;
import com.UDHFashion.udhmanagmentsystem.model.Employee;
import com.UDHFashion.udhmanagmentsystem.model.Item;
import com.UDHFashion.udhmanagmentsystem.util.CommonConstants;
import com.mysql.jdbc.Statement;

@Service
public class AttendendenceDAOImpl implements IAttendenceDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public ArrayList<AttendenceList> getAttendenceList(String date) {
		System.out.println("in db models");
		ArrayList<AttendenceList> attendence = new ArrayList<>();
		ArrayList<Employee> employees = new ArrayList<>();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // your template here
		java.util.Date dateStr;
		try {

			dateStr = formatter.parse(date);
			java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());

			// System.out.println(date);

			Attendence todayAttendence = (Attendence) jdbcTemplate.queryForObject(CommonConstants.GET_TODAY_ATTENDENCE,
					new Object[] { dateDB }, new BeanPropertyRowMapper(Attendence.class));

			if (todayAttendence != null) {

				List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonConstants.GET_TODAY_ATTENDENCE_LIST,
						dateDB);

				for (Map<String, Object> row : rows) {
					AttendenceList attend = new AttendenceList();

					attend.setId((int) row.get("id"));
					Date cdate = (Date) row.get("date");
					attend.setDate(cdate.toString());
					attend.setEmpNo((String) row.get("empNo"));
					attend.setAttendence_ID((int) row.get("attendence_ID"));
					attend.setStatus((String) row.get("status"));
					attend.setReason((String) row.get("reason"));
					attendence.add(attend);
				}

				return attendence;

			} else {

				throw new EmptyResultDataAccessException(1);
			}
		} catch (EmptyResultDataAccessException e) {

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonConstants.GET_ALL_EMPLOYEE_DETAILS);
			for (Map<String, Object> row : rows) {
				AttendenceList attend = new AttendenceList();

				attend.setDate(date);
				attend.setEmpNo((String) row.get("empNo"));
				attend.setStatus("PRESENT");
				attend.setReason("");
				attendence.add(attend);
				System.out.println("employee number " + attend.getEmpNo());
			}

			return attendence;

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public long addDailyAttendence(Attendence attendence) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(CommonConstants.INSERT_DAILY_ATTENDENCE,
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, attendence.getDate());
			ps.setInt(2, attendence.getPresent());
			ps.setDouble(3, attendence.getAbsent());
			return ps;

		}, keyHolder);

		return (long) keyHolder.getKey();
	}

	@Override
	public boolean AddEmployeeAttendence(AttendenceList attend) {

		try {
			int update = jdbcTemplate.update(CommonConstants.INSERT_EMP_ATTENDENCE, attend.getDate(), attend.getEmpNo(),
					attend.getAttendence_ID(), attend.getStatus(), attend.getReason());

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
	public boolean UpdateEmployeeAttendence(AttendenceList attend) {
		int update = jdbcTemplate.update(CommonConstants.UPDATE_EMP_ATTENDENCE, attend.getDate(), attend.getEmpNo(),
				attend.getAttendence_ID(), attend.getStatus(), attend.getReason(), attend.getId());

		if (update == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean UpdateDailyAttendence(Attendence attendence) {
		int update = jdbcTemplate.update(CommonConstants.UPDATE_DAILY_ATTENDENCE, attendence.getDate(),
				attendence.getPresent(), attendence.getAbsent(), attendence.getId());

		if (update == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public AttendenceList getEmpDailyAttendence(int id) {
		try {

			AttendenceList attend = (AttendenceList) jdbcTemplate.queryForObject(
					CommonConstants.GET_TODAY_EMP_ATTENDENCE_LIST, new Object[] { id },
					new BeanPropertyRowMapper(AttendenceList.class));

			return attend;

		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<AttendenceList> getAttendenceListByStatus() {
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonConstants.GET_TODAY_ATTENDENCE_LIST_BY_STATUS);

		List<AttendenceList> result = new ArrayList<AttendenceList>();

		for (Map<String, Object> row : rows) {

			AttendenceList attendanceList = new AttendenceList();

			attendanceList.setId((Integer) row.get("id"));

			attendanceList.setEmpNo((String) row.get("empNo"));
			attendanceList.setAttendence_ID((Integer) row.get("attendence_ID"));

			result.add(attendanceList);
		}
		return result;
	}

	public Attendence todayAttendence(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // your template here
		java.util.Date dateStr;
		try {

			dateStr = formatter.parse(date);
			java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
			Attendence todayAttendence = (Attendence) jdbcTemplate.queryForObject(CommonConstants.GET_TODAY_ATTENDENCE,
					new Object[] { dateDB }, new BeanPropertyRowMapper(Attendence.class));
			return todayAttendence;
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

}