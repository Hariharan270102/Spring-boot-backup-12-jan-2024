package edu.springboot.mvc.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu.springboot.mvc.model.Employee;

@Service
@Component
public class EmployeeService {
	ArrayList<Employee> emplist=new ArrayList<>();
	public String addEmployee(Employee emp) {
		emplist.add(emp);
		return "Employee added successfully!";
	}
	public ArrayList<Employee> viewEmployees(){
		return emplist;
	}

}
