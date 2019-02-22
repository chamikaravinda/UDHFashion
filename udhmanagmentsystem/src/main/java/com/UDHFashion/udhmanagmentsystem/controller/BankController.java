package com.UDHFashion.udhmanagmentsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.UDHFashion.udhmanagmentsystem.model.BankAccount;
import com.UDHFashion.udhmanagmentsystem.service.BankAccountsDAOImpl;

@Controller
public class BankController {

	@Autowired
	BankAccountsDAOImpl serviceBank;
	
	@RequestMapping(value="/allAccounts",method = RequestMethod.GET)
	public ModelAndView showAllAccounts(ModelAndView model) {

		List<BankAccount> accounts =serviceBank.GetAllAccounts();

		model.addObject("accounts",accounts);
		model.setViewName("banks/allAccounts");
		return model;
		
	}
	
	@RequestMapping(value="/addBanks",method = RequestMethod.GET)
	public ModelAndView ShowAddBanks(ModelAndView model) {
		
		BankAccount account =new BankAccount();
		model.addObject("bankAccount",account);
		model.setViewName("banks/addBanks");
		return model;
	}

	@RequestMapping(value="/addBanks", method = RequestMethod.POST)
	public ModelAndView AddBanks(ModelAndView model,@ModelAttribute("bankAccount") BankAccount account,RedirectAttributes redir) {
		
		if(serviceBank.AddBanKAccounts(account)) {
			redir.addFlashAttribute("success",1);
			model.setViewName("redirect:/allAccounts");
			return model;
		}else {
			model.addObject("error","Account adding unsuccesfully");
			model.setViewName("redirect:/addBanks");
			return model;
		}
		
	}
	
	@RequestMapping(value="/editBanks",method = RequestMethod.GET)
	public ModelAndView ShowEditBanks(ModelAndView model,@RequestParam("id") int id) {
		
		BankAccount	account =serviceBank.GetBankAccount(id);
		model.addObject("bankAccount",account);
		model.setViewName("banks/editBanks");
		return model;
	}
	
	@RequestMapping(value="/editBanks",method = RequestMethod.POST)
	public ModelAndView ShowEditBanks(ModelAndView model,@ModelAttribute("bankAccount") BankAccount account,RedirectAttributes redir) {
		
		if(serviceBank.UpdateAccounts(account)) {
			redir.addFlashAttribute("success",2);
			model.setViewName("redirect:/allAccounts");
			return model;
		}else {
			model.addObject("error","Account adding unsuccesfully");
			model.setViewName("redirect:/addBanks");
			return model;
		}
	}
}
