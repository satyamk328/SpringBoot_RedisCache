package com.satyam.service;

import java.util.List;

import com.satyam.model.Person;

public interface PersonService {

	public List<Person> findAll();

	public Person findById(Long id);

	public Person save(Person logs);
	
	public void clearCache();

}
