package com.UDHFashion.udhmanagmentsystem.controller;

import java.util.ArrayList;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.UDHFashion.udhmanagmentsystem.model.Bill;
import com.UDHFashion.udhmanagmentsystem.model.Billitems;
import com.UDHFashion.udhmanagmentsystem.model.Item;
import com.UDHFashion.udhmanagmentsystem.model.TempBill;
import com.UDHFashion.udhmanagmentsystem.model.TempBillitems;
import com.UDHFashion.udhmanagmentsystem.model.User;
import com.UDHFashion.udhmanagmentsystem.service.BillDAO;
import com.UDHFashion.udhmanagmentsystem.service.IBillItemDAO;
import com.UDHFashion.udhmanagmentsystem.service.IItemDAO;
import com.UDHFashion.udhmanagmentsystem.service.PrintNoteItemDAO;
import com.UDHFashion.udhmanagmentsystem.service.TempBillDAO;
import com.UDHFashion.udhmanagmentsystem.service.TempBillitemsDAO;
import com.UDHFashion.udhmanagmentsystem.service.TempReturnBillDAO;
import com.UDHFashion.udhmanagmentsystem.service.TempReturnBillItemDAO;
import com.itextpdf.kernel.log.SystemOutCounter;

@Controller
public class ReturnController {

	@Autowired
	IItemDAO iItem;

	@Autowired
	BillDAO serviceBill;

	@Autowired
	IBillItemDAO serviceBillitem;

	@Autowired
	TempReturnBillDAO serviceInsertReturnBill;

	@Autowired
	TempReturnBillItemDAO serviceInsertReturnBillitem;

	@Autowired
	TempReturnBillItemDAO serviceReturnbillitem;

	@Autowired
	TempReturnBillItemDAO serviceDeleteReturnBillitem;

	@Autowired
	PrintNoteItemDAO servicereturnPrintNoteitem;

	@Autowired
	TempReturnBillDAO tempReturnbill;

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

	@RequestMapping(value = "/billSearch", method = RequestMethod.POST)
	public ModelAndView billSearch(@RequestParam("billId") int billId, ModelAndView model, RedirectAttributes redir) {

		Bill billSearch = new Bill();
		billSearch = serviceBill.getBillById(billId);

		TempBill tempBill = new TempBill();
		tempBill.setId(billSearch.getId());
		tempBill.setDate(billSearch.getDate());
		tempBill.setCashireId(billSearch.getCashireId());
		tempBill.setGrossAmount(billSearch.getGrossAmount());
		tempBill.setNetAmount(billSearch.getNetAmount());
		tempBill.setTotalDiscount(billSearch.getTotalDiscount());
		tempBill.setNoOfItem(billSearch.getNoOfItem());

		long tempId = serviceInsertReturnBill.insertTempReturnBill(tempBill);

		List<Billitems> billSearchitem = new ArrayList<Billitems>();
		billSearchitem = serviceBillitem.getBillitem(billId);

		serviceInsertReturnBillitem.insertTempReturnBillItems(billSearchitem);

		List<TempBillitems> bill_item = serviceInsertReturnBillitem.getTempReturnBillitem(billId);

		TempBill bill = serviceInsertReturnBillitem.getTemBillById((int) tempId);

		redir.addFlashAttribute("bill_item", bill_item);
		redir.addFlashAttribute("billSearch", bill);
		model.setViewName("redirect:/returnNote");
		return model;
	}

	@RequestMapping(value = "/toReturnNote", method = RequestMethod.POST)
	public ModelAndView addToReturnNote(@ModelAttribute("item") TempBillitems returnBillItem, ModelAndView model,
			RedirectAttributes redir) {

		serviceDeleteReturnBillitem.deleteTempReturnBillitem(returnBillItem.getId());

		// insert delete item to the printNote table have to write code

		servicereturnPrintNoteitem.insertPrintNoteItem(returnBillItem);

		System.out.println("Cashire ID :" + returnBillItem.getCashireId());

		List<TempBillitems> return_bill_item = serviceReturnbillitem.getTempReturnBillitem(returnBillItem.getBillId());
		List<Billitems> printNote_item = servicereturnPrintNoteitem.getAllPrintNoteItem();
		TempBill bill = serviceInsertReturnBillitem.getTemBillById(returnBillItem.getBillId());

		redir.addFlashAttribute("bill_item", return_bill_item);
		redir.addFlashAttribute("billSearch", bill);
		redir.addFlashAttribute("printNote_item", printNote_item);
		model.setViewName("redirect:/returnNote");
		return model;

	}

	@RequestMapping(value = "/printNote", method = RequestMethod.POST)
	public ModelAndView printNote(ModelAndView model,HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("user");
		int cashireId = user.getId(); //get the current Cashire ID 

		servicereturnPrintNoteitem.deleteTempReturnBillitem();
		tempReturnbill.deleteTempReturnBill(cashireId);

		model.setViewName("redirect:/returnNote");
		return model;
	}

}