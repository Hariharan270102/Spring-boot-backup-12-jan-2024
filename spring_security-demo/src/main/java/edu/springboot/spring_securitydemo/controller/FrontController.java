package edu.springboot.spring_securitydemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FrontController {
	@RequestMapping("/public")
	@ResponseBody
	public String publicUser() {
		return "I am a public user";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping("/admin")
	@ResponseBody
	public String adminUser() {
		return "I am admin";
	}
	
	@RequestMapping("/customer")
	@ResponseBody
	public String customer() {
		return "I am a customer ";
	}

}
