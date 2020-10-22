package com.satyam.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.satyam.model.Person;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	@Query("FROM Person r")
	public List<Person> findAll();
	
	@Query("FROM Person r WHERE r.id=:id ")
	public Optional<Person> findById(String id);
	
	@Query("FROM Person r WHERE lower(r.name) = :name ")
	Optional<Person> findByName(String name);
	
	
}
