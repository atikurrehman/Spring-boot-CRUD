package com.example.udmeyassigment.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.udmeyassigment.pojo.Customer;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

}
