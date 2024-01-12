package edu.springboot.mvc_rest_api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.springboot.mvc_rest_api.model.Employee;
import edu.springboot.mvc_rest_api.repository.EmployeeRepository;
import edu.springboot.mvc_rest_api.service.EmployeeService;

@RestController
public class EmployeeFrontController {
	@Autowired
	EmployeeService eService;

	@GetMapping("/")

	public String sayHello(){

	return "Hi";

	} 
	
	@GetMapping("/employee")
	public ArrayList<Employee> getEmployee() {
		return eService.getEmps();
		
	}
	
	@GetMapping("/employee/{eid}")
	public Employee getEmp(@PathVariable("eid")int eid) {
		return eService.getEmp(eid);
	}
	
	@PostMapping("/employee")
	public Employee postEmp(@RequestBody Employee emp) {
		return eService.postEmployee(emp);
	}
	
	
	@PutMapping("/employee")
	public Employee putEmp(@RequestBody Employee employee) {
		return eService.updateEmp(employee);
	}
	
	@DeleteMapping("/employee/{eid}")
	public String deleteEmp(@PathVariable("eid") int eid) {
		eService.deleteEmp(eid);
		return "deleted";
	}
	

}
