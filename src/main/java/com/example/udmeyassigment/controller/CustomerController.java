package com.example.udmeyassigment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.udmeyassigment.pojo.Customer;
import com.example.udmeyassigment.service.CustomerService;

@RestController
@RequestMapping("customers/")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/{cId}")
	public Customer getCustomerById(@PathVariable("cId") int id) {
		return customerService.getCustomer(id);
	}

}
