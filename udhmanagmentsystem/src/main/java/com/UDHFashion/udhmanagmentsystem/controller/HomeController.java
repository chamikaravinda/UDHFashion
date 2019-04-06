package com.UDHFashion.udhmanagmentsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.UDHFashion.udhmanagmentsystem.model.DailyBussiness;
import com.UDHFashion.udhmanagmentsystem.service.IDailyBussinessDAO;

@Controller
@SessionAttributes("user")
public class HomeController {

	@Autowired

	IDailyBussinessDAO serviceDailyBusiness;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String ShowDashboard(Model model) {

		return "redirect:/home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String DashbordDetails(Model model) {

		List<DailyBussiness> getDailyBusiness = serviceDailyBusiness.getDailyBusiness();

		model.addAttribute("getDailyBusiness", getDailyBusiness);

		return "home/dashboard";
	}

}