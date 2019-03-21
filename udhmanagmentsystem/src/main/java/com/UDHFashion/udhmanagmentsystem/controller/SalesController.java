package com.UDHFashion.udhmanagmentsystem.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.UDHFashion.udhmanagmentsystem.model.Bill;
import com.UDHFashion.udhmanagmentsystem.model.Billitems;
import com.UDHFashion.udhmanagmentsystem.model.Item;
import com.UDHFashion.udhmanagmentsystem.model.TempBillitems;
import com.UDHFashion.udhmanagmentsystem.model.User;
import com.UDHFashion.udhmanagmentsystem.service.BillDAO;
import com.UDHFashion.udhmanagmentsystem.service.IItemDAO;
import com.UDHFashion.udhmanagmentsystem.service.TempBillDAO;
import com.UDHFashion.udhmanagmentsystem.service.TempBillitemsDAO;

@Controller
public class SalesController {

	@Autowired
	TempBillDAO serviceTempBill;

	@Autowired
	TempBillitemsDAO serviceTempBillitems;

	@Autowired
	IItemDAO serviceItem;
	
	@Autowired
	
	BillDAO serviceBill;
	
	
	
	
	@RequestMapping(value="/viewAllSales", method=RequestMethod.GET)
	public ModelAndView viewAllSales(ModelAndView model) {
		
		List<Bill> getallBill= serviceBill.getAllBill();
		
		model.addObject("getallBill", getallBill);
		model.setViewName("sales/viewAllSales");
		return model;
		
	}

	@RequestMapping(value = "/finalizeBill", method = RequestMethod.POST)
	public ModelAndView finalizeBill(@ModelAttribute("permanentBill") Bill bill,@ModelAttribute("permanentBillitem") Billitems billitem,  ModelAndView model) {

		System.out.println("Bill Total Amount : "+bill.getNetAmount());
		System.out.println("CashireID : "+bill.getCashireId());
		System.out.println("item No : "+billitem.getItemNo());
		
		
	
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String newDate = dateFormat.format(date);
		
		bill.setDate(newDate);
		
		serviceBill.insertBill(bill);
		
		
		
		model.setViewName("redirect:/viewAllSales");
		return model;
	}

	@RequestMapping(value = "/newSales", method = RequestMethod.GET)
	public String newSales(HttpServletRequest request, Model model) {

		User user = (User) request.getSession().getAttribute("user");
		int cashireId = user.getId();

		serviceTempBill.deleteTempBill(cashireId);
		serviceTempBillitems.deleteTempBillitems(cashireId);

		return "sales/viewSales";

	}

	@RequestMapping(value = "/viewSales", method = RequestMethod.GET)
	public ModelAndView viewSales(HttpServletRequest request, ModelAndView model) {

		User user = (User) request.getSession().getAttribute("user");
		int cashireId = user.getId();

		List<TempBillitems> itemList1 = serviceTempBillitems.getAllTempBillitems(cashireId);

		model.addObject("itemList1", itemList1);
		model.setViewName("sales/viewSales");
		return model;

	}

	@RequestMapping(value = "/submitItemQty", method = RequestMethod.POST)
	public ModelAndView submitItemQty(@RequestParam("itemcode") String itemcode, @RequestParam("quantity") int quantity,
			ModelAndView model, HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("user");
		int cashireId = user.getId();

		TempBillitems tempBillitems = new TempBillitems();
		Item itemList = serviceItem.getItemById(itemcode);

		tempBillitems.setItemNo(itemList.getItemCode());
		tempBillitems.setPrice(itemList.getPrice());
		tempBillitems.setQty(quantity);
		tempBillitems.setBillId(itemList.getItemCode());
		tempBillitems.setReduseDiscount(itemList.getDiscount());
		tempBillitems.setAmount(tempBillitems.getPrice() * quantity - tempBillitems.getReduseDiscount() * quantity);
		tempBillitems.setCashireId(cashireId);

		// System.out.println("User ID is : "+tempBillitems.getCashireId());
		serviceTempBillitems.insertTempBillitems(tempBillitems);

		model.setViewName("redirect:/viewSales");
		return model;

	}

}
