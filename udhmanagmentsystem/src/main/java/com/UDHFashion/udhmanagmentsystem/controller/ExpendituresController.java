package com.UDHFashion.udhmanagmentsystem.controller;

import java.util.List;

import org.apache.taglibs.standard.extra.spath.SPathFilter;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.UDHFashion.udhmanagmentsystem.model.DailyBussiness;
import com.UDHFashion.udhmanagmentsystem.model.PersonalExpenditures;

import com.UDHFashion.udhmanagmentsystem.model.ShopExpenditures;
import com.UDHFashion.udhmanagmentsystem.service.IDailyBussinessDAO;
import com.UDHFashion.udhmanagmentsystem.service.IExpendituresDAO;

@Controller
public class ExpendituresController {

	@Autowired
	IExpendituresDAO servicePexpnditures;

	@Autowired
	IExpendituresDAO serviceSpexpnditures;

	@Autowired
	IDailyBussinessDAO serviceDailyBussines;

	@RequestMapping(value = "/addShopExpenditures", method = RequestMethod.GET)
	public String addShopExpenditures(Model model) {

		return "expenditures/addShopExpenditures";
	}

	@RequestMapping(value = "/addPersonalExpenditures", method = RequestMethod.GET)
	public String addPersonalExpenditures(Model model) {

		return "expenditures/addPersonalExpenditures";
	}
	/*----------- Personal expences are not included in the daily report ----------------*/
	// add Personal Expenditures
	@RequestMapping(value = "/submitPersonalExpenditures", method = RequestMethod.POST)
	public ModelAndView submitPersonalExpenditures(
			@ModelAttribute("PersonalExpenditures") PersonalExpenditures personalExpenditures, ModelAndView model,
			RedirectAttributes redir) {

		if (servicePexpnditures.insertPersonalExpenditures(personalExpenditures)) {
			redir.addFlashAttribute("success", 1);
			model.setViewName("redirect:/viewPexpenditures");
			return model;

		} else {
			model.addObject("error", "Personal Expenditures adding unsuccesfully");
			model.setViewName("redirect:/addPersonalExpenditures");
			return model;

		}

	}

	// View Personal Expenditures

	@RequestMapping(value = "/viewPexpenditures", method = RequestMethod.GET)
	public String viewPersonalExpenditures(Model model) {

		List<PersonalExpenditures> pExpendituresList = servicePexpnditures.getAllPersonalExpenditures();

		model.addAttribute("pExpendituresList", pExpendituresList);

		return "expenditures/viewPexpenditures";

		// Already working properly
	}

	// Delete Personal Expenditures

	@RequestMapping(value = "/deletePerExpenditures", method = RequestMethod.POST)
	public ModelAndView deletePersonalEx(@ModelAttribute("PersonalExpenditures") PersonalExpenditures PerExpenditures,
			ModelAndView model, RedirectAttributes redir) {

		int id = PerExpenditures.getId();

		if (servicePexpnditures.deletePersonalExpenditures(id)) {

			redir.addFlashAttribute("success", 3);
			model.setViewName("redirect:/viewPexpenditures");
			return model;

		} else {

			model.addObject("error", "Personal  Expeditures deleting unsuccesfully");
			model.setViewName("redirect:/viewPexpenditures");
			return model;

		}

	}

	// Load Personal Expenditures Data to the forms
	@RequestMapping(value = "/editPersonalExpenditures", method = RequestMethod.POST)
	public ModelAndView editPersonalExpenditures(@ModelAttribute("p_expenditures") PersonalExpenditures perExpenditures,
			ModelAndView model) {

		PersonalExpenditures PeEx = servicePexpnditures.getPersonalExpendituresById(perExpenditures.getId());

		model.addObject("p_expenditures", PeEx);
		model.setViewName("expenditures/editPersonalExpenditures");

		return model;

	}

	// Update Personal Expenditures the Details(already working with Sweet alerts)

	@RequestMapping(value = "/updatePersonalExpenditures", method = RequestMethod.POST)
	public ModelAndView updatePersonalExpenditures(
			@ModelAttribute("p_expenditures") PersonalExpenditures perExpenditures, ModelAndView model,
			RedirectAttributes redir) {

		if (servicePexpnditures.updatePersonalExpenditures(perExpenditures)) {

			redir.addFlashAttribute("success", 2);
			model.setViewName("redirect:/viewPexpenditures");
			return model;
		} else {
			model.addObject("error", "Account adding unsuccesfully");
			model.setViewName("redirect:/editPersonalExpenditures");
			return model;
		}

	}

