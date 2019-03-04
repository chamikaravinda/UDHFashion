package com.UDHFashion.udhmanagmentsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.UDHFashion.udhmanagmentsystem.model.CashPayments;
import com.UDHFashion.udhmanagmentsystem.model.ChequePayment;
import com.UDHFashion.udhmanagmentsystem.model.CreditBill;
import com.UDHFashion.udhmanagmentsystem.model.Employee;
import com.UDHFashion.udhmanagmentsystem.model.PaidBills;
import com.UDHFashion.udhmanagmentsystem.model.PersonalExpenditures;
import com.UDHFashion.udhmanagmentsystem.model.Shop;
import com.UDHFashion.udhmanagmentsystem.service.ICashPaymentDAO;
import com.UDHFashion.udhmanagmentsystem.service.IChequeBillDAO;
import com.UDHFashion.udhmanagmentsystem.service.IPaidBillDAO;
import com.UDHFashion.udhmanagmentsystem.service.IShopDAO;
import com.UDHFashion.udhmanagmentsystem.service.ISupplierAccountsDAO;

@Controller
public class SupplierAccountsController {

	@Autowired
	IShopDAO iShop;

	@Autowired
	ISupplierAccountsDAO serviceCreditBill;

	@Autowired
	ICashPaymentDAO serviceCashPaymet;

	@Autowired
	IChequeBillDAO serviceChequePaument;

	@Autowired
	IPaidBillDAO servicePaidBill;

	@RequestMapping(value = "/newPayment", method = RequestMethod.GET)
	public String newPayment(Model model) {

		List<CreditBill> creditBillList = serviceCreditBill.getAllCreditBillDetails();

		model.addAttribute("creditBillList", creditBillList);

		return "shop/newPayment";
	}
	// Check whether all details are corercct

	@RequestMapping(value = "/check_paymentMethod_redirect", method = RequestMethod.POST)
	public ModelAndView check_paymentMethod_redirect(@RequestParam("billNumber") String billNumber,
			@RequestParam("method") String method, ModelAndView model) {

		System.out.println(billNumber);
		System.out.println(method);

		if (billNumber.equals("newPayment")) {
			if (method.equals("cash")) {

				List<Shop> shop = iShop.getAllShopsDetails();
				model.addObject("shopList", shop);

				model.setViewName("shop/addCashPayments");

			}
			if (method.equals("Cheque")) {
				List<Shop> shop = iShop.getAllShopsDetails();
				model.addObject("shopList", shop);

				model.setViewName("shop/addCheques");
			}

		} else {

			if (method.equals("cash")) {
				List<Shop> shop = iShop.getAllShopsDetails();
				List<CreditBill> creditBillList = serviceCreditBill.getAllCreditBillDetails();

				model.addObject("creditBillList", creditBillList);
				model.addObject("shopList", shop);

				model.setViewName("shop/addExsistCashPayments");
			}
			if (method.equals("Cheque")) {
				List<Shop> shop = iShop.getAllShopsDetails();
				model.addObject("shopList", shop);

				model.setViewName("shop/addCheques");
			}

		}

		// model.setViewName("shop/addCheques");
		return model;

	}

	@RequestMapping(value = "/creditBills", method = RequestMethod.GET)
	public String addCreditBill(Model model) {

		List<Shop> shop = iShop.getAllShopsDetails();

		model.addAttribute("shopList", shop);

		return "shop/addCreditBills";
	}
	// credit bill adding to db

	@RequestMapping(value = "/submitCreditBills", method = RequestMethod.POST)
	public ModelAndView submitCreditBills(@ModelAttribute("creditBill") CreditBill creditBill, ModelAndView model,
			RedirectAttributes redir) {

		if (serviceCreditBill.insertCreditBillDetails(creditBill)) {
			redir.addFlashAttribute("success", 1);
			model.setViewName("redirect:/viewCreditBills");
			return model;
		} else {

			model.addObject("error", "Employee adding unsuccesfully");
			model.setViewName("redirect:/addCreditBills");
			return model;
		}

	}

	// View from Db
	@RequestMapping(value = "/viewCreditBills", method = RequestMethod.GET)
	public String viewCreditBills(Model model) {

		List<CreditBill> creditBillList = serviceCreditBill.getAllCreditBillDetails();

		model.addAttribute("creditBillList", creditBillList);

		return "shop/viewCreditBills";

		// working properly
	}

	// delete from DB
	@RequestMapping(value = "/deleteCreditBills", method = RequestMethod.POST)
	public ModelAndView deleteCreditBills(@ModelAttribute("creditBill") CreditBill creditBill, ModelAndView model,
			RedirectAttributes redir) {

		int id = creditBill.getId();

		if (serviceCreditBill.deleteCreditBillDetails(id)) {

			redir.addFlashAttribute("success", 3);
			model.setViewName("redirect:/viewCreditBills");
			return model;

		} else {

			model.addObject("error", "Credit Bills deleting unsuccesfully");
			model.setViewName("redirect:/viewCreditBills");
			return model;

		}

	}

