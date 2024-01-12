package edu.springboot.spring_security_database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.springboot.spring_security_database.model.User;

public interface UserRepositoty extends JpaRepository<User, Integer> {
	User findByUsername(String username);

}
