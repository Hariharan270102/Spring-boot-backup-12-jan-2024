package edu.springboot.spring_security_database.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class FrontController 
{
	@GetMapping("/public")
	public ResponseEntity<String> publicUser(){
		return ResponseEntity.ok("I am a public user");
	}
	
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> adminUser(){
		return ResponseEntity.ok("I am admin");
	}
	
	@GetMapping("/customer")
	@PreAuthorize("hasRole('CUSTOMER')")

	public ResponseEntity<String> customer(){
		return ResponseEntity.ok("I am a customer");
	}
	

}
