package com.example.demo.controllers;

import java.util.List;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.EmployeeService;
import com.example.demo.Handler.ResponseHandler;
import com.example.demo.RepositoryService.EmployeeRepositoryService;
import com.example.demo.Definitions.Employee;

@RestController
public class EmployeeController {
	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService, EmployeeRepositoryService ers) {
		this.employeeService = employeeService;
	}

	@RequestMapping("/greeting")
	public String Hello() {
		return "Hi Everyone #";
	}
	
	@PostMapping(value = "/employee")
	public ResponseEntity<Object> Post(@Valid @RequestBody Employee params) {
		try {
			try {
				Employee result = employeeService.Post(params);
				return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
			} catch (Exception e) {
				return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST,
						"Check the Input Format");
			}
		} catch (Exception e1) {
			return ResponseHandler.generateResponse(e1.getMessage(), HttpStatus.NOT_FOUND, null);
		}

	}

	@GetMapping(value = "/employee")
	public ResponseEntity<Object> Get() {
		try {
			try {
				List<Employee> result = employeeService.Get();
				return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
			} catch (Exception e) {
				return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, "incorrect Path");
			}
		} catch (Exception e1) {
			return ResponseHandler.generateResponse(e1.getMessage(), HttpStatus.NOT_FOUND, null);
		}

	}

	@GetMapping(value = "/employee/{empId}")
	public ResponseEntity<Object> Get(@PathVariable long empId) {
		try {
			Employee result = employeeService.Get(empId);
			return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND, "incorrect Path");
		}
	}

	@PutMapping(value = "/employee/{empId}")
	public ResponseEntity<Object> Update(@PathVariable long empId, @Valid @RequestBody Employee params) {
		try {
			try {
				Employee result = employeeService.Update(params, empId);
				return ResponseHandler.generateResponse("Updated", HttpStatus.OK, result);
			} catch (Exception e) {
				return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
			}
		} catch (Exception e1) {
			return ResponseHandler.generateResponse(e1.getMessage(), HttpStatus.NOT_FOUND, null);
		}

	}

	@DeleteMapping(value = "/employee/{empId}")
	public ResponseEntity<Object> Delete(@PathVariable long empId) {
		try {
			try {
				String result = employeeService.Delete(empId);
				return ResponseHandler.generateResponse("Deleted!", HttpStatus.OK, result);
			} catch (Exception e) {
				return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
			}
		} catch (Exception e1) {
			return ResponseHandler.generateResponse(e1.getMessage(), HttpStatus.NOT_FOUND, null);
		}

	}

}

/*
 * @Autowired EmployeeRepository Repository;
 * 
 * 
 * 
 * @GetMapping(value = "/employee") public Iterable<Employee> getAllEmployee() {
 * Iterable<Employee> employeeCollection = Repository.findAll(); return
 * employeeCollection; } /*@GetMapping(value = "/employee") public
 * ResponseEntity<Optional<Employee>> read (@PathVariable ("id")long id) {
 * Optional<Employee> foundemployee = Repository.findById(id); if (foundemployee
 * == null) { return ResponseEntity.notFound().build(); } else { return
 * ResponseEntity.ok(foundemployee); } }
 * 
 * 
 * @GetMapping(value = "/employee", params = { "name" }) public List<Employee>
 * getEmployee (@RequestParam(value = "name") String name) { List<Employee>
 * names = Repository.getNames(name); return names; }
 * 
 * @RequestMapping(value = "/employee", method = RequestMethod.GET, params = {
 * "id" }) public ResponseEntity <Employee> getEmployee (@RequestParam(value =
 * "id") long id) { Optional<Employee> optionalEmployee =
 * Repository.findById(id); //Employee employee = new Employee(); //employee =
 * optionalEmployee.get();
 * 
 * if (optionalEmployee.isPresent()) { return
 * ResponseEntity.ok(optionalEmployee.get()); }else { return new
 * ResponseEntity<>(HttpStatus.NOT_FOUND);
 * 
 * } }
 * 
 * @PostMapping(value = "/employee") public ResponseEntity <String>
 * createNewEmployee(@RequestBody Employee newEmployee) {
 * 
 * if(newEmployee!=null) { Repository.save(newEmployee); return new
 * ResponseEntity <String>("new employee data created",HttpStatus.OK); }else {
 * return new ResponseEntity
 * <String>("No data created, please enter the Correct data in field",HttpStatus
 * .NOT_FOUND); } }
 * 
 * @RequestMapping(value = "/employee", method = RequestMethod.DELETE) public
 * Employee deleteEmployee(@RequestParam(value = "id") long id) { Employee
 * EmployeeToDelete = new Employee(); Optional<Employee> optionalEmployee =
 * Repository.findById(id); if (optionalEmployee.isPresent()) { EmployeeToDelete
 * = optionalEmployee.get(); Repository.deleteById(EmployeeToDelete.getId());
 * 
 * } return EmployeeToDelete; }
 * 
 * 
 * 
 * @PutMapping(value = "/employee/{id}") public ResponseEntity <String>
 * replaceEmployee(@RequestBody Employee employee) { Optional<Employee>
 * optionalEmployee = Repository.findById(employee.getId()); Employee Employee =
 * new Employee();
 * 
 * if (optionalEmployee.isPresent()) { Employee.setName(employee.getName());
 * Employee.setSalary(employee.getSalary());
 * Employee.setExperience(employee.getExperience());
 * Employee.setAddress(employee.getAddress());
 * Employee.setPhone_number(employee.getPhone_number());
 * Employee.setNationality(employee.getNationality());
 * Employee.setMartial_status(employee.getMartial_status());
 * Employee.setEducation(employee.getEducation());
 * Employee.setBlood_group(employee.getBlood_group());
 * Employee.setCode(employee.getCode());
 * Employee.setDateOfJoin(employee.getDateOfJoin());
 * 
 * Repository.save(employee);
 * 
 * return new ResponseEntity <String>("employee data Updated",HttpStatus.OK);
 * }else { return new ResponseEntity
 * <String>("not changed please update correctly",HttpStatus.NOT_FOUND);
 * 
 * } }
 * 
 */
