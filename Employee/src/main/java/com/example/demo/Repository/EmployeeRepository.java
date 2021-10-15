package com.example.demo.Repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.RepositoryService.EmployeeRepositoryService;

public class EmployeeRepository {

	@Autowired
	private EmployeeRepositoryService ers;

	public EmployeeRepositoryService getErs() {
		return ers;
	}

	public void setErs(EmployeeRepositoryService ers) {
		this.ers = ers;
	}

}
