package com.example.customerservice.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.example.customerservice.pojo.Customer;
import com.example.customerservice.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("customers")
public class CustomerController {

	private final CustomerService customerService;

	@GetMapping("/{cId}")
	public Customer getCustomerById(@PathVariable("cId") int id) {
		return customerService.getCustomerById(id);
	}

	@GetMapping
	public List<Customer> getCustomerById() {
		return customerService.getCustomers();
	}

	@PostMapping
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		return customerService.createCustomer(customer);
	}

	@PutMapping
	public Customer updateCustomer(@Valid @RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}

	@DeleteMapping("/{cId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteCustomerById(@PathVariable("cId") int id) {
		customerService.deleteCustomerById(id);
	}

}
