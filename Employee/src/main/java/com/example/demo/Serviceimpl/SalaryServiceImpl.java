package com.example.demo.Serviceimpl;


import com.example.demo.Definitions.Salary;
import com.example.demo.Service.SalaryService;
import com.example.demo.RepositoryService.SalaryRepositoryService;

import org.springframework.stereotype.Service;
		
	@Service
	public class SalaryServiceImpl implements SalaryService{
	
	    private final SalaryRepositoryService srs;
	    public SalaryServiceImpl(SalaryRepositoryService srs) {
	        this.srs = srs;
	    }
	
	   
		@Override
	    public Salary Update(Salary params,int id) {
    	Salary salary =  srs.findById(id).get();
    	return srs.save(salary);	   
    	}


		}
	
