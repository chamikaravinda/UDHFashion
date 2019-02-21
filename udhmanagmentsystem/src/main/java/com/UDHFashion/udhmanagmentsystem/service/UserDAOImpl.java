package com.UDHFashion.udhmanagmentsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.UDHFashion.udhmanagmentsystem.model.User;
import com.UDHFashion.udhmanagmentsystem.util.CommonConstants;

@Service
public class UserDAOImpl implements IUserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public User isValidUser(User user) {
	
		try {
				User validUser = (User)jdbcTemplate.queryForObject(CommonConstants.GET_USER_IS_VALID,
						new Object	[] {user.getUsername(),user.getPassword()},new BeanPropertyRowMapper(User.class));
				return validUser;
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

}
