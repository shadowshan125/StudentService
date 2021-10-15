
package com.example.demo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.HistoryService;
import com.example.demo.Handler.ResponseHandler;
import com.example.demo.Definitions.History;

@RestController
public class HistoryController {

	private final HistoryService historyService;

	public HistoryController(HistoryService historyService) {
		super();
		this.historyService = historyService;
	}

	@PutMapping(value = "/revision/{id}")
	public ResponseEntity<Object> Update(@PathVariable int id, @RequestBody History params) {
		try {
			History result = historyService.Update(params, id);
			return ResponseHandler.generateResponse("Updated", HttpStatus.OK, result);
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

}
