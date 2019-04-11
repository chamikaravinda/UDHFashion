package com.UDHFashion.udhmanagmentsystem.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.UDHFashion.udhmanagmentsystem.model.Attendence;
import com.UDHFashion.udhmanagmentsystem.model.AttendenceList;
import com.UDHFashion.udhmanagmentsystem.model.DailyBussiness;
import com.UDHFashion.udhmanagmentsystem.model.Item;
import com.UDHFashion.udhmanagmentsystem.model.Shop;
import com.UDHFashion.udhmanagmentsystem.service.IAttendenceDAO;
import com.UDHFashion.udhmanagmentsystem.service.IDailyBussinessDAO;
import com.UDHFashion.udhmanagmentsystem.service.IItemDAO;
import com.UDHFashion.udhmanagmentsystem.service.IShopDAO;

@Controller
@SessionAttributes("user")
public class HomeController {

	@Autowired

	IDailyBussinessDAO serviceDailyBusiness;
	
	@Autowired
	
	IItemDAO serviceGetAllitem;
	
	@Autowired
	IShopDAO serviceAllSuppliers;
	
	@Autowired
	
	IAttendenceDAO serviceGetCrrentEmp;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String ShowDashboard(Model model) {

		return "redirect:/home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String DashbordDetails(Model model) {

		List<DailyBussiness> getDailyBusiness = serviceDailyBusiness.getDailyBusiness();
		model.addAttribute("getDailyBusiness", getDailyBusiness);

		double total_profit = 0;
		for (DailyBussiness dailyBussiness : getDailyBusiness) {

			total_profit += dailyBussiness.getNetProfite();
		}
		model.addAttribute("total_profit",total_profit);
		
		List<Item> items = serviceGetAllitem.getAllItemDetails();
		int num= items.size();
		model.addAttribute("num",num);
		
		List<Shop> suppliers=serviceAllSuppliers.getAllShopsDetails();
		int allSuppliers= suppliers.size();
		
		model.addAttribute("allSuppliers",allSuppliers);
		
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = new Date();
//		String newDate = dateFormat.format(date);

		
		List<AttendenceList> current_emp=serviceGetCrrentEmp.getAttendenceListByStatus();
		int currentSize=current_emp.size();

		model.addAttribute("currentSize",currentSize);
		return "home/dashboard";
	}

}