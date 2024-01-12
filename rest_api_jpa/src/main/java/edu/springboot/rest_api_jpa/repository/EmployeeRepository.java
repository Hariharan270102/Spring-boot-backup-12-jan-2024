package edu.springboot.rest_api_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.springboot.rest_api_jpa.model.Employee;

@RepositoryRestResource(collectionResourceRel = "employee",path = "employee")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
