package com.dhruv.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dhruv.mvc.DAO.CustomerDAO;
import com.dhruv.mvc.entity.Customer;
import com.dhruv.mvc.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerControler
{
	//need to inject customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel)
	{
		//get customer from service
		List<Customer> theCustomers = customerService.getCustomers();
		
		//add to model
		theModel.addAttribute("customers",theCustomers);
		return "list-customers";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		//create model attribute to bind data
		Customer customer = new Customer();
		theModel.addAttribute("customer", customer);
		return "customer-form";		
	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer)
	{
		//save the csutomer using service
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";		
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerID")int id,Model theModel)
	{
		//get customer from service
		Customer theCustomer = customerService.getCustomer(id);
		//prepoluate the form using model
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("customerID")int id,Model theModel)
	{
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}
}
