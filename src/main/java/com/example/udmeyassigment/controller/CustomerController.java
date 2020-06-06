package com.example.udmeyassigment.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

	@ExceptionHandler(ConstraintViolationException.class)
	public List<String> handleValidationException(ConstraintViolationException e) {

		return e.getConstraintViolations().stream().map(err -> err.getPropertyPath() + "|" + err.getMessage())
				.collect(Collectors.toList());

	}

}
