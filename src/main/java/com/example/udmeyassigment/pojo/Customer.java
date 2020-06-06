package com.example.udmeyassigment.pojo;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
	private int id;
	@NotBlank
	@Size(min = 3, max = 100)
	private String name;

}
