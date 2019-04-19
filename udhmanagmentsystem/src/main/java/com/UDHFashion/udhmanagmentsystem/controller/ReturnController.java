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
import com.UDHFashion.udhmanagmentsystem.model.DailyBussiness;
import com.UDHFashion.udhmanagmentsystem.model.Item;
import com.UDHFashion.udhmanagmentsystem.model.TempBill;
import com.UDHFashion.udhmanagmentsystem.model.TempBillitems;
import com.UDHFashion.udhmanagmentsystem.model.User;
import com.UDHFashion.udhmanagmentsystem.service.BillDAO;
import com.UDHFashion.udhmanagmentsystem.service.DailyBussinessDAOImpl;
import com.UDHFashion.udhmanagmentsystem.service.IBillItemDAO;
import com.UDHFashion.udhmanagmentsystem.service.IItemDAO;
import com.UDHFashion.udhmanagmentsystem.service.ItemDAOImpl;
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
	TempReturnBillDAO serviceReturnBill;

	@Autowired
	TempReturnBillItemDAO serviceReturnBillitem;

	@Autowired
	PrintNoteItemDAO servicereturnPrintNoteitem;

	@Autowired
	TempReturnBillDAO tempReturnbill;

	@Autowired
	ItemDAOImpl itemService;

	@Autowired
	DailyBussinessDAOImpl serviceDailyBussines;

	// show return page
	@RequestMapping(value = "/returnNote", method = RequestMethod.GET)
	public String returnNote(Model model) {

		return "stock/returnNote";
	}

	// search bill
	@RequestMapping(value = "/billSearch", method = RequestMethod.POST)
	public ModelAndView billSearch(@RequestParam("billId") int billId, ModelAndView model, RedirectAttributes redir,
			HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("user");
		int cashireId = user.getId();

		if (serviceReturnBill.deleteTempReturnBill(cashireId)) {
			if (serviceReturnBillitem.deleteTempReturnBillitems(cashireId)) {
				if (servicereturnPrintNoteitem.deleteTempReturnBillitem(cashireId)) {

					Bill billSearch = new Bill();
					billSearch = serviceBill.getBillById(billId);
					if (billSearch != null) {

						TempBill tempBill = new TempBill();
						tempBill.setId(billSearch.getId());
						tempBill.setDate(billSearch.getDate());
						tempBill.setCashireId(billSearch.getCashireId());
						tempBill.setGrossAmount(billSearch.getGrossAmount());
						tempBill.setNetAmount(billSearch.getNetAmount());
						tempBill.setTotalDiscount(billSearch.getTotalDiscount());
						tempBill.setNoOfItem(billSearch.getNoOfItem());

						long tempId = serviceReturnBill.insertTempReturnBill(tempBill);

						List<Billitems> billSearchitem = new ArrayList<Billitems>();
						billSearchitem = serviceBillitem.getBillitem(billId);

						serviceReturnBillitem.insertTempReturnBillItems(billSearchitem, cashireId);

						List<TempBillitems> bill_item = serviceReturnBillitem.getTempReturnBillitem(billId);

						TempBill bill = serviceReturnBillitem.getTemBillById((int) tempId);

						redir.addFlashAttribute("bill_item", bill_item);
						redir.addFlashAttribute("billSearch", bill);
						model.setViewName("redirect:/returnNote");
						return model;
					} else {
						redir.addFlashAttribute("error", 2);
						model.setViewName("redirect:/returnNote");
						return model;
					}

				} else {
					redir.addFlashAttribute("error", 1);
					model.setViewName("redirect:/returnNote");
					return model;
				}
			} else {
				redir.addFlashAttribute("error", 1);
				model.setViewName("redirect:/returnNote");
				return model;
			}
		} else {
			redir.addFlashAttribute("error", 1);
			model.setViewName("redirect:/returnNote");
			return model;
		}
	}

	// add item to return note
	@RequestMapping(value = "/toReturnNote", method = RequestMethod.POST)
	public ModelAndView addToReturnNote(@ModelAttribute("item") TempBillitems returnBillItem, ModelAndView model,
			RedirectAttributes redir, HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("user");
		int cashireId = user.getId();

		serviceReturnBillitem.deleteTempReturnBillitem(returnBillItem.getId());

		servicereturnPrintNoteitem.insertPrintNoteItem(returnBillItem, cashireId);

		System.out.println("Cashire ID :" + returnBillItem.getCashireId());

		List<TempBillitems> return_bill_item = serviceReturnBillitem.getTempReturnBillitem(returnBillItem.getBillId());
		List<Billitems> printNote_item = servicereturnPrintNoteitem.getAllPrintNoteItem(cashireId);
		TempBill bill = serviceReturnBillitem.getTemBillById(returnBillItem.getBillId());

		// update Tempory bill

		bill.setGrossAmount(bill.getGrossAmount() - (returnBillItem.getPrice() * returnBillItem.getQty()));
		bill.setNetAmount(bill.getNetAmount() - (returnBillItem.getAmount()));
		bill.setTotalDiscount(bill.getTotalDiscount() - returnBillItem.getReduseDiscount());
		bill.setNoOfItem(bill.getNoOfItem() - returnBillItem.getQty());
		bill.setBalance(bill.getBalance() + bill.getNetAmount());

		serviceReturnBill.updateBillDetails(bill);

		redir.addFlashAttribute("bill_item", return_bill_item);
		redir.addFlashAttribute("billSearch", bill);
		redir.addFlashAttribute("printNote_item", printNote_item);
		model.setViewName("redirect:/returnNote");
		return model;

	}

	// add return items to stock
	@RequestMapping(value = "/return", method = RequestMethod.GET)
	public String returnItemView(Model model) {

		List<Item> item = iItem.getAllItemDetails();
		model.addAttribute("itemList", item);

		return "stock/returnItem";
	}

	@RequestMapping(value = "/printNotete", method = RequestMethod.GET)
	public ModelAndView printNote(@RequestParam("id") int billID, ModelAndView model, HttpServletRequest request,
			RedirectAttributes redir) {

		User user = (User) request.getSession().getAttribute("user");
		int cashireId = user.getId();

		// update origina bill
		TempBill bill = serviceReturnBillitem.getTemBillById(billID);

		Bill updatingBill = serviceBill.getBillById(bill.getId());

		updatingBill.setBalance(bill.getBalance());
		updatingBill.setDate(bill.getDate());
		updatingBill.setCashireId(bill.getCashireId());
		updatingBill.setGrossAmount(bill.getGrossAmount());
		updatingBill.setNetAmount(bill.getNetAmount());
		updatingBill.setTotalDiscount(bill.getTotalDiscount());
		updatingBill.setBalance(bill.getBalance());
		updatingBill.setNoOfItem(bill.getNoOfItem());
		updatingBill.setId(bill.getId());

		if (serviceBill.updateBill(updatingBill)) {
			// update original bill items

			List<Billitems> printNote_item = servicereturnPrintNoteitem.getAllPrintNoteItem(cashireId);

			double bussinessAmount = 0;
			double netProfite = 0;

			for (Billitems item : printNote_item) {
				serviceBillitem.deleteBillitem(item.getId());
				Item originalitem = itemService.getItemById(item.getItemNo());
				netProfite = netProfite+(originalitem.getNetProfit() * item.getQty());
				bussinessAmount=bussinessAmount+ item.getAmount();
			}

			// update daily profite
			DailyBussiness dailyBussiness = new DailyBussiness();
			dailyBussiness.setDate(bill.getDate());
			dailyBussiness.setBussinesAmount(-(bussinessAmount));
			dailyBussiness.setExpenseAmount(0);
			dailyBussiness.setNetProfite(-netProfite);
			dailyBussiness.setReturnAmount(bussinessAmount);

			if (serviceDailyBussines.updateDailyEntry(dailyBussiness)) {
				if (serviceReturnBill.deleteTempReturnBill(cashireId)) {
					if (serviceReturnBillitem.deleteTempReturnBillitems(cashireId)) {
						List<Billitems> returningItems = servicereturnPrintNoteitem.getAllPrintNoteItem(cashireId);
						if (servicereturnPrintNoteitem.deleteTempReturnBillitem(cashireId)) {
							model.addObject("items", returningItems);
							model.setViewName("ReturnNoteInvoice");
							return model;
						}
					}
				}

			}

			redir.addFlashAttribute("error", 3);
			model.setViewName("redirect:/returnNote");
			return model;

		} else {
			redir.addFlashAttribute("error", 3);
			model.setViewName("redirect:/returnNote");
			return model;
		}

	}

}