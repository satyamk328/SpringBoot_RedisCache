package com.satyam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.satyam.model.Person;
import com.satyam.repository.PersonRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository repo;
	
	@Cacheable(value = "users")
	public List<Person> findAll() {
		return repo.findAll();
	}

	public Person findById(Long id) {
		return repo.getOne(id);
	}

	public Person save(Person logs) {
		return repo.save(logs);
	}

	@CacheEvict(value = "users", allEntries=true)
	public void clearCache() {
	  log.info("deleting person with id {}");
	}
	
}
