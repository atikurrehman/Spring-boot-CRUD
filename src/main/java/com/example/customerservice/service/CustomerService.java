package com.example.customerservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.customerservice.pojo.Customer;
import com.example.customerservice.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomerService {

	private final CustomerRepository customerRepository;

	public Customer getCustomerById(long id) {

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

	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return this.customerRepository.findAll();
	}

}
