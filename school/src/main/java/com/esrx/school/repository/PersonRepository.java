package com.esrx.school.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.esrx.school.model.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String>{

	List<Person> findByFirstName(String firstName);
	Optional<Person> findById(String id);
}
