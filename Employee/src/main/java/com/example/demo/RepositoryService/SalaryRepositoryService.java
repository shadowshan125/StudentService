package com.example.demo.RepositoryService;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Definitions.Salary;

public interface SalaryRepositoryService extends JpaRepository<Salary, Integer> {


}