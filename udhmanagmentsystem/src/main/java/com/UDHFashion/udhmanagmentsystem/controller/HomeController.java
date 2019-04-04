package com.UDHFashion.udhmanagmentsystem.controller;

import java.util.List; 


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class HomeController {

	@GetMapping("/home")
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String ShowDashboardHome(Model model) {

		return "home/dashboard";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String ShowDashboard(Model model) {

		return "home/dashboard";
	}

}
