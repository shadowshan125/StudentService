package com.example.demo.Serviceimpl;

import com.example.demo.Definitions.Employee;
import com.example.demo.Service.EmployeeService;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.RepositoryService.EmployeeRepositoryService;
import org.springframework.stereotype.Service;
import java.util.List;
		
	@SuppressWarnings("unused")
	@Service
	public class EmployeeServiceImpl implements EmployeeService{
	

	    private final EmployeeRepositoryService ers;
	    public EmployeeServiceImpl(EmployeeRepositoryService ers) {
	        this.ers = ers;
	    }
	

	    @Override
	    public Employee Post(Employee params) {
    	ers.save(params);
	        return params;
	    }

	    @Override
	    public List<Employee> Get() {
	        return ers.findAll();
	    }

		@Override
	    public Employee Get(long empId) {
	        return ers.findById(empId).get();
	    }

	    @Override
	    public Employee Update(Employee params, long empId) {

	       Employee employee =  ers.findById(empId).get();
	       employee.setName(params.getName());
	       employee.setExperience(params.getExperience());
	       employee.setAddress(params.getAddress());
	       employee.setBlood_group(params.getBlood_group());
	       employee.setDateOfJoin(params.getDateOfJoin());
	       employee.setEducation(params.getEducation());
	       employee.setPhone_number(params.getPhone_number());
	       employee.setMartial_status(params.getMartial_status());
	       employee.setNationality(params.getNationality());
	       

	       return ers.save(employee);
	    }

	    
		@Override
	    public String Delete(long empId) {
	        ers.deleteById(empId);
	        return "User(" + empId + ")" + " has been deleted!";
	    }
	}

