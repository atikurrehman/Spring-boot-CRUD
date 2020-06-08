package com.example.udmeyassigment.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.udmeyassigment.DTO.CustomerDTO;
import com.example.udmeyassigment.pojo.Customer;

@Mapper
public interface CustomerMapper {
	CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

	CustomerDTO customerToCustomerDTOMap(Customer customer);

	Customer customerDtoToCustomerMap(CustomerDTO customerDTO);

}
