package com.UDHFashion.udhmanagmentsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.UDHFashion.udhmanagmentsystem.model.Barcode;
import com.UDHFashion.udhmanagmentsystem.model.Item;
import com.UDHFashion.udhmanagmentsystem.model.Shop;
import com.UDHFashion.udhmanagmentsystem.service.IBarcodeDAO;
import com.UDHFashion.udhmanagmentsystem.service.IItemDAO;
import com.UDHFashion.udhmanagmentsystem.service.IShopDAO;
import com.UDHFashion.udhmanagmentsystem.util.Generator;

@Controller
public class StockController {

	@Autowired
	IShopDAO iShop;

	@Autowired
	IItemDAO iItem;

	@Autowired
	IBarcodeDAO iBarcode;

	// return note handling update the current item
	// in here you have to create a new sevice class that have two params such that
	// int amount and String itemNo



	@RequestMapping(value = "/returnItem", method = RequestMethod.POST)
	public ModelAndView returnItem(@ModelAttribute("Item") Item item, ModelAndView model,RedirectAttributes redir) {

		Item itemSave =iItem.getItemByCode(item.getItemCode());

		itemSave.setItemQuantity(itemSave.getItemQuantity() + item.getItemQuantity());
		iItem.updateItemDetails(itemSave);

		redir.addFlashAttribute("success",3);
		model.setViewName("redirect:/stockView");
		return model;

	}

	/*---------------------change to barcode generating view-----------------*/
	@RequestMapping(value = "/barcodeGenerateView", method = RequestMethod.GET)
	public String showBarcodeGeneratorView(Model model) {
		List<Item> item = iItem.getAllItemDetails();

		model.addAttribute("itemList", item);
		model.addAttribute("errorMessage", "");

		return "stock/barcode";

	}

	@RequestMapping(value = "/viewBarcodeList", method = RequestMethod.GET)
	public String showBarcodePrintList(Model model) {

		List<Barcode> barcode = iBarcode.getAllBarcodeDetails();

		model.addAttribute("barcodeList", barcode);

		return "stock/printBarcode";

	}

	/*-------------------------- Generate the barcode-------------------------*/
	@RequestMapping(value = "/generateBarcodePdf", method = RequestMethod.GET)
	public String generateBarcodePdf(Model model) {

		List<Barcode> barcode = iBarcode.getAllBarcodeDetails();

		Generator.generateBarcodePdf(barcode);

		System.out.println("Test Quantity : " + barcode.get(0).getQuantity());

		for (int i = 0; i < barcode.size(); ++i) {
			String itemCode = barcode.get(i).getItemCode();

			iBarcode.deleteBarcodeData(itemCode);
		}

		List<Item> item = iItem.getAllItemDetails();

		model.addAttribute("itemList", item);

		return "stock/barcode";
	}

	/*----------------Getting the values of the stock from the form --------------------------*/
	@RequestMapping(value = "/generateBarcode", method = RequestMethod.POST)
	public String submitStockDetails(@ModelAttribute("barcode") Barcode barcode, ModelMap model) {

		if (iBarcode.isBarcordRecorded(barcode.getItemCode())) {

			List<Item> item = iItem.getAllItemDetails();

			model.addAttribute("itemList", item);
			model.addAttribute("errorMessage", "*You have already added this item *");

			return "stock/barcode";
		} else {

			System.out.println("Validation : " + iItem.isItemRecorded(barcode.getItemCode()));

			if (iItem.isItemRecorded(barcode.getItemCode())) {

				Item newItem = iItem.getItemById(barcode.getItemCode());

				barcode.setPrice(newItem.getPrice());
				iBarcode.insertBarcodeDetails(barcode);

				List<Item> item = iItem.getAllItemDetails();

				model.addAttribute("itemList", item);
				model.addAttribute("errorMessage", "");

				return "stock/barcode";
			} else {

				List<Item> item = iItem.getAllItemDetails();

				model.addAttribute("itemList", item);
				model.addAttribute("errorMessage", "*Invalid Item Code*");

				return "stock/barcode";
			}

		}

	}

	@RequestMapping(value = "/stockView", method = RequestMethod.GET)
	public String ShowStockView(Model model) {
		List<Item> item = iItem.getAllItemDetails();

		model.addAttribute("stockList", item);

		return "stock/stockView";
	}

	/*----------------------------- Delete Barcode Item Data -------------------------*/
	@RequestMapping(value = "/deleteBarcodeItem", method = RequestMethod.POST)
	public String deleteBarcodeEntry(@ModelAttribute("barcode") Barcode barcode, ModelMap model) {

		String itemCode = barcode.getItemCode();

		iBarcode.deleteBarcodeData(itemCode);

		List<Barcode> barcodeList = iBarcode.getAllBarcodeDetails();

		model.addAttribute("barcodeList", barcodeList);

		return "stock/printBarcode";

	}

	/*----------------------------- Delete Item Data -------------------------*/
	@RequestMapping(value = "/deleteItem", method = RequestMethod.POST)
	public String deleteItem(@ModelAttribute("item") Item item, ModelMap model) {

		String itemCode = item.getItemCode();

		iItem.deleteItem(itemCode);

		List<Item> itemList = iItem.getAllItemDetails();

		model.addAttribute("stockList", itemList);
		model.addAttribute("success",1);
		return "stock/stockView";
	}
	
	/*----------------------------- show edit Item Data -------------------------*/
	@RequestMapping(value = "/editItem", method = RequestMethod.POST)
	public ModelAndView editItem(@ModelAttribute("item") Item item, ModelAndView model) {

		String itemCode = item.getItemCode();

		Item editItem=iItem.getItemByCode(itemCode);
		List<Shop> shop = iShop.getAllShopsDetails();

		model.addObject("shopList", shop);
		model.addObject("item", editItem);
		model.setViewName("stock/editItem");
		return model;
	}
	
	
	
	/*----------------update the stock details--------------------------*/
	@RequestMapping(value = "/updateStock", method = RequestMethod.POST)
	public ModelAndView updateStockDetails(@ModelAttribute("item") Item item, ModelAndView model,RedirectAttributes redir) {

		iItem.updateItemDetails(item);
		redir.addFlashAttribute("success",2);
		model.setViewName("redirect:/stockView");
		return model;
	}
	

	@RequestMapping(value = "/viewShop", method = RequestMethod.GET)
	public String viewShop(Model model) {
		List<Shop> shop = iShop.getAllShopsDetails();

		model.addAttribute("shopList", shop);

		return "shop/viewShop";
	}

	@RequestMapping(value = "/addStock", method = RequestMethod.GET)
	public String addStock(Model model) {
		List<Shop> shop = iShop.getAllShopsDetails();

		model.addAttribute("shopList", shop);

		return "stock/addStock";
	}

	/*----------------Getting the values of the stock from the form --------------------------*/
	@RequestMapping(value = "/submitStock", method = RequestMethod.POST)
	public String submitStockDetails(@ModelAttribute("item") Item item, ModelMap model) {

		System.out.println("Net price : " + item.getNetPrice());

		iItem.insertStockDetails(item);

		List<Shop> shop = iShop.getAllShopsDetails();

		model.addAttribute("shopList", shop);

		List<Item> itemList = iItem.getAllItemDetails();
		model.addAttribute("success",4);
		model.addAttribute("stockList", itemList);
		return "stock/stockView";
	}


}
