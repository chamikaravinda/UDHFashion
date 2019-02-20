package com.UDHFashion.udhmanagmentsystem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class AccountsController {
	
	
	@RequestMapping(value = "/creditBills", method = RequestMethod.GET)
	public String addCreditBill(Model model) {
		
		return "shop/addCreditBills";
	}
	
	@RequestMapping(value = "/cashPayments", method = RequestMethod.GET)
	public String viewCashPayment(Model model) {
		
		return "shop/addCashPayments";
	}
	
	@RequestMapping(value = "/addCheques", method = RequestMethod.GET)
	public String addCheque(Model model) {
		
		return "shop/addCheques";
	}
}
