package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;

import com.UDHFashion.udhmanagmentsystem.model.User;

public interface IUserDAO {

	public User isValidUser(User user);

	boolean AddNewUser(User user);

	boolean UpdateUser(User user);

	boolean deleteUSer(int id);

	List<User> getUSers();

	User getUser(int id);

	boolean UpdatePassword(User user);
}
