package com.UDHFashion.udhmanagmentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.UDHFashion.udhmanagmentsystem.model.Shop;
import com.UDHFashion.udhmanagmentsystem.model.updateShop;
import com.UDHFashion.udhmanagmentsystem.service.IShopDAO;

@Controller
public class ShopController {

	@Autowired
	IShopDAO iShop;

	@RequestMapping(value = "/addShop", method = RequestMethod.GET)
	public String addWholeSaleShop(ModelAndView model) {

		return "shop/addShop";
	}

	/*----------------------------- Delete Shop Data -------------------------*/
	@RequestMapping(value = "/deleteShop", method = RequestMethod.POST)
	public ModelAndView deleteShop(@ModelAttribute("shop") Shop shop, ModelAndView model, RedirectAttributes redir) {

		int shopId = shop.getShopId();

		if (iShop.deleteShop(shopId)) {
			redir.addFlashAttribute("success", 3);
			model.setViewName("redirect:/viewShop");
			return model;

		} else {

			model.addObject("error", "Shop deleting unsuccesfully");
			model.setViewName("redirect:/viewShop");
			return model;
		}
		// already working with sweet alerts

	}

	/*------------------Getting the values of the shop from the Form --------------------------*/
	@RequestMapping(value = "/submitShop", method = RequestMethod.POST)
	public ModelAndView submitShopDetails(@ModelAttribute("shop") Shop shop, ModelAndView model,
			RedirectAttributes redir) {

		if (iShop.insertShopDetails(shop)) {

			redir.addFlashAttribute("success", 1);
			model.setViewName("redirect:/viewShop");
			return model;

		} else {
			model.addObject("error", "Shop adding unsuccesfully");
			model.setViewName("redirect:/addShop");
			return model;

			// already working with sweet alerts
		}

	}

	// Load Data to the forms
	@RequestMapping(value = "/editShop", method = RequestMethod.POST)
	public ModelAndView editShop(@ModelAttribute("shop") Shop updateshop, ModelAndView model) {
		updateShop sp = iShop.getShopById(updateshop.getShopId());
		model.addObject("updateShop", sp);
		model.setViewName("shop/editShop");
		return model;

	}

	// Update details to the DB

	@RequestMapping(value = "/submitUpdateShop", method = RequestMethod.POST)
	public ModelAndView submitUpdateShop(@ModelAttribute("updateShop") updateShop updateshop, ModelAndView model,
			RedirectAttributes redir) {

		if (iShop.updateShopDetails(updateshop)) {

			redir.addFlashAttribute("success", 2);
			model.setViewName("redirect:/viewShop");
			return model;

		} else {

			model.addObject("error", "Shop updating unsuccesfully");
			model.setViewName("redirect:/viewShop");
			return model;

		}

	}

}
