package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Repository.SalaryRepository;

@SpringBootApplication
public class EmployeeApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	
	
	}

}
