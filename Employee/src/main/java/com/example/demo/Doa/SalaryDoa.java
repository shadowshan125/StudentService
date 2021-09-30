package com.example.demo.Doa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.EmployeeSalary;

public interface SalaryDoa extends JpaRepository<EmployeeSalary,Long> {
	
	

}