	/*---------------------------  ShopExpenditures Completed totally --------------------*/
	// Add ShopExpenditures
	@RequestMapping(value = "/submitShopExpenditures", method = RequestMethod.POST)
	public ModelAndView submitShopExpenditures(@ModelAttribute("ShopExpenditures") ShopExpenditures SpExpenditures,
			ModelAndView model, RedirectAttributes redir) {

		if (serviceSpexpnditures.insertShopExpenditures(SpExpenditures)) {

			DailyBussiness entry = new DailyBussiness();
			entry.setDate(SpExpenditures.getDate());
			entry.setBussinesAmount(0);
			entry.setExpenseAmount(SpExpenditures.getAmount());
			entry.setNetProfite(0);
			entry.setReturnAmount(0);
			entry.setFlag(true);
			if (serviceDailyBussines.insertDailyBussinessEntry(entry)) {
				redir.addFlashAttribute("success", 1);
				model.setViewName("redirect:/viewShopExpenditures");
				return model;
			} else {
				model.addObject("error", "Updating daily transfers amount unsuccesfully");
				model.setViewName("redirect:/addShopExpenditures");
				return model;
			}
		} else {
			model.addObject("error", "Shop Expenditures adding unsuccesfully");
			model.setViewName("redirect:/addShopExpenditures");
			return model;
		}

	}
	// View ShopExpenditures

	@RequestMapping(value = "/viewShopExpenditures", method = RequestMethod.GET)
	public String viewShopExpenditures(Model model) {

		List<ShopExpenditures> ShExpenditures = serviceSpexpnditures.getAllShopExpenditures();
		model.addAttribute("ShExpenditures", ShExpenditures);
		return "expenditures/viewShopExpenditures";
	}

	// delete ShopExpenditures

	@RequestMapping(value = "/deleteShopExpenditures", method = RequestMethod.POST)
	public ModelAndView deleteShop(@ModelAttribute("ShopExpenditures") ShopExpenditures SpExpenditures,
			ModelAndView model, RedirectAttributes redir) {

		int id = SpExpenditures.getId();

		if (serviceSpexpnditures.deleteShopExpenditures(id)) {
			if (serviceDailyBussines.deleteExpence(SpExpenditures.getAmount(), SpExpenditures.getDate())) {
				redir.addFlashAttribute("success", 3);
				model.setViewName("redirect:/viewShopExpenditures");
				return model;

			} else {

				model.addObject("error", "Shop Expenditures deleting unsuccesfully");
				model.setViewName("redirect:/viewEmployee");
				return model;

			}
		} else {
			model.addObject("error", "Shop Expenditures deleting unsuccesfully");
			model.setViewName("redirect:/viewEmployee");
			return model;
		}
	}

	// Load shop expenditures Data to the forms
	@RequestMapping(value = "/editShopExpenditures", method = RequestMethod.POST)
	public ModelAndView editShopExpenditures(@ModelAttribute("shop_expenditures") ShopExpenditures ShExpenditures,
			ModelAndView model) {

		ShopExpenditures emp = serviceSpexpnditures.getShopExpendituresById(ShExpenditures.getId());

		model.addObject("shop_expenditures", emp);
		model.setViewName("expenditures/editShopExpenditures");

		return model;
		// Already working Properly
	}

	// Update shop Expenditures the Details(already working with Sweet alerts)

	@RequestMapping(value = "/updateShopExpenditures", method = RequestMethod.POST)
	public ModelAndView updateShopExpenditures(@ModelAttribute("shop_expenditures") ShopExpenditures ShExpenditures,
			ModelAndView model, RedirectAttributes redir) {
		// get the current expence value;
		ShopExpenditures expence = serviceSpexpnditures.getShopExpendituresById(ShExpenditures.getId());
		if (expence.getAmount() != 0) {

			DailyBussiness todayEntry = new DailyBussiness();
			todayEntry.setBussinesAmount(0);
			todayEntry.setExpenseAmount(ShExpenditures.getAmount() - expence.getAmount());
			todayEntry.setNetProfite(0);
			todayEntry.setReturnAmount(0);
			if (serviceDailyBussines.updateDailyEntry(todayEntry)) {
				if (serviceSpexpnditures.updateShopExpenditures(ShExpenditures)) {

					redir.addFlashAttribute("success", 2);
					model.setViewName("redirect:/viewShopExpenditures");
					return model;
				} else {
					model.addObject("error", "Account adding unsuccesfully");
					model.setViewName("redirect:/editShopExpenditures");
					return model;
				}
			}else {
				model.addObject("error", "Account adding unsuccesfully");
				model.setViewName("redirect:/editShopExpenditures");
				return model;
			}
		} else {
			model.addObject("error", "Account adding unsuccesfully");
			model.setViewName("redirect:/editShopExpenditures");
			return model;
		}

	}

}
