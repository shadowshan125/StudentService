package com.example.demo.dto;


import java.util.Date;

import org.springframework.stereotype.Component;
import com.example.demo.Employee;
import com.example.demo.EmployeeSalary;


@Component
public class EmployeeSalaryHistoryResponse {
	
	private long id;
	private Integer newSalary;
	private Date dateOfIncrement;
	
}
