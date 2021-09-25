package com.example.demo;

	import com.example.demo.Employee;
	import com.example.demo.EmployeeRepository;

	import org.springframework.stereotype.Service;

	import java.util.List;
		
	@Service
	public class EmployeeServiceImpl implements EmployeeService{
	

	    private final EmployeeRepository employeeRepository;
	    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
	        this.employeeRepository = employeeRepository;
	    }
	

    @Override
	    public Employee Post(Employee params) {
	        employeeRepository.save(params);
	        return params;
	    }

	    @Override
	    public List<Employee> Get() {
	        return employeeRepository.findAll();
	    }

		@Override
	    public Employee Get(long id) {
	        return employeeRepository.findById(id).get();
	    }

	    @Override
	    public Employee Update(Employee params, long id) {

	       Employee employee =  employeeRepository.findById(id).get();
	       employee.setName(params.getName());
	       employee.setCode(params.getCode());

	       return employeeRepository.save(employee);
	    }

	    @Override
	    public String Delete(long id) {
	        employeeRepository.deleteById(id);
	        return "User(" + id + ")" + " has been deleted!";
	    }
	}

