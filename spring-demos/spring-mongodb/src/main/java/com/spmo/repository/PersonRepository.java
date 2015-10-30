package com.spmo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spmo.entity.Person;

public interface PersonRepository extends MongoRepository<Person, String>{
	public Person findByName(String name);
}
