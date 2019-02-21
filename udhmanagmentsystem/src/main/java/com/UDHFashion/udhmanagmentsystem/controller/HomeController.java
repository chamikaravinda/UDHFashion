package com.UDHFashion.udhmanagmentsystem.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.UDHFashion.udhmanagmentsystem.model.Barcode;
import com.UDHFashion.udhmanagmentsystem.model.Item;
import com.UDHFashion.udhmanagmentsystem.model.Shop;
import com.UDHFashion.udhmanagmentsystem.service.IBarcodeDAO;
import com.UDHFashion.udhmanagmentsystem.service.IItemDAO;
import com.UDHFashion.udhmanagmentsystem.service.IShopDAO;
import com.UDHFashion.udhmanagmentsystem.service.ShopDAOImpl;
import com.UDHFashion.udhmanagmentsystem.util.Generator;

@Controller
public class HomeController {

	@Autowired
	IShopDAO iShop;
	
	@Autowired
	IItemDAO iItem;
	
	@Autowired
	IBarcodeDAO iBarcode;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String ShowLoginPage(ModelAndView model) {

		return "home/login";
	}
	
	

	@GetMapping("/home")
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String ShowDashboard(Model model) {

		return "home/dashboard";
	}

}
