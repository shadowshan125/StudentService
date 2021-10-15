package com.example.demo.RepositoryService;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Definitions.Employee;

public interface EmployeeRepositoryService extends JpaRepository<Employee, Long> {

	@Query("select ln from Employee ln where ln.name like %:name% ")
	public List<Employee> getNames(String name);
}
