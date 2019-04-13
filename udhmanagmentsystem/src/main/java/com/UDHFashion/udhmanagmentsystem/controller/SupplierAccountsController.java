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

	// view All credit bills
	@RequestMapping(value = "/allCreditBills", method = RequestMethod.GET)
	public String viewCreditBills(Model model) {

		List<CreditBill> creditBillList = serviceCreditBill.getAllCreditBillDetails();

		model.addAttribute("creditBillList", creditBillList);

		return "shop/viewCreditBills";

	}

	// show add new credit bill page
	@RequestMapping(value = "/addCreditBills", method = RequestMethod.GET)
	public String addCreditBill(Model model) {

		List<Shop> shop = iShop.getAllShopsDetails();

		model.addAttribute("shopList", shop);

		return "shop/addCreditBills";
	}

	// add new credit bill
	@RequestMapping(value = "/addCreditBills", method = RequestMethod.POST)
	public ModelAndView submitCreditBills(@ModelAttribute("creditBill") CreditBill creditBill, ModelAndView model,
			RedirectAttributes redir) {

		if (serviceCreditBill.insertCreditBillDetails(creditBill)) {
			redir.addFlashAttribute("success", 1);
			model.setViewName("redirect:/allCreditBills");
			return model;
		} else {

			model.addObject("error", "Employee adding unsuccesfully");
			model.setViewName("redirect:/addCreditBills");
			return model;
		}

	}

	// show edit credit bill page
	@RequestMapping(value = "/editCreditBill", method = RequestMethod.POST)
	public ModelAndView editCreditBillShow(@ModelAttribute("creditBills") CreditBill creditBill, ModelAndView model) {

		CreditBill showCdtbill = serviceCreditBill.getCreditBillById(creditBill.getId());

		List<Shop> shop = iShop.getAllShopsDetails();

		model.addObject("shopList", shop);
		model.addObject("creditBill", showCdtbill);
		model.setViewName("shop/editCreditBills");

		return model;

	}

	// save edited credit bill
	@RequestMapping(value = "/updateCreditBill", method = RequestMethod.POST)
	public ModelAndView submitUpdateEmployee(ModelAndView model, @ModelAttribute("creditBills") CreditBill creditBill,
			RedirectAttributes redir) {

		if (serviceCreditBill.updateCreditBillDetails(creditBill)) {
			redir.addFlashAttribute("success", 2);
			model.setViewName("redirect:/allCreditBills");
			return model;

		} else {

			model.addObject("error", "Credit Bill updating unsuccesfully");
			model.setViewName("redirect:/editCreditBill");
			return model;
		}

	}

	// delete the credit bill
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

	// show new payment page
	@RequestMapping(value = "/newPayment", method = RequestMethod.GET)
	public String newPayment(Model model) {

		List<CreditBill> creditBillList = serviceCreditBill.getAllCreditBillDetails();

		model.addAttribute("creditBillList", creditBillList);

		return "shop/newPayment";
	}

	// redirect to relevent payment page
	@RequestMapping(value = "/newPayment", method = RequestMethod.POST)
	public ModelAndView check_paymentMethod_redirect(@RequestParam("billNumber") String billNumber,
			@RequestParam("method") String method, ModelAndView model) {

		if (billNumber.equals("newPayment")) {
			if (method.equals("cash")) {

				model.setViewName("redirect:/addcashPayments");

			}
			if (method.equals("Cheque")) {
				List<Shop> shop = iShop.getAllShopsDetails();
				model.addObject("shopList", shop);

				model.setViewName("shop/addCheques");
			}

		} else {

			if (method.equals("cash")) {

				CreditBill bill = new CreditBill();
				bill = serviceCreditBill.getCreditBillByBillNo(billNumber);
				model.addObject("creditBills", bill);
				model.setViewName("shop/addExsistCashPayments");

				return model;
			}
			if (method.equals("Cheque")) {
				CreditBill bill = new CreditBill();
				bill = serviceCreditBill.getCreditBillByBillNo(billNumber);
				model.addObject("creditBills", bill);
				model.setViewName("shop/addExsistChequePayment");
			}

		}
		return model;

	}

	// pay existing credit bill by cash
	@RequestMapping(value = "/existCreditBillCashPayments", method = RequestMethod.POST)
	public ModelAndView creditBillCashPay(ModelAndView model, @ModelAttribute("creditBills") CashPayments payment,
			RedirectAttributes redir) {

		if (serviceCashPaymet.insertCashPayments(payment)) {

			PaidBills paidbill = new PaidBills();
			paidbill.setBillAmount(payment.getBillAmount());
			paidbill.setBillDate(payment.getBillDate());
			paidbill.setBillNo(payment.getBillNo());
			paidbill.setPaymentDate(payment.getPaymentDate());
			paidbill.setPaymentMethod("Cash Payment");
			paidbill.setShopName(payment.getShopName());

			if (servicePaidBill.insertPaidBillDetails(paidbill)
					&& serviceCreditBill.deleteCreditBillDetails(payment.getBillNo())) {

				redir.addFlashAttribute("success", 1);
				model.setViewName("redirect:/paidBills");
			}

		} else {

			model.addObject("error", 1);
			model.addObject("creditBills", payment);
			model.setViewName("addExsistCashPayments");
		}
		return model;

	}

	// pay existing credit bill by cheque
	@RequestMapping(value = "/existCreditBillChequePayments", method = RequestMethod.POST)
	public ModelAndView creditBillChequePay(ModelAndView model, @ModelAttribute("creditBills") ChequePayment payment,
			RedirectAttributes redir) {

		if (serviceChequePaument.insertChequePayment(payment)) {

			PaidBills paidbill = new PaidBills();
			paidbill.setBillAmount(payment.getBillAmount());
			paidbill.setBillDate(payment.getBillDate());
			paidbill.setBillNo(payment.getBillNo());
			paidbill.setPaymentDate(payment.getPaymentDate());
			paidbill.setPaymentMethod("Cheque Payment");
			paidbill.setShopName(payment.getShopName());

			if (servicePaidBill.insertPaidBillDetails(paidbill)
					&& serviceCreditBill.deleteCreditBillDetails(payment.getBillNo())) {

				redir.addFlashAttribute("success", 5);
				model.setViewName("redirect:/paidBills");
			}

		} else {

			model.addObject("error", 1);
			model.addObject("creditBills", payment);
			model.setViewName("shop/addExsistChequePayment");
		}
		return model;

	}

	// Show Cash payments
	@RequestMapping(value = "/cashPayments", method = RequestMethod.GET)
	public String viewCashPayment(Model model) {

		List<CashPayments> cashPaymentList = serviceCashPaymet.getAllCashPaymentsDetails();

		model.addAttribute("cashPaymentList", cashPaymentList);

		return "shop/viewCashPayments";

		// working properly
	}

	// show cheque payments
	@RequestMapping(value = "/cheqPayments", method = RequestMethod.GET)
	public String viewCheqPayment(Model model) {

		List<ChequePayment> CheqPaymentList = serviceChequePaument.getAllChequePaymentDetails();

		model.addAttribute("chequPaymentList", CheqPaymentList);

		return "shop/viewCheuqPayments";

	}

	// show paid bills
	@RequestMapping(value = "/paidBills", method = RequestMethod.GET)
	public String viewPaidbill(Model model) {

		List<PaidBills> paidbills = servicePaidBill.getAllPaidBillDetails();
		model.addAttribute("paidbills", paidbills);

		return "shop/paidBills";

		// working properly
	}

	// new Cash Payment
	@RequestMapping(value = "/addcashPayments", method = RequestMethod.GET)
	public String showCashPayment(Model model) {

		List<Shop> shop = iShop.getAllShopsDetails();
		CashPayments payment = new CashPayments();

		model.addAttribute("cashPayment", payment);
		model.addAttribute("shopList", shop);

		return "shop/addCashPayments";
	}

	// add new Cash payment
	@RequestMapping(value = "/addcashPayments", method = RequestMethod.POST)
	public ModelAndView addCashPayment(ModelAndView model, @ModelAttribute("cashPayment") CashPayments payment,
			RedirectAttributes redir) {

		if (serviceCashPaymet.insertCashPayments(payment)) {

			PaidBills paidbill = new PaidBills();
			paidbill.setBillAmount(payment.getBillAmount());
			paidbill.setBillDate(payment.getBillDate());
			paidbill.setBillNo(payment.getBillNo());
			paidbill.setPaymentDate(payment.getPaymentDate());
			paidbill.setPaymentMethod("Cash Payment");
			paidbill.setShopName(payment.getShopName());

			if (servicePaidBill.insertPaidBillDetails(paidbill)) {

				redir.addFlashAttribute("success", 6);
				model.setViewName("redirect:/paidBills");
			}

		} else {

			model.addObject("error", 1);
			model.addObject("cashPayment", payment);
			model.setViewName("addCashPayments");
		}
		return model;
	}

	// new cheq payament
	@RequestMapping(value = "/addCheques", method = RequestMethod.GET)
	public String showChequePayment(Model model) {
		List<Shop> shop = iShop.getAllShopsDetails();
		ChequePayment payment = new ChequePayment();

		model.addAttribute("shopList", shop);
		model.addAttribute("chequePayment", payment);
		return "shop/addCheques";
	}

	// add new Cheque payment
	@RequestMapping(value = "/addCheques", method = RequestMethod.POST)
	public ModelAndView newChequePayment(ModelAndView model, @ModelAttribute("chequePayment") ChequePayment payment,
			RedirectAttributes redir) {

		if (serviceChequePaument.insertChequePayment(payment)) {

			PaidBills paidbill = new PaidBills();
			paidbill.setBillAmount(payment.getBillAmount());
			paidbill.setBillDate(payment.getBillDate());
			paidbill.setBillNo(payment.getBillNo());
			paidbill.setPaymentDate(payment.getPaymentDate());
			paidbill.setPaymentMethod("Cheque Payment");
			paidbill.setShopName(payment.getShopName());

			if (servicePaidBill.insertPaidBillDetails(paidbill)) {

				redir.addFlashAttribute("success", 7);
				model.setViewName("redirect:/paidBills");
			}

		} else {

			model.addObject("error", 1);
			model.addObject("chequePayment", payment);
			model.setViewName("shop/addCheques");
		}
		return model;

	}

	///////////////////// complete till this point
	@RequestMapping(value = "/ExistcashPayments", method = RequestMethod.GET)
	public String ExistcashPayments(Model model) {

		List<CreditBill> exCreditBillPay = serviceCreditBill.getAllCreditBillDetails();
		List<Shop> shop = iShop.getAllShopsDetails();

		model.addAttribute("shopList", shop);

		model.addAttribute("creditBillList", exCreditBillPay);

		return "shop/addExsistCashPayments";
	}

	@RequestMapping(value = "/submitCashPayment", method = RequestMethod.POST)
	public ModelAndView submitCashPayment(@ModelAttribute("cashPayment") CashPayments cashPayment,
			@ModelAttribute("paidBill") PaidBills paidBills, ModelAndView model, RedirectAttributes redir) {

		System.out.println(cashPayment.getBillNo());

		if (serviceCashPaymet.insertCashPayments(cashPayment)) {
			paidBills.setPaymentMethod("Cash Payment");
			if (servicePaidBill.insertPaidBillDetails(paidBills)
					&& serviceCreditBill.deleteCreditBillDetails(cashPayment.getBillNo())) {

				redir.addFlashAttribute("success", 1);
				model.setViewName("redirect:/paidBills");
			}

		} else {

			model.addObject("error", "CashPayment adding unsuccesfully");
			model.setViewName("redirect:/addCreditBills");
		}
		return model;

	}

	@RequestMapping(value = "/submitChequePayment", method = RequestMethod.POST)
	public ModelAndView submitChequePayment(@ModelAttribute("chequePayment") ChequePayment chequePayment,
			@ModelAttribute("paidBills") PaidBills paidBills, ModelAndView model, RedirectAttributes redir) {

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
