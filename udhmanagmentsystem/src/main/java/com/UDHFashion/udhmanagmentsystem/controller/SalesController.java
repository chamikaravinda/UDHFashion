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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.UDHFashion.udhmanagmentsystem.model.Bill;
import com.UDHFashion.udhmanagmentsystem.model.Billitems;
import com.UDHFashion.udhmanagmentsystem.model.DailyBussiness;
import com.UDHFashion.udhmanagmentsystem.model.Item;
import com.UDHFashion.udhmanagmentsystem.model.TempBillitems;
import com.UDHFashion.udhmanagmentsystem.model.User;
import com.UDHFashion.udhmanagmentsystem.service.BillDAO;
import com.UDHFashion.udhmanagmentsystem.service.BillItemsDAOImpl;
import com.UDHFashion.udhmanagmentsystem.service.DailyBussinessDAOImpl;
import com.UDHFashion.udhmanagmentsystem.service.IItemDAO;
import com.UDHFashion.udhmanagmentsystem.service.TempBillDAO;
import com.UDHFashion.udhmanagmentsystem.service.TempBillitemsDAO;
import com.UDHFashion.udhmanagmentsystem.util.TempItemsToBillItesms;

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

	@Autowired
	TempItemsToBillItesms convertor;

	@Autowired
	BillItemsDAOImpl serviceBillItem;

	@Autowired
	DailyBussinessDAOImpl serviceDailyBusiness;

	@RequestMapping(value = "/viewAllSales", method = RequestMethod.GET)
	public ModelAndView viewAllSales(ModelAndView model) {

		List<Bill> getallBill = serviceBill.getAllBill();

		model.addObject("getallBill", getallBill);
		model.setViewName("sales/viewAllSales");
		return model;

	}

	@RequestMapping(value = "/finalizeBill", method = RequestMethod.POST)
	public ModelAndView finalizeBill(@ModelAttribute("permanentBill") Bill bill, ModelAndView model,RedirectAttributes redir) {

		
		Item item1= new Item();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String newDate = dateFormat.format(date);

		Double dailyNetProfite = 0.0;

		bill.setDate(newDate);
		long billID = serviceBill.insertBill(bill);

		if (billID != 0) {
			List<TempBillitems> tempItems = serviceTempBillitems.getAllTempBillitems(bill.getCashireId());
			ArrayList<Billitems> billItems = new ArrayList<>();
			
			for (TempBillitems item : tempItems) {
				billItems.add(convertor.Convert(item, (int) billID));
				Item billItem = serviceItem.getItemById(item.getItemNo());
				dailyNetProfite += (billItem.getNetProfit() * item.getQty());

				System.out.println("Item number"+item.getItemNo());
				System.out.println("Item quntity:"+ item.getQty());
				int itemQty= item.getQty();
				String itemCode=item.getItemNo();
				
				item1=serviceItem.getItemByCode(itemCode);
				
				int updateQuantityvalue = item1.getItemQuantity() - item.getQty();
				
				item1.setItemQuantity(updateQuantityvalue);
				serviceItem.updateReturnItem(item1);
				
				
				
			
				
				//serviceItem.updateItemDetails(item);
				
			}

			if (serviceBillItem.insertBillItems(billItems)) {

				DailyBussiness dailyEntry = new DailyBussiness();

				dailyEntry.setDate(newDate);
				dailyEntry.setExpenseAmount(0);
				dailyEntry.setBussinesAmount(bill.getNetAmount());
				dailyEntry.setReturnAmount(0);
				dailyEntry.setNetProfite(dailyNetProfite);
				dailyEntry.setFlag(true);

				if (serviceDailyBusiness.insertDailyBussinessEntry(dailyEntry)) {
					if (serviceTempBillitems.deleteTempBillitems(bill.getCashireId())) {

						redir.addFlashAttribute("success",1);
						model.setViewName("redirect:/viewAllSales");
						return model;
						
					}

				}

			}

		}

		redir.addFlashAttribute("error",1);
		model.setViewName("redirect:/viewSales");
		return model;
		
		
	}

	@RequestMapping(value = "/newSales", method = RequestMethod.GET)
	public ModelAndView newSales(HttpServletRequest request, ModelAndView model) {

		User user = (User) request.getSession().getAttribute("user");
		int cashireId = user.getId();

		serviceTempBill.deleteTempBill(cashireId);
		serviceTempBillitems.deleteTempBillitems(cashireId);
		List<Item> item = serviceItem.getAllItemDetails();

		model.addObject("itemList", item);
		model.setViewName("sales/newSale");
		return model;

	}

	@RequestMapping(value = "/viewSales", method = RequestMethod.GET)
	public ModelAndView viewSales(HttpServletRequest request, ModelAndView model) {

		User user = (User) request.getSession().getAttribute("user");
		int cashireId = user.getId();
		int totalItems=0;
		List<TempBillitems> itemList1 = serviceTempBillitems.getAllTempBillitems(cashireId);
		List<Item> item = serviceItem.getAllItemDetails();

		for(TempBillitems items:itemList1) {
			
			totalItems += items.getQty();
		}
		model.addObject("itemList", item);
		model.addObject("itemList1", itemList1);
		model.addObject("total_items",totalItems);
		model.setViewName("sales/newSale");
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
		tempBillitems.setReduseDiscount(itemList.getDiscount());
		tempBillitems.setAmount(tempBillitems.getPrice() * quantity - tempBillitems.getReduseDiscount() * quantity);
		tempBillitems.setCashireId(cashireId);

		// System.out.println("User ID is : "+tempBillitems.getCashireId());
		serviceTempBillitems.insertTempBillitems(tempBillitems);

		model.setViewName("redirect:/viewSales");
		return model;

	}

}
