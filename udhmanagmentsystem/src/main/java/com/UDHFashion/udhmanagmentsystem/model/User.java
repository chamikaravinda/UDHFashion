package com.UDHFashion.udhmanagmentsystem.model;

public class User {

	private int id;
	private String fname;
	private String lname;
	private String username;
	private String password;
	private String role;
	private String cpassword;
	private String npassword;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	public String getNpassword() {
		return npassword;
	}

	public void setNpassword(String npassword) {
		this.npassword = npassword;
	}

	
}
