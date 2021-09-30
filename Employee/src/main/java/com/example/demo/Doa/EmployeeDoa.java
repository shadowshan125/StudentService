package com.example.demo.Doa;

import java.util.List;
import com.example.demo.dto.EmployeeSalaryHistoryResponse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;

import com.example.demo.Employee;
import com.example.demo.dto.EmployeeSalaryResponse;

public interface EmployeeDoa extends JpaRepository<Employee, Long> {

	 @Query("select ln from Employee ln where ln.name like %:name% ") 
	 public List<Employee> getNames(String name);

	
	
	//  @Query(value="SELECT * FROM employeeSalary" ) //new com.example.demo.dto.EmployeeSalaryResponse( ln.code ,ln1.from employee where  JOIN select s from employeeeSalary where s.salary\"
	//  public List<EmployeeSalaryResponse> getSalary (Integer salary,long code);
	 
		
	
}
