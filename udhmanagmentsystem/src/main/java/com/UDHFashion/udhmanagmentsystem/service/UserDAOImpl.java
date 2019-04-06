package com.UDHFashion.udhmanagmentsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.UDHFashion.udhmanagmentsystem.model.PayiedSalary;
import com.UDHFashion.udhmanagmentsystem.model.Salary;
import com.UDHFashion.udhmanagmentsystem.model.User;
import com.UDHFashion.udhmanagmentsystem.util.CommonConstants;

@Service
public class UserDAOImpl implements IUserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User isValidUser(User user) {

		try {
			User validUser = (User) jdbcTemplate.queryForObject(CommonConstants.GET_USER_IS_VALID,
					new Object[] { user.getUsername(), user.getPassword() }, new BeanPropertyRowMapper(User.class));
			return validUser;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public boolean AddNewUser(User user) {

		try {
			int update = jdbcTemplate.update(CommonConstants.INSERT_USER, user.getFname(), user.getLname(),
					user.getUsername(), user.getPassword(), user.getRole());

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
	public boolean UpdateUser(User user) {
		int update = jdbcTemplate.update(CommonConstants.UPDATE_USER, user.getFname(), user.getLname(),
				user.getUsername(), user.getPassword(), user.getRole(), user.getId());

		if (update == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean UpdatePassword(User user) {
		int update = jdbcTemplate.update(CommonConstants.UPDATE_USER, user.getFname(), user.getLname(),
				user.getUsername(), user.getNpassword(), user.getRole(), user.getId());

		if (update == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean deleteUSer(int id) {
		
		int update = jdbcTemplate.update(CommonConstants.DELETE_USER, id);

		if (update == 1) {
			return true;

		} else {

			return false;
		}
	}
	
	@Override
	public List<User> getUSers() {

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(CommonConstants.GET_USERS);

		List<User> result = new ArrayList<>();

		for (Map<String, Object> row : rows) {
			User user = new User();

			user.setId((int) row.get("id"));
			user.setFname((String) row.get("fname"));
			user.setLname((String) row.get("lname"));
			user.setUsername((String) row.get("username"));
			user.setPassword((String) row.get("password"));
			user.setRole((String) row.get("role"));
			result.add(user);
		}

		return result;
	}
	
	@Override
	public User getUser(int id) {

		try {
			User validUser = (User) jdbcTemplate.queryForObject(CommonConstants.GET_USER,
					new Object[] {id}, new BeanPropertyRowMapper(User.class));
			return validUser;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}
