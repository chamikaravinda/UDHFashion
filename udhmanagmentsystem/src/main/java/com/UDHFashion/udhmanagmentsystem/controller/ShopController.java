package com.UDHFashion.udhmanagmentsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShopController {
	
	@RequestMapping(value="/addShopExpenditures",method=RequestMethod.GET)
	public String addShopExpenditures(Model model) {
		
		return "expenditures/addShopExpenditures";
	}
	@RequestMapping(value="/addPersonalExpenditures",method=RequestMethod.GET)
	public String addPersonalExpenditures(Model model) {
		
		return "expenditures/addPersonalExpenditures";
	}

}