	// update data to the DB

	// Load Data to the From -------------------------------

	@RequestMapping(value = "/editCreditBill", method = RequestMethod.POST)
	public ModelAndView editCreditBillShow(@ModelAttribute("creditBills") CreditBill creditBill, ModelAndView model) {

		CreditBill showCdtbill = serviceCreditBill.getCreditBillById(creditBill.getId());

		model.addObject("creditBill", showCdtbill);
		model.setViewName("shop/editCreditBills");

		return model;

	}

	// Update the Details in new Way
	@RequestMapping(value = "/submitCreditBill", method = RequestMethod.POST)
	public ModelAndView submitUpdateEmployee(ModelAndView model, @ModelAttribute("creditBills") CreditBill creditBill,
			RedirectAttributes redir) {

		if (serviceCreditBill.updateCreditBillDetails(creditBill)) {
			redir.addFlashAttribute("success", 2);
			model.setViewName("redirect:/viewCreditBills");
			return model;

		} else {

			model.addObject("error", "Credit Bill updating unsuccesfully");
			model.setViewName("redirect:/editCreditBill");
			return model;
		}

	}

	// End of all access with DB in Credit Bills

	// if we going to pay exist bill
	@RequestMapping(value = "/ExistcashPayments", method = RequestMethod.GET)
	public String ExistcashPayments(Model model) {

		List<CreditBill> exCreditBillPay = serviceCreditBill.getAllCreditBillDetails();
		List<Shop> shop = iShop.getAllShopsDetails();

		model.addAttribute("shopList", shop);

		model.addAttribute("creditBillList", exCreditBillPay);

		return "shop/addExsistCashPayments";
	}

	// CashPayments Details---------------------------------------------------------
	@RequestMapping(value = "/cashPayments", method = RequestMethod.GET)
	public String addCashPayment(Model model) {

		List<Shop> shop = iShop.getAllShopsDetails();

		model.addAttribute("shopList", shop);

		return "shop/addCashPayments";
	}

	@RequestMapping(value = "/submitCashPayment", method = RequestMethod.POST)
	public ModelAndView submitCashPayment(@ModelAttribute("cashPayment") CashPayments cashPayment,
			@ModelAttribute("paidBill") PaidBills paidBills, ModelAndView model, RedirectAttributes redir) {

		if (serviceCashPaymet.insertCashPayments(cashPayment)) {
			paidBills.setPaymentMethod("Cash Payment");
			if (servicePaidBill.insertPaidBillDetails(paidBills)) {

				redir.addFlashAttribute("success", 1);
				model.setViewName("redirect:/paidBills");
			}

		} else {

			model.addObject("error", "CashPayment adding unsuccesfully");
			model.setViewName("redirect:/addCreditBills");
		}
		return model;

	}

	// View Cash Payment
	@RequestMapping(value = "/viewCashPayment", method = RequestMethod.GET)
	public String viewCashPayment(Model model) {

		List<CashPayments> cashPaymentList = serviceCashPaymet.getAllCashPaymentsDetails();

		model.addAttribute("cashPaymentList", cashPaymentList);

		return "shop/viewCashPayments";

		// working properly
	}

	@RequestMapping(value = "/paidBills", method = RequestMethod.GET)
	public String viewPaidbill(Model model) {

		List<PaidBills> paidbills = servicePaidBill.getAllPaidBillDetails();
		model.addAttribute("paidbills", paidbills);

		return "shop/paidBills";

		// working properly
	}

	// All things with Cheque addings
	@RequestMapping(value = "/addCheques", method = RequestMethod.GET)
	public String addCheque(Model model) {
		List<Shop> shop = iShop.getAllShopsDetails();

		model.addAttribute("shopList", shop);

		return "shop/addCheques";
	}

	@RequestMapping(value = "/submitChequePayment", method = RequestMethod.POST)
	public ModelAndView submitChequePayment(@ModelAttribute("chequePayment") ChequePayment chequePayment,
			@ModelAttribute("paidBills") PaidBills paidBills, ModelAndView model, RedirectAttributes redir) {

		paidBills.setBillAmount(chequePayment.getChequeAmount());

		if (serviceChequePaument.insertChequePayment(chequePayment)) {
			paidBills.setPaymentMethod("Cheque Payment");
			if (servicePaidBill.insertPaidBillDetails(paidBills)) {

				redir.addFlashAttribute("success", 1);
				model.setViewName("redirect:/paidBills");
			}

		} else {

			model.addObject("error", "Cheque Payment adding unsuccesfully");
			model.setViewName("redirect:/addCreditBills");
		}
		return model;

	}

}
