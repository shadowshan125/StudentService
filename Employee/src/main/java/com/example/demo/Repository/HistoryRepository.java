
package com.example.demo.Repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.RepositoryService.HistoryRepositoryService;

public class HistoryRepository {

	@Autowired
	private HistoryRepositoryService hrs;

	public HistoryRepositoryService gethrs() {
		return hrs;
	}

	public void setShrs(HistoryRepositoryService hrs) {
		this.hrs = hrs;
	}

}
