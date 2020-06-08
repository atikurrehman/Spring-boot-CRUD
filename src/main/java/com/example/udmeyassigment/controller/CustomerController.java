package com.example.udmeyassigment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.udmeyassigment.DTO.CustomerDTO;
import com.example.udmeyassigment.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j // will provide loggin
@RestController
@RequestMapping("customers/")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/{cId}")
	public CustomerDTO getCustomerById(@PathVariable("cId") int id) {
		log.debug("in getCustomerById +" + id);
		return customerService.getCustomer(id);
	}

	@PostMapping
	public CustomerDTO createCustomer(@Valid @RequestBody CustomerDTO customer) {
		return customerService.createCustomer(customer);
	}

	@PutMapping
	public CustomerDTO updateCustomer(@Valid @RequestBody CustomerDTO customer) {
		return customerService.updateCustomer(customer);
	}

	@DeleteMapping("/{cId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteCustomerById(@PathVariable("cId") int id) {
		customerService.deleteCustomerById(id);
	}

}
