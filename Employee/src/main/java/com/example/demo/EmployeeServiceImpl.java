package com.example.demo;

	import com.example.demo.Employee;
	import com.example.demo.EmployeeRepository;
	import com.example.demo.Doa.EmployeeDoa;
	import com.example.demo.Doa.SalaryHistoryDoa;
	import com.example.demo.dto.EmployeeSalaryHistoryResponse;

import org.springframework.stereotype.Service;

	import java.util.List;
		
	@Service
	public  class EmployeeServiceImpl implements EmployeeService{
	
		
	    private final EmployeeDoa employeeDoa;
	    private final SalaryHistoryDoa salaryHistoryDoa;
	    public EmployeeServiceImpl(EmployeeDoa employeeDoa,SalaryHistoryDoa salaryHistoryDoa) {
	        this.employeeDoa = employeeDoa;
			this.salaryHistoryDoa = salaryHistoryDoa;

	    }

	    @Override
	    public Employee Post(Employee params) {
    	employeeDoa.save(params);
	        return params;
	    }

	    
	    
	    @Override
	    public List<Employee> Get() {
	        return employeeDoa.findAll();
	    }
	    @Override
	    public List<SalaryHistory> Getsh() {
	        return salaryHistoryDoa.findAll();
	    }
	   
		@Override
	    public Employee Get(long id) {
	        return employeeDoa.findById(id).get();
	    }

	    @Override
	    public Employee Update(Employee params, long id) {

	       Employee employee =  employeeDoa.findById(id).get();
	       employee.setName(params.getName());
	       employee.setCode(params.getCode());

	       return employeeDoa.save(employee);
	    }
	    
	    
		@Override
	    public SalaryHistory UpdateSalary(SalaryHistory params, long id) {

	    	SalaryHistory salaryHistory =  salaryHistoryDoa.findById(id).get();
	    	
	    	salaryHistory.setDateOfIncrement(params.getDateOfIncrement());
	    	salaryHistory.setNewSalary(params.getNewSalary());

	        return salaryHistoryDoa.save(salaryHistory);
	    }

	    @Override
	    public String Delete(long id) {
	    	employeeDoa.deleteById(id);
	        return "User(" + id + ")" + " has been deleted!";
	    }
	}

