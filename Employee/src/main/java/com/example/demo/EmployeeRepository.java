package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Doa.EmployeeDoa;
@Service
public class EmployeeRepository  {

	@Autowired
	private EmployeeDoa empDoa;

	

}
