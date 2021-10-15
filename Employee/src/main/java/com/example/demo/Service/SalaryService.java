package com.example.demo.Service;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.demo.Definitions.Salary;

@Component
public interface SalaryService {

	Salary Update(Salary params, int id);

	//Salary Update(SalaryHistoryService params , int id);

	 
	}

	


