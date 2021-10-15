package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.SalaryService;
import com.example.demo.Handler.ResponseHandler;
import com.example.demo.RepositoryService.SalaryRepositoryService;
import com.example.demo.Definitions.Salary;

@RestController
public class SalaryController {
	private final SalaryService salaryService;

	public SalaryController(SalaryService salaryService, SalaryRepositoryService srs) {
		this.salaryService = salaryService;
	}

	@PutMapping(value = "/salary/{id}")
	public ResponseEntity<Object> Update(@PathVariable int id, @RequestBody Salary params) {
		try {
			Salary result = salaryService.Update(params, id);
			return ResponseHandler.generateResponse("Updated", HttpStatus.OK, result);
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND, null);
		}
	}

}
