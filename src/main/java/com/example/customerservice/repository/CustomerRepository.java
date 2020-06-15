package com.example.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.customerservice.pojo.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
