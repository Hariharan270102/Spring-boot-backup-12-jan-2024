package edu.springboot.mvc_rest_api.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu.springboot.mvc_rest_api.model.Employee;
import edu.springboot.mvc_rest_api.repository.EmployeeRepository;

@Service
@Component
public class EmployeeService {
	@Autowired
	EmployeeRepository repo;

	public ArrayList<Employee> getEmps() {
		// TODO Auto-generated method stub
		return (ArrayList<Employee>) repo.findAll();
		
	}

	public Employee getEmp(int eid) {
		// TODO Auto-generated method stub
		Optional<Employee> employee=repo.findById(eid);
		if(employee.isPresent()) {
			return employee.get();
		}
		else {
			return null;
		}
		
	}

	public Employee postEmployee(Employee emp) {
		return repo.save(emp);
		
	}

	public Employee updateEmp(Employee emp) {
		// TODO Auto-generated method stub
		return repo.save(emp);
		
		
	}

	public void deleteEmp(int eid) {
		// TODO Auto-generated method stub
		repo.deleteById(eid);
		
	}

}
