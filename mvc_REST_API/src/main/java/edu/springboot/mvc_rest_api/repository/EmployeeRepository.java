package edu.springboot.mvc_rest_api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;

import edu.springboot.mvc_rest_api.model.Employee;

@RestController
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
	

}
