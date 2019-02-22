package com.UDHFashion.udhmanagmentsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.UDHFashion.udhmanagmentsystem.model.Shop;
import com.UDHFashion.udhmanagmentsystem.service.IShopDAO;

@Controller
public class ShopController {
	
	@Autowired
	IShopDAO iShop;
	
	@RequestMapping(value="/addShopExpenditures",method=RequestMethod.GET)
	public String addShopExpenditures(Model model) {
		
		return "expenditures/addShopExpenditures";
	}
	@RequestMapping(value="/addPersonalExpenditures",method=RequestMethod.GET)
	public String addPersonalExpenditures(Model model) {
		
		return "expenditures/addPersonalExpenditures";
	}

	
	@RequestMapping(value = "/addShop", method = RequestMethod.GET)
	public String addWholeSaleShop(ModelAndView model) {

		return "shop/addShop";
	}
	
	/*----------------------------- Delete Shop Data -------------------------*/
	@RequestMapping(value = "/deleteShop", method = RequestMethod.POST)
	public String deleteShop(@ModelAttribute("shop") Shop shop, ModelMap model ) {
		
		int shopId = shop.getShopId();
		
		iShop.deleteShop(shopId);
		
		List<Shop> shopList = iShop.getAllShopsDetails();
		model.addAttribute("shopList",shopList);
		return "shop/viewShop";
	}
	
	/*------------------Getting the values of the shop from the Form --------------------------*/
	@RequestMapping(value = "/submitShop", method = RequestMethod.POST)
	public String submitShopDetails(@ModelAttribute("shop") Shop shop, ModelMap model) {

		iShop.insertShopDetails(shop);
		
		List<Shop> shopList = iShop.getAllShopsDetails();
		model.addAttribute("shopList",shopList);
		return "shop/viewShop";
	}
	
	@RequestMapping(value = "/viewShop", method = RequestMethod.GET)
	public String viewShop(Model model) {
		List<Shop> shop = iShop.getAllShopsDetails();
			
		model.addAttribute("shopList",shop);
		
		return "shop/viewShop";
	}
}
