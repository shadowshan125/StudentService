package com.example.demo.Repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.RepositoryService.SalaryRepositoryService;

public class SalaryRepository {

	
	@Autowired
	private SalaryRepositoryService srs;

	public SalaryRepositoryService getSrs() {
		return srs;
	}

	public void setSrs(SalaryRepositoryService srs) {
		this.srs = srs;
	}
}
