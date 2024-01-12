package edu.springboot.spring_security_database;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.springboot.spring_security_database.repository.UserRepositoty;

@SpringBootApplication
public class SpringSecurityDatabaseApplication {
	
//	@Bean
//	public CommandLineRunner createUser(UserRepositoty repo)
//	{
//		
//	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDatabaseApplication.class, args);
	}

}
