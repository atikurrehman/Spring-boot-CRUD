package com.example.udmeyassigment.service;

import org.springframework.stereotype.Service;

import com.example.udmeyassigment.pojo.Customer;

@Service
public class CustomerService {

	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return new Customer(id, "test");
	}

	public Customer createCustomer(Customer customer) {

		return new Customer((int) (Math.random()*10), customer.getName());
	}

	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customer;
	}

	public void deleteCustomerById(int id) {

	}

}
