package edu.springboot.mvc1.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.springboot.mvc1.model.Employee;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	@Query(value = "select * from employee where dept=:dd",nativeQuery = true)
	List<Employee> findByDept(@Param("dd")String dept);
	List<Employee> findByEid(int id);
	List<Employee> findByEname(String ename);
	List<Employee> findBySalary(int salary);
	
	@Modifying
	@Query(value="delete from employee where ename=:dd",nativeQuery = true)
	void deleteByName(@Param("dd")String data);
	
	@Modifying
	@Query(value="delete from employee where dept=:dd",nativeQuery = true)
	void deleteDept(@Param("dd")String data);
	

}
