package com.example.udmeyassigment.service;

import org.springframework.stereotype.Service;

import com.example.udmeyassigment.pojo.Customer;

@Service
public class CustomerService {

	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return new Customer(id,"test");
	}

}
