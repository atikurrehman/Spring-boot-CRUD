package com.example.udmeyassigment.service;

import org.springframework.stereotype.Service;

import com.example.udmeyassigment.pojo.Customer;
import com.example.udmeyassigment.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomerService {

	private final CustomerRepository customerRepository;

	public Customer getCustomer(long id) {

		return this.customerRepository.findById(id).orElseThrow();
	}

	public Customer createCustomer(Customer customer) {

		return this.customerRepository.save(customer);
	}

	public Customer updateCustomer(Customer customer) {
		Customer cust = this.customerRepository.findById(customer.getId()).orElseThrow();
		cust.setName(customer.getName());
		return this.customerRepository.save(cust);
	}

	public void deleteCustomerById(long id) {
		this.customerRepository.deleteById(id);
	}

}
