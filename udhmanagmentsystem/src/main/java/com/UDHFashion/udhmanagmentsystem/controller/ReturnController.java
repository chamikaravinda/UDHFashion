package com.UDHFashion.udhmanagmentsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.UDHFashion.udhmanagmentsystem.model.Bill;
import com.UDHFashion.udhmanagmentsystem.model.Billitems;
import com.UDHFashion.udhmanagmentsystem.model.Item;
import com.UDHFashion.udhmanagmentsystem.service.BillDAO;
import com.UDHFashion.udhmanagmentsystem.service.IBillItemDAO;
import com.UDHFashion.udhmanagmentsystem.service.IItemDAO;


@Controller
public class ReturnController {
	

	@Autowired
	IItemDAO iItem;
	
	@Autowired
	BillDAO serviceBill;
	
	@Autowired
	IBillItemDAO serviceBillitem;
	
	

	@RequestMapping(value = "/returnNote", method = RequestMethod.GET)
	public String returnNote(Model model) {

		
		return "stock/returnNote";
	}

	@RequestMapping(value = "/return", method = RequestMethod.GET)
	public String returnItemView(Model model) {

		List<Item> item = iItem.getAllItemDetails();
		model.addAttribute("itemList", item);

		return "stock/returnItem";
	}
	
	
	@RequestMapping(value="/billSearch", method= RequestMethod.POST)
	public ModelAndView billSearch(@RequestParam("billId") int  billId,ModelAndView model) {
		
		
		
		Bill billSearch=new Bill();
		
		billSearch=serviceBill.getBillById(billId);
		
		System.out.println(billId);
		System.out.println(billSearch.getGrossAmount());
		System.out.println(billSearch.getNetAmount());
		System.out.println(billSearch.getDate());
		System.out.println(billSearch.getCashireId());
		System.out.println(billSearch.getTotalDiscount());
		System.out.println("End One item details");
		
		List<Billitems> bill_item =serviceBillitem.getBillitem(billId);
		                  
		
		
		for (Billitems billitems : bill_item) {
			System.out.println("Under for each");
			System.out.println(billitems.getAmount() + billitems.getItemNo());
			
			//this loop for testing nothing else
			
		}
		
		
		model.addObject("bill_item", bill_item);
		model.addObject("billSearch",billSearch);
		model.setViewName("stock/returnNote");
		return model;
	}

}
