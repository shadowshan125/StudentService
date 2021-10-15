package com.example.demo.Service;


import org.springframework.stereotype.Component;
import java.util.List;
import java.util.UUID;

import com.example.demo.Definitions.Employee;

@Component
public interface EmployeeService {
	Employee Post(Employee params);

    List<Employee> Get();
   
    Employee Get(long id);

    Employee Update(Employee params, long id);

    String Delete(long id);

}
