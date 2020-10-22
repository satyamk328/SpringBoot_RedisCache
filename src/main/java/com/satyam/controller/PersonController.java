package com.satyam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.satyam.model.Person;
import com.satyam.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@GetMapping("/")
	public ResponseEntity<?> findAll() {
		List<Person> rlist = personService.findAll();
		return new ResponseEntity(rlist, HttpStatus.OK);
	}
	@GetMapping("/byid/")
	public ResponseEntity<?> getById(@PathVariable(name = "id", required = true) Long rId) {
		Person rlist = personService.findById(rId);
		return new ResponseEntity(rlist, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<?> create(@RequestBody(required = true) Person logs) {
		 return new ResponseEntity(personService.save(logs), HttpStatus.OK);
	}
	

	@DeleteMapping("/")
	public ResponseEntity<?> log() {
		personService.clearCache();
		 return new ResponseEntity(null, HttpStatus.OK);
	}

}
