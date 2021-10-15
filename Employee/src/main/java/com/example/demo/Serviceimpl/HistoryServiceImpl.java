
package com.example.demo.Serviceimpl;

import org.springframework.stereotype.Service;

import com.example.demo.Definitions.History;
import com.example.demo.RepositoryService.HistoryRepositoryService;
import com.example.demo.Service.HistoryService;

@Service
public class HistoryServiceImpl implements HistoryService {

	private HistoryRepositoryService hrs;

	public HistoryServiceImpl(HistoryRepositoryService hrs) {
		this.hrs = hrs;
	}

	@Override
	public History Update(History params, long id) {

		History history = hrs.findById(id).get();

		return hrs.save(history);
	}
}
