package edu.springboot.spring_securitydemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {
	@Bean
	public SecurityFilterChain mySecurityConfig(HttpSecurity hs) throws Exception
	{
		hs.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/public")
		.permitAll()
		.requestMatchers("/admin")
		.hasRole("ADMIN")
		.requestMatchers("/customer")
		.hasRole("CUSTOMER")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
		
		return hs.build();
		
	}
	
	@Bean
	public UserDetailsService userCredentialsService()
	{
		UserDetails adminCredentials=User.withUsername("admin").password(passwordEncoder().encode("reset@123"))
				.roles("ADMIN").build();
		
		UserDetails customerCredentials=User.withUsername("customer").password(passwordEncoder().encode("customer@123"))
				.roles("CUSTOMER").build();
		
		InMemoryUserDetailsManager myUserDetails= 
				new InMemoryUserDetailsManager(adminCredentials,customerCredentials);
		return myUserDetails;
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	

}
