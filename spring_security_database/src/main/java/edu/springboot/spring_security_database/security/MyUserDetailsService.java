package edu.springboot.spring_security_database.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import edu.springboot.spring_security_database.model.User;
import edu.springboot.spring_security_database.repository.UserRepositoty;

@Component
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepositoty repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=repo.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("user 404 error");
		}
		return new MyUserDetails(user);
	}

}
