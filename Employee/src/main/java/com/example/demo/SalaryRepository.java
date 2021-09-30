package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Doa.SalaryDoa;
import com.example.demo.Doa.SalaryHistoryDoa;

@Service
public class SalaryRepository  {
	
	@Autowired
	private SalaryDoa SDoa;

}
