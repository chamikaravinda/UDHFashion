package com.UDHFashion.udhmanagmentsystem.controller;

import java.util.List; 


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.UDHFashion.udhmanagmentsystem.model.Barcode;
import com.UDHFashion.udhmanagmentsystem.model.Item;
import com.UDHFashion.udhmanagmentsystem.model.Shop;
import com.UDHFashion.udhmanagmentsystem.model.User;
import com.UDHFashion.udhmanagmentsystem.service.IBarcodeDAO;
import com.UDHFashion.udhmanagmentsystem.service.IItemDAO;
import com.UDHFashion.udhmanagmentsystem.service.IShopDAO;
import com.UDHFashion.udhmanagmentsystem.util.Generator;

@Controller
@SessionAttributes("user")
public class HomeController {

	@Autowired
	IShopDAO iShop;
	
	@Autowired
	IItemDAO iItem;
	
	@Autowired
	IBarcodeDAO iBarcode;
	
	/*---------------------change to barcode generating view-----------------*/
	@RequestMapping(value = "/barcodeGenerateView", method = RequestMethod.GET )
	public String showBarcodeGeneratorView(Model model ) {
		List<Item> item = iItem.getAllItemDetails();

		model.addAttribute("itemList", item);
		model.addAttribute("errorMessage", "");
		
		return "stock/barcode";

	}
	
	@RequestMapping(value = "/viewBarcodeList", method = RequestMethod.GET )
	public String showBarcodePrintList(Model model ) {
		
		List<Barcode> barcode = iBarcode.getAllBarcodeDetails();
		
		model.addAttribute("barcodeList", barcode );
		
		return "stock/printBarcode";

	}

	/*-------------------------- Generate the barcode-------------------------*/
	@RequestMapping(value = "/generateBarcodePdf", method = RequestMethod.GET )
	public String generateBarcodePdf(Model model ) {
		
		List<Barcode> barcode = iBarcode.getAllBarcodeDetails();
		
		Generator.generateBarcodePdf(barcode);
		
		System.out.println("Test Quantity : " + barcode.get(0).getQuantity());
		
		for(int i = 0; i < barcode.size(); ++i){
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

		if( iBarcode.isBarcordRecorded(barcode.getItemCode())) {
			
			List<Item> item = iItem.getAllItemDetails();

			model.addAttribute("itemList", item);
			model.addAttribute("errorMessage", "*You have already added this item *");
			
			return "stock/barcode";
		}else {
			
		
			System.out.println("Validation : " + iItem.isItemRecorded(barcode.getItemCode() ) );
			
			if( iItem.isItemRecorded(barcode.getItemCode() )) {
				
				Item newItem = iItem.getItemById(barcode.getItemCode());
	
				barcode.setPrice(newItem.getPrice());
				iBarcode.insertBarcodeDetails(barcode);
				
				List<Item> item = iItem.getAllItemDetails();

				model.addAttribute("itemList", item);
				model.addAttribute("errorMessage", "");
				
				return "stock/barcode";
			}else {

				List<Item> item = iItem.getAllItemDetails();

				model.addAttribute("itemList", item);
				model.addAttribute("errorMessage", "*Invalid Item Code*");
				
				return "stock/barcode";
			}

		}

	}

	

	@GetMapping("/home")
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String ShowDashboard(Model model) {

		return "home/dashboard";
	}

}
