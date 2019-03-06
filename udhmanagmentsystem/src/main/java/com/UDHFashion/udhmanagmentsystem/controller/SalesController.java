package com.UDHFashion.udhmanagmentsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SalesController {

	
	
	
	@RequestMapping(value="/viewSales",method=RequestMethod.GET)
	public String viewSales(Model model) {
		
		
		
		return "sales/viewSales";
		
		
		
	}
}
