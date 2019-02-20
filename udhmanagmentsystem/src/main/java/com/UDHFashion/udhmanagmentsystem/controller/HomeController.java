package com.UDHFashion.udhmanagmentsystem.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.UDHFashion.udhmanagmentsystem.model.Barcode;
import com.UDHFashion.udhmanagmentsystem.model.Item;
import com.UDHFashion.udhmanagmentsystem.model.Shop;
import com.UDHFashion.udhmanagmentsystem.service.IBarcodeDAO;
import com.UDHFashion.udhmanagmentsystem.service.IItemDAO;
import com.UDHFashion.udhmanagmentsystem.service.IShopDAO;
import com.UDHFashion.udhmanagmentsystem.service.ShopDAOImpl;
import com.UDHFashion.udhmanagmentsystem.util.Generator;

@Controller
public class HomeController {

	@Autowired
	IShopDAO iShop;
	
	@Autowired
	IItemDAO iItem;
	
	@Autowired
	IBarcodeDAO iBarcode;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String ShowLoginPage(ModelAndView model) {

		return "home/login";
	}
	
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

	@RequestMapping(value = "/stockView", method = RequestMethod.GET)
	public String ShowStockView(Model model) {
		List<Item> item =  iItem.getAllItemDetails();
		
		model.addAttribute("stockList", item );
		
		return "stock/stockView";
	}
	

	@RequestMapping(value = "/addShop", method = RequestMethod.GET)
	public String addWholeSaleShop(ModelAndView model) {

		return "shop/addShop";
	}

	/*----------------------------- Delete Shop Data -------------------------*/
	@RequestMapping(value = "/deleteShop", method = RequestMethod.POST)
	public String deleteShop(@ModelAttribute("shop") Shop shop, ModelMap model ) {
		
		int shopId = shop.getShopId();
		
		iShop.deleteShop(shopId);
		
		List<Shop> shopList = iShop.getAllShopsDetails();
		
		model.addAttribute("shopList",shopList);
		return "shop/viewShop";
	}
	
	/*----------------------------- Delete Barcode Item Data -------------------------*/
	@RequestMapping(value = "/deleteBarcodeItem", method = RequestMethod.POST)
	public String deleteBarcodeEntry(@ModelAttribute("barcode") Barcode barcode, ModelMap model ) {
		
		String itemCode = barcode.getItemCode();

		iBarcode.deleteBarcodeData(itemCode);
		
		List<Barcode> barcodeList = iBarcode.getAllBarcodeDetails();
		
		model.addAttribute("barcodeList", barcodeList );
		
		return "stock/printBarcode";

	}
	
	/*----------------------------- Delete Item Data -------------------------*/
	@RequestMapping(value = "/deleteItem", method = RequestMethod.POST)
	public String deleteShop(@ModelAttribute("item") Item item, ModelMap model ) {
		
		String itemCode = item.getItemCode();
	
		iItem.deleteItem(itemCode);
		
		List<Item> itemList = iItem.getAllItemDetails();
		
		model.addAttribute("stockList",itemList);
		return "stock/stockView";
	}
	
	@RequestMapping(value = "/viewShop", method = RequestMethod.GET)
	public String viewShop(Model model) {
		List<Shop> shop = iShop.getAllShopsDetails();
			
		model.addAttribute("shopList",shop);
		
		return "shop/viewShop";
	}

	

	
	
	
	
	@RequestMapping(value = "/addStock", method = RequestMethod.GET)
	public String addStock(Model model) {
		List<Shop> shop = iShop.getAllShopsDetails();
			
		model.addAttribute("shopList",shop);
			
		return "stock/addStock";
	}
	
	

	/*----------------Getting the values of the stock from the form --------------------------*/
	@RequestMapping(value = "/submitStock", method = RequestMethod.POST)
	public String submitStockDetails(@ModelAttribute("item") Item item, ModelMap model) {

		System.out.println("Net price : " +  item.getNetPrice());
		
		iItem.insertStockDetails(item);
		
		List<Shop> shop = iShop.getAllShopsDetails();
		
		model.addAttribute("shopList",shop);
		
		
		List<Item> itemList = iItem.getAllItemDetails();
		
		model.addAttribute("stockList",itemList);
		return "stock/stockView";
	}
	
	/*------------------Getting the values of the shop from the Form --------------------------*/
	@RequestMapping(value = "/submitShop", method = RequestMethod.POST)
	public String submitShopDetails(@ModelAttribute("shop") Shop shop, ModelMap model) {

		iShop.insertShopDetails(shop);
		//iShop.getAllShopsDetails();
		List<Shop> shopList = iShop.getAllShopsDetails();
		
		model.addAttribute("shopList",shopList);
		
		return "shop/viewShop";
	}


}
