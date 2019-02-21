package com.UDHFashion.udhmanagmentsystem.controller;

import javax.servlet.http.HttpServletRequest; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.UDHFashion.udhmanagmentsystem.model.User;
import com.UDHFashion.udhmanagmentsystem.service.UserDAOImpl;

@Controller
public class LoginController {
	
	@Autowired
	UserDAOImpl userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView ShowLoginPage(ModelAndView model) {
		User user =new User();
		model.addObject("user",user);
		model.setViewName("home/login");
		return model;
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String showDashboard(HttpServletRequest request , @ModelAttribute("user") User user) {
		User validUser=userService.isValidUser(user);
		
		if(validUser != null) {			
			request.getSession().setAttribute("user",validUser);		
			return "home/dashboard";
		}else {
			return "home/login";	
		}
		
	}
	
	
	
	
}
