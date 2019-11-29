package com.bankapp.web.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.TransactionService;
import com.bankapp.web.bean.config.AccountForm;
import com.bankapp.web.bean.config.AccountRequest;
import com.bankapp.web.bean.config.MoneyForm;

@Controller
public class AccountController {

		
	@Autowired
	private AccountService accountService;
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/accountmgt")
	public String accountMenu(){
		return "account_mgt";
	}

	
	@GetMapping("/allaccounts")
	public ModelAndView allAccounts(ModelAndView mv){
		mv.addObject("accounts", accountService.findAll());
		mv.setViewName("allaccounts");
		return mv;
	}
	
	@RequestMapping(value="/addaccount",method=RequestMethod.GET)
	public String addAccountGet(ModelMap map){
		map.addAttribute("account", new AccountRequest());
		return "addaccount";
		
		
	}
	@RequestMapping(value="/addaccount",method=RequestMethod.POST)
	public String addAccountPost(@ModelAttribute(name="account")AccountRequest accountRequest,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "addaccount";
			}
		else{
			if(accountRequest.getAccountNumber()==0){
				Account account=new Account(accountRequest.getBalance(), false);
				Customer customer=new Customer(accountRequest.getName(), accountRequest.getEmail(),  accountRequest.getPhone(),  accountRequest.getAddress(),  accountRequest.getCity(),  accountRequest.getCountry());
				account.setCustomer(customer);
				accountService.createAccount(account);
			}
			/*else{
				accountService.updateAccount(accountRequest, accountRequest.getAccountNumber());
			}*/
		}
		
		return "redirect:allaccounts";
		
		
	}
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteAccount(HttpServletRequest req) {
		Long accnumber = Long.parseLong(req.getParameter("accountNumber"));
		accountService.deleteAccount(accnumber);
		return "redirect:allcustomer";
	}
	/*@RequestMapping(value="update",method= RequestMethod.GET)
	public String updateGet(HttpServletRequest req){
		Long accnumber = Long.parseLong(req.getParameter("accountNumber"));
		Account account=new 
		accountService.updateAccount(req., accnumber);
	}*/
	
	@RequestMapping(value = "transfer", method = RequestMethod.GET)
	public String transferGet(Model model) {
		model.addAttribute("accountForm", new AccountForm());
		return "transfer";

	}

	
	@RequestMapping(value = "withdraw", method = RequestMethod.GET)
	public String withdrawGet(Model model) {
		model.addAttribute("moneyForm", new MoneyForm());
		return "deposit";

	}

	@RequestMapping(value = "withdraw", method = RequestMethod.POST)
	public String withdrawPost(
			@Valid @ModelAttribute(value = "moneyForm") MoneyForm moneyForm,
			BindingResult bindingResult,Principal principal) {
		if (bindingResult.hasErrors()) {
			return "withdraw";
		}
		accountService.withdraw(moneyForm.getFromAccount(),moneyForm.getAmount(),principal.getName());

		return "redirect:allaccounts";
	}
	
	
	@RequestMapping(value = "deposit", method = RequestMethod.GET)
	public String depositGet(Model model) {
		model.addAttribute("moneyForm", new MoneyForm());
		return "deposit";

	}

	@RequestMapping(value = "deposit", method = RequestMethod.POST)
	public String depositPost(
			@Valid @ModelAttribute(value = "moneyForm") MoneyForm moneyForm,
			BindingResult bindingResult,Principal principal) {
		if (bindingResult.hasErrors()) {
			return "deposit";
		}
		accountService.deposit(moneyForm.getFromAccount(),moneyForm.getAmount(),principal.getName());

		return "redirect:allaccounts";
	}

	@RequestMapping(value = "transfer", method = RequestMethod.POST)
	public String transferPost(
			@Valid @ModelAttribute(value = "accountForm") AccountForm accountForm,
			BindingResult bindingResult,Principal principal) {
		if (bindingResult.hasErrors()) {
			return "transfer";
		}
		accountService.transfer(accountForm.getFromAccount(),
				accountForm.getToAccount(), accountForm.getAmount(),principal.getName());
		return "redirect:allaccounts";

	}


}










