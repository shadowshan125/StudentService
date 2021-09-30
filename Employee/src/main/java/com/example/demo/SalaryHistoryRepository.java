package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Doa.SalaryHistoryDoa;

public class SalaryHistoryRepository{
	
	@Autowired
	private SalaryHistoryDoa shDoa;

}
