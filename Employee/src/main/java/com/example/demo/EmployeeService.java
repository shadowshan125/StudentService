package com.example.demo;

import com.example.demo.Employee;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface EmployeeService {
	Employee Post(Employee params);

    List<Employee> Get();
   
    Employee Get(long id);

    Employee Update(Employee params, long id);

    String Delete(long id);
}
