package com.example.udmeyassigment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.udmeyassigment.DTO.CustomerDTO;
import com.example.udmeyassigment.Mappers.CustomerMapper;
import com.example.udmeyassigment.pojo.Customer;
import com.example.udmeyassigment.repository.CustomerRepository;


@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
//	@Autowired
//	CustomerMapper customerMapper;

	public CustomerDTO getCustomer(long id) {
		// TODO Auto-generated method stub
		Optional<Customer> customer = customerRepository.findById(id);
		return CustomerMapper.INSTANCE.customerToCustomerDTOMap(customer.get());
	}

	public CustomerDTO createCustomer(CustomerDTO customer) {
		return CustomerMapper.INSTANCE.customerToCustomerDTOMap(
				customerRepository.save(CustomerMapper.INSTANCE.customerDtoToCustomerMap(customer)));

	}

	public CustomerDTO updateCustomer(CustomerDTO customer) {

		return CustomerMapper.INSTANCE.customerToCustomerDTOMap(
				customerRepository.save(CustomerMapper.INSTANCE.customerDtoToCustomerMap(customer)));

	}

	public void deleteCustomerById(long id) {
		this.customerRepository.deleteById(id);
	}

}
