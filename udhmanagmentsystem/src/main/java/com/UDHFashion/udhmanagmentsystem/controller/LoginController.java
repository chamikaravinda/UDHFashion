package com.UDHFashion.udhmanagmentsystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.UDHFashion.udhmanagmentsystem.model.User;
import com.UDHFashion.udhmanagmentsystem.service.DailyBussinessDAOImpl;
import com.UDHFashion.udhmanagmentsystem.service.UserDAOImpl;

@Controller
public class LoginController {

	@Autowired
	UserDAOImpl userService;

	@Autowired
	DailyBussinessDAOImpl bussinessService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView ShowLoginPage(ModelAndView model) {
		User user = new User();
		model.addObject("user", user);
		model.setViewName("home/login");
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView ShowDashboard(HttpServletRequest request, ModelAndView model,
			@ModelAttribute("user") User user) {
		User validUser = userService.isValidUser(user);

		if (validUser != null) {
			if (bussinessService.settingCreticalPoint()) {
				request.getSession().setAttribute("user", validUser);
				model.setViewName("redirect:/home");
				return model;
			}else{
				model.addObject("error", "Cloud'nt create the data base access");
				model.setViewName("home/login");
				return model;
			}
		} else {
			model.addObject("error", "Invalid User Name or Password");
			model.setViewName("home/login");
			return model;
		}

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String LogOut(HttpServletRequest request) {

		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/login";
	}

}
