package com.UDHFashion.udhmanagmentsystem.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.UDHFashion.udhmanagmentsystem.model.PersonalExpenditures;
import com.UDHFashion.udhmanagmentsystem.model.Shop;
import com.UDHFashion.udhmanagmentsystem.model.ShopExpenditures;
import com.UDHFashion.udhmanagmentsystem.service.IExpendituresDAO;



@Controller
public class ExpendituresController {
	
	@Autowired
	IExpendituresDAO servicePexpnditures;
	

	@Autowired
	IExpendituresDAO serviceSpexpnditures;
		
	
	@RequestMapping(value="/addShopExpenditures",method=RequestMethod.GET)
	public String addShopExpenditures(Model model) {
		
		return "expenditures/addShopExpenditures";
	}
	
	@RequestMapping(value="/addPersonalExpenditures",method=RequestMethod.GET)
	public String addPersonalExpenditures(Model model) {
		
		return "expenditures/addPersonalExpenditures";
	}
	
	
	
	//add Personal Expen
	@RequestMapping(value = "/submitPersonalExpenditures", method = RequestMethod.POST)
	public String submitPersonalExpenditures(@ModelAttribute("PersonalExpenditures") PersonalExpenditures personalExpenditures, ModelMap model) {

		servicePexpnditures.insertPersonalExpenditures(personalExpenditures);
		
		return "redirect:viewPexpenditures";

	}
	
	//View Personal Expenditures
	
		@RequestMapping(value = "/viewPexpenditures", method = RequestMethod.GET)
		public String viewPersonalExpenditures(Model model) {
			
			
			List<PersonalExpenditures> pExpendituresList = servicePexpnditures.getAllPersonalExpenditures();
			
			model.addAttribute("pExpendituresList",pExpendituresList);
			
			return "expenditures/viewPexpenditures";
			
			//Already working properly
		}
		
		
		
		//Delete Personal Expenditures
		
		@RequestMapping(value = "/deletePerExpenditures", method = RequestMethod.POST)
		public String deletePersonalEx(@ModelAttribute("PersonalExpenditures") PersonalExpenditures PerExpenditures, ModelMap model ) {
			
			int id = PerExpenditures.getId();
			
			servicePexpnditures.deletePersonalExpenditures(id);
			
			List<PersonalExpenditures> PrExpenditures = servicePexpnditures.getAllPersonalExpenditures();
			model.addAttribute("PrExpenditures",PrExpenditures);
			
			return "redirect:viewPexpenditures";
		}
	
	
	
	/*--------------------------- Shop Ex --------------------*/
	//Add Shop Exp
	@RequestMapping(value = "/submitShopExpenditures", method = RequestMethod.POST)
	public String submitShopExpenditures(@ModelAttribute("ShopExpenditures") ShopExpenditures SpExpenditures, ModelMap model) {

		serviceSpexpnditures.insertShopExpenditures(SpExpenditures);
		
		return "redirect:viewShopExpenditures";

	}
	//View Shop Exp
	
	@RequestMapping(value = "/viewShopExpenditures", method = RequestMethod.GET)
	public String viewShopExpenditures(Model model) {
		
		
		List<ShopExpenditures> ShExpenditures = serviceSpexpnditures.getAllShopExpenditures();
		model.addAttribute("ShExpenditures",ShExpenditures);
		return "expenditures/viewShopExpenditures";
	}
	
	//delete ShopEx
	
	@RequestMapping(value = "/deleteShopExpenditures", method = RequestMethod.POST)
	public String deleteShop(@ModelAttribute("ShopExpenditures") ShopExpenditures SpExpenditures, ModelMap model ) {
		
		int id = SpExpenditures.getId();
		
		serviceSpexpnditures.deleteShopExpenditures(id);
		
		List<ShopExpenditures> ShExpenditures = serviceSpexpnditures.getAllShopExpenditures();
		model.addAttribute("ShExpenditures",ShExpenditures);
		return "expenditures/viewShopExpenditures";
	}
	
	
	//Update ShopEx
	
	
	
	
	//
	
	
	
	
	
	

	
	
	
	
}
