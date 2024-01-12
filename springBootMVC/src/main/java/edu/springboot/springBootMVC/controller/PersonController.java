package edu.springboot.springBootMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.springboot.springBootMVC.model.Person;
import edu.springboot.springBootMVC.repository.PersonRepository;

@Controller
public class PersonController {
	@Autowired
	private Person person;
	@Autowired
	private PersonRepository repo;
	
	@RequestMapping("/")
	public String Homepage() {
		return "index.jsp";
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public String createPerson(Person person) {
		repo.save(person);
//		person.setName("Hari");
//		person.setHobby("Playing cricket");
//		repo.save(person);
		return "Person Created Successfully!!!";
	}
	
	@RequestMapping("/view")
	@ResponseBody
	public String viewPerson() {
		return repo.findAll().toString();
	}

}
