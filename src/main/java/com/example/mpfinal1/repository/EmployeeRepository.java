package com.example.mpfinal1.repository;

import com.example.mpfinal1.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {

    Employee findFirstById(Long id);
}
