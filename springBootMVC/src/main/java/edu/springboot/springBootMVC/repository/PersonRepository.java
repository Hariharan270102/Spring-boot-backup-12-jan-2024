package edu.springboot.springBootMVC.repository;

import org.springframework.data.repository.CrudRepository;

import edu.springboot.springBootMVC.model.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {

}
