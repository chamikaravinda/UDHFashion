package com.UDHFashion.udhmanagmentsystem.controller;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
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
import com.UDHFashion.udhmanagmentsystem.service.AttendendenceDAOImpl;
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
	AttendendenceDAOImpl serviceAttendence;

	@Autowired

	IAttendenceDAO serviceGetCrrentEmp;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String ShowDashboard(Model model) {

		return "redirect:/home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String DashbordDetails(Model model) {
		NumberFormat formatter = new DecimalFormat("#0.00");

		List<DailyBussiness> getDailyBusiness = serviceDailyBusiness.getDailyBusiness();
		model.addAttribute("getDailyBusiness", getDailyBusiness);

		DailyBussiness today = serviceDailyBusiness.getEntry(getCurrentDate());
		if (today != null) {
			model.addAttribute("todaysProfite", formatter.format(today.getNetProfite()));
		} else {
			model.addAttribute("todaysProfite", 0.00);
		}

		List<Item> items = serviceGetAllitem.getAllItemDetails();

		if (items != null) {
			int num = items.size();
			model.addAttribute("num", num);
		} else {
			model.addAttribute("num", 0);
		}
		List<Shop> suppliers = serviceAllSuppliers.getAllShopsDetails();

		if (suppliers != null) {
			int allSuppliers = suppliers.size();
			model.addAttribute("allSuppliers", allSuppliers);
		} else {
			model.addAttribute("allSuppliers", 0);
		}

		Attendence attendence = serviceAttendence.todayAttendence(getCurrentDate());
		if (attendence != null) {
			int currentSize = attendence.getPresent();

			model.addAttribute("currentSize", currentSize);
		} else {
			model.addAttribute("currentSize", 0);

		}
		return "home/dashboard";
	}

	private String getCurrentDate() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String newDate = dateFormat.format(date);

		return newDate;

	}
}