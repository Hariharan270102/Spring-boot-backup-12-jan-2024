package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping
	public String myHome() {
		return "Hi Hello! Welcome to Spring Boot Application";
	}

}
