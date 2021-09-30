package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeSalaryHistoryResponse;
import com.example.demo.EmployeeService;

@RestController
public class EmployeeController {
	
	 	@Autowired
		private final EmployeeService employeeService;
	    public EmployeeController(EmployeeService employeeService, EmployeeRepository employeeRepository, SalaryRepository salaryrepository) {
	        this.employeeService = employeeService;
	    }
	    
	    
	    @RequestMapping("/greeting")
		public String Hello() {
			return "Hi Everyone #";
		}
	    
	    
	    @GetMapping(value = "/employee")
	    public ResponseEntity<Object> Get() {
	        try {
	            List<Employee> result = employeeService.Get();
	            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
	        } catch (Exception e) {
	            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND, null);
	        }
	    }
	    
	    @GetMapping(value = "/salaryhistory")
	    public ResponseEntity<Object> GetSh() {
	        try {
	            List<SalaryHistory> result = employeeService.Getsh();
	            return ResponseHandler.generateResponse("Salary History displayed", HttpStatus.OK, result);
	        } catch (Exception e) {
	            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND, null);
	        }
	    }
	    
	    
	    @GetMapping(value = "/employee/{id}")
	    public ResponseEntity<Object> Get(@PathVariable int id) {
	    	try{
	            Employee result = employeeService.Get(id);
	            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
	        } catch (Exception e)  {
	            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND, null);
			} 
	        /*
				 * else { return ResponseHandler.generateResponse(e.getMessage(),
				 * HttpStatus.MULTI_STATUS, null);
				 * 
				 * }
				 */
	    }
	    
	    @PostMapping(value = "/employee")
	    public ResponseEntity<Object> Post(@RequestBody Employee params) {
	        try {
	            Employee result = employeeService.Post(params);
	            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
	        } catch (Exception e) {
	            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND, null);
	        }

	    }
	    
	    
	   
	    @PutMapping(value = "/employee/{id}")
	    public ResponseEntity<Object> Update(@PathVariable int id, @RequestBody Employee params) {
	        try {
	            Employee result = employeeService.Update(params, id);
	            return ResponseHandler.generateResponse("Updated", HttpStatus.OK, result);
	        } catch (Exception e) {
	            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND, null);
	        }
	    }
	    
	    @PutMapping(value = "/SalaryUpdate/{id}")
	    public ResponseEntity<Object> UpdateSalary(@PathVariable long id, @RequestBody SalaryHistory params) {
	        try {
	            SalaryHistory result = employeeService.UpdateSalary(params, id);
	            return ResponseHandler.generateResponse("Updated", HttpStatus.OK, result);
	        } catch (Exception e) {
	            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND, null);
	        }
	    }

	   
	    @DeleteMapping(value = "/employee/{id}")
	    public ResponseEntity<Object> Delete(@PathVariable int id) {
	        try {
	            String result = employeeService.Delete(id);
	            return ResponseHandler.generateResponse("Deleted!", HttpStatus.OK, result);
	        } catch (Exception e) {
	            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND, null);
	        }
	    }

	}
	//  select code,salary  from  employee,employee salary where employee.code and employeeSalary.salary

	
	
	
	
	
	
	
	
	
	
	
/*
	@Autowired
	EmployeeRepository Repository;

	
	
	@GetMapping(value = "/employee")
	public Iterable<Employee> getAllEmployee() {
		Iterable<Employee> employeeCollection = Repository.findAll();
		return employeeCollection;
	}
	/*@GetMapping(value = "/employee")
	public ResponseEntity<Optional<Employee>> read (@PathVariable ("id")long id) {
		Optional<Employee> foundemployee = Repository.findById(id);
	    if (foundemployee == null) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.ok(foundemployee);
	    }
	}
		

	@GetMapping(value = "/employee", params = { "name" })
	public List<Employee> getEmployee (@RequestParam(value = "name") String name) {
		List<Employee> names = Repository.getNames(name);
		return names;
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET, params = { "id" })
	public ResponseEntity <Employee> getEmployee (@RequestParam(value = "id") long id) {
		Optional<Employee> optionalEmployee = Repository.findById(id);
		//Employee employee = new Employee();
		//employee = optionalEmployee.get();
		
		if (optionalEmployee.isPresent()) {
			return ResponseEntity.ok(optionalEmployee.get());
		}else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        
		}	
	}
	@PostMapping(value = "/employee")
	public ResponseEntity <String> createNewEmployee(@RequestBody Employee newEmployee) {
		 
		 if(newEmployee!=null) {
			 Repository.save(newEmployee);
		 return new ResponseEntity <String>("new employee data created",HttpStatus.OK);
	}else {
		 return new ResponseEntity <String>("No data created, please enter the Correct data in field",HttpStatus.NOT_FOUND);
	}
	}
	@RequestMapping(value = "/employee", method = RequestMethod.DELETE)
	public Employee deleteEmployee(@RequestParam(value = "id") long id) {
		Employee EmployeeToDelete = new Employee();
		Optional<Employee> optionalEmployee = Repository.findById(id);
		if (optionalEmployee.isPresent()) {
			EmployeeToDelete = optionalEmployee.get();
			Repository.deleteById(EmployeeToDelete.getId());
			
		}
		return EmployeeToDelete;
	}

	

	@PutMapping(value = "/employee/{id}")
	public ResponseEntity <String> replaceEmployee(@RequestBody Employee employee) {
		Optional<Employee> optionalEmployee = Repository.findById(employee.getId());
		Employee Employee = new Employee();

		if (optionalEmployee.isPresent()) {
			Employee.setName(employee.getName());
			Employee.setSalary(employee.getSalary());
			Employee.setExperience(employee.getExperience());
			Employee.setAddress(employee.getAddress());
			Employee.setPhone_number(employee.getPhone_number());
			Employee.setNationality(employee.getNationality());
			Employee.setMartial_status(employee.getMartial_status());
			Employee.setEducation(employee.getEducation());
			Employee.setBlood_group(employee.getBlood_group());
			Employee.setCode(employee.getCode());
			Employee.setDateOfJoin(employee.getDateOfJoin());

			Repository.save(employee);
		
		 return new ResponseEntity <String>("employee data Updated",HttpStatus.OK);
		}else {
			return new ResponseEntity <String>("not changed please update correctly",HttpStatus.NOT_FOUND);

		}
	}
		
*/

